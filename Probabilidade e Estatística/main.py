import math

ortopedia = [119, 128, 118, 109, 131, 140, 118, 133, 143, 135, 116, 129, 125, 133, 125, 115, 115, 129, 115, 121, 117, 115, 124, 115, 107, 101, 141, 119, 134, 119]

desvios_quadrados = [round(valor - 122.96) ** 2 for valor in ortopedia]

print(desvios_quadrados)
print(f'Variância Amostral: {sum(desvios_quadrados) / 29:.3f}')
print(f'Desvio Padrão: {math.sqrt(sum(desvios_quadrados) / 29):.3f}')
print(f'Coeficiente de Variação: {math.sqrt(sum(desvios_quadrados) / 29) / 122.96 * 100:.3f}')




