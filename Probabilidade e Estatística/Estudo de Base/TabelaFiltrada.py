import pandas as pd
from tabulate import tabulate

# Ler o arquivo .csv
df = pd.read_csv('base.csv')

# Remover linhas com qualquer dado nulo
df = df.dropna()

# Substituir zeros por NaN e depois remover linhas com NaN
df = df.replace(0, pd.NA).dropna()

# Definir os padrões de códigos que queremos filtrar
patterns = ['2']

# Filtrar os códigos da receita tributária que iniciam com os padrões definidos
filtered_df = df[df['Código da Receita Tributária'].astype(str).str.startswith(tuple(patterns))]

# Formatando as colunas desejadas
filtered_df['Código da Receita Tributária'] = filtered_df['Código da Receita Tributária'].map('{:.2f}'.format)
filtered_df['Valor da Receita Tributária'] = filtered_df['Valor da Receita Tributária'].map('R$ {:,.2f}'.format)
filtered_df['Percentual do PIB'] = filtered_df['Percentual do PIB'].map('{:.2f}%'.format)

# Ordenar por Ano-calendário e Código da Receita Tributária
filtered_df = filtered_df.sort_values(by=['Ano-calendário', 'Código da Receita Tributária'])

# Exibir os valores onde o código da receita tributária inicia com o número 2
print("### Valores onde o Código da Receita Tributária inicia com '2' ###")
print(tabulate(filtered_df, headers='keys', tablefmt='pretty'))
