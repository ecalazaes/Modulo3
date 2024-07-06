import pandas as pd
import matplotlib.pyplot as plt

# Ler o arquivo .csv
df = pd.read_csv('base.csv')

# Remover linhas com qualquer dado nulo
df = df.dropna()

# Substituir zeros por NaN e depois remover linhas com NaN
df = df.replace(0, pd.NA).dropna()


# Definir os padrões de códigos que queremos filtrar
patterns = ['2110', '2120', '2200', '2900']

# Mapeamento dos padrões para os nomes dos grupos
group_names = {
    '2110': 'Empregador',
    '2120': 'Empregado',
    '2200': 'Seguro Desemprego',
    '2900': 'Outros'
}

# Filtrar os códigos da receita tributária que iniciam com os padrões definidos
filtered_df = df[df['Código da Receita Tributária'].astype(str).str.startswith(tuple(patterns))].copy()

# Adicionar coluna de família
def identify_family(code):
    for pattern in patterns:
        if str(code).startswith(pattern):
            return group_names[pattern]
    return None

filtered_df['Família'] = filtered_df['Código da Receita Tributária'].apply(identify_family)

# Convertendo 'Valor da Receita Tributária' para numérico para somar os valores
filtered_df['Valor da Receita Tributária'] = pd.to_numeric(filtered_df['Valor da Receita Tributária'], errors='coerce')

# Agrupar por 'Família', 'Ano-calendário' e somar os valores
grouped_df = filtered_df.groupby(['Família', 'Ano-calendário'])['Valor da Receita Tributária'].sum().reset_index()


# Plotar o gráfico de linhas com pontos
plt.figure(figsize=(12, 8))

# Loop para plotar cada categoria como uma linha separada
for family in group_names.values():
    data = grouped_df[grouped_df['Família'] == family]
    plt.plot(data['Ano-calendário'], data['Valor da Receita Tributária'], marker='o', label=family)

# Ajustando os valores do eixo Y para bilhões
plt.yticks([i * 1e5 for i in range(8)], [f'{i}' for i in range(8)])

plt.xlabel('Ano-calendário')
plt.ylabel('Valor da Receita Tributária (em bilhões)')
plt.title('Arrecadação por Categoria ao Longo dos Anos')
plt.legend()
plt.grid(True)
plt.xticks(range(2002, 2022), rotation=45, ha='right')  # Definindo os anos no eixo x de 2002 a 2021
plt.tight_layout()
plt.show()
