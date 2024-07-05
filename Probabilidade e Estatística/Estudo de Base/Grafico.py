import pandas as pd
import matplotlib.pyplot as plt
from tabulate import tabulate

# Ler o arquivo .csv
df = pd.read_csv('C:/Users/lekiz/OneDrive/Documentos/Estudos/Módulo 3/Probabilidade e Estatística/Estudo de Base/base.csv')

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

# Agrupar por 'Família' e somar os valores
grouped_df = filtered_df.groupby('Família')['Valor da Receita Tributária'].sum().reset_index()

# Ordenar os valores do maior para o menor
grouped_df = grouped_df.sort_values(by='Valor da Receita Tributária', ascending=False)

# Plotar o gráfico de barras
plt.figure(figsize=(12, 8))
bars = plt.bar(grouped_df['Família'], grouped_df['Valor da Receita Tributária'], color='skyblue')
plt.xlabel('Tributos sobre a Folha de Salários')
plt.ylabel('Valor da Receita Tributária (em bilhões)')
plt.title('Gastos totais Consolidados do Maior para o Menor - de 2002 a 2021')
plt.xticks(rotation=45, ha='right')

# Adicionar rótulos de valores acima das barras
for bar in bars:
    height = bar.get_height()
    plt.annotate(f'R$ {height:,.2f}',
                 xy=(bar.get_x() + bar.get_width() / 2, height),
                 xytext=(0, 3),  # 3 points vertical offset
                 textcoords="offset points",
                 ha='center', va='bottom')

plt.tight_layout()
plt.show()

# Exibir a tabela formatada
filtered_df.loc[:, 'Código da Receita Tributária'] = filtered_df['Código da Receita Tributária'].map('{:.2f}'.format)
filtered_df.loc[:, 'Valor da Receita Tributária'] = filtered_df['Valor da Receita Tributária'].map('R$ {:,.2f}'.format)
filtered_df.loc[:, 'Percentual do PIB'] = filtered_df['Percentual do PIB'].map('{:.2f}%'.format)

filtered_df = filtered_df.sort_values(by=['Ano-calendário', 'Código da Receita Tributária'])

print("### Tabela Filtrada para Códigos Iniciados em '2110', '2120', '2200' e '2900' ###")
print(tabulate(filtered_df, headers='keys', tablefmt='pretty'))


