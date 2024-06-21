import pandas as pd
from tabulate import tabulate

# Ler o arquivo .csv
df = pd.read_csv('C:/Users/lekiz/OneDrive/Documentos/Estudos/Módulo 3/Probabilidade e Estatística/Estudo de Base/base.csv')

# Remover linhas com qualquer dado nulo
df = df.dropna()

# Substituir zeros por NaN e depois remover linhas com NaN
df = df.replace(0, pd.NA).dropna()

# Formatando as colunas desejadas
df['Código da Receita Tributária'] = df['Código da Receita Tributária'].map('{:.2f}'.format)
df['Valor da Receita Tributária'] = df['Valor da Receita Tributária'].map('R$ {:,.2f}'.format)
df['Percentual do PIB'] = df['Percentual do PIB'].map('{:.2f}%'.format)

# Ordenar por Ano-calendário e Código da Receita Tributária
df = df.sort_values(by=['Ano-calendário', 'Código da Receita Tributária'])

# Exibir a tabela formatada
print("### Tabela Completa ###")
print(tabulate(df, headers='keys', tablefmt='pretty'))

# Encontrar os maiores valores de Valor da Receita Tributária por Ano-calendário
# max_values = df.loc[df.groupby('Ano-calendário')['Valor da Receita Tributária'].idxmax()]

# Exibir os maiores valores de Valor da Receita Tributária por Ano-calendário
# print("\n### Maiores Valores por Ano-calendário ###")
# print(tabulate(max_values, headers='keys', tablefmt='pretty'))
