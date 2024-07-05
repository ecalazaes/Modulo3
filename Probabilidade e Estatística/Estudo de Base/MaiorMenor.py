import pandas as pd
from tabulate import tabulate

# Ler o arquivo .csv
df = pd.read_csv('C:/Users/lekiz/OneDrive/Documentos/Estudos/Módulo 3/Probabilidade e Estatística/Estudo de Base/base.csv')

# Remover linhas com qualquer dado nulo
df = df.dropna()

# Substituir zeros por NaN e depois remover linhas com NaN
df = df.replace(0, pd.NA).dropna()

# Definir os padrões de códigos que queremos filtrar
patterns = ['2110', '2120', '2200', '2900']

# Filtrar os códigos da receita tributária que iniciam com os padrões definidos
filtered_df = df[df['Código da Receita Tributária'].astype(str).str.startswith(tuple(patterns))]

# Formatando as colunas desejadas
filtered_df['Código da Receita Tributária'] = filtered_df['Código da Receita Tributária'].map('{:.2f}'.format)
filtered_df['Valor da Receita Tributária'] = filtered_df['Valor da Receita Tributária'].map('R$ {:,.2f}'.format)
filtered_df['Percentual do PIB'] = filtered_df['Percentual do PIB'].map('{:.2f}%'.format)

# Ordenar por Ano-calendário e Código da Receita Tributária
filtered_df = filtered_df.sort_values(by=['Ano-calendário', 'Código da Receita Tributária'])

# Encontrar o maior e o menor gasto por ano-calendário, excluindo códigos que terminam em '0'
filtered_df = filtered_df[~filtered_df['Código da Receita Tributária'].str.endswith('.00')]

# Converter 'Valor da Receita Tributária' para float
filtered_df['Valor da Receita Tributária'] = filtered_df['Valor da Receita Tributária'].replace('R\$ ', '', regex=True).replace(',', '', regex=True).astype(float)

# Encontrar os índices dos maiores e menores valores por ano-calendário
max_indices = filtered_df.groupby('Ano-calendário')['Valor da Receita Tributária'].idxmax()
min_indices = filtered_df.groupby('Ano-calendário')['Valor da Receita Tributária'].idxmin()

# Selecionar os dados correspondentes aos índices encontrados
max_values = filtered_df.loc[max_indices]
min_values = filtered_df.loc[min_indices]

# Exibir os valores máximos e mínimos formatados
print("### Maior Gasto por Ano-calendário ###")
print(tabulate(max_values, headers='keys', tablefmt='pretty'))
print()

print("### Menor Gasto por Ano-calendário ###")
print(tabulate(min_values, headers='keys', tablefmt='pretty'))

