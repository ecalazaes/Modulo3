import pandas as pd

# Caminho para o seu arquivo .csv
caminho_arquivo = 'C:/Users/36129382023.1n/Documents/Modulo3/Probabilidade e Estatística/Base de Dados/base.csv'

# Ler o arquivo .csv
df = pd.read_csv(caminho_arquivo)

# Exibir as primeiras linhas do DataFrame
print(df.head())
