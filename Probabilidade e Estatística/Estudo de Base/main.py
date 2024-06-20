import pandas as pd
from tabulate import tabulate

# Ler o arquivo .csv
df = pd.read_csv('C:/Users/lekiz/OneDrive/Documentos/Estudos/Módulo 3/Probabilidade e Estatística/Estudo de Base/base.csv')

# Remover linhas com qualquer dado nulo
df = df.dropna()

# Substituir zeros por NaN e depois remover linhas com NaN
df = df.replace(0, pd.NA).dropna()

# Exibir a tabela formatada
print(tabulate(df, headers='keys', tablefmt='pretty'))
