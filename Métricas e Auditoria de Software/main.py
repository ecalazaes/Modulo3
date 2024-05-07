import math

ortopedia = [119, 128, 118, 109, 131, 140, 118, 133, 143, 135, 116, 129, 125, 133, 125, 115, 115, 129, 115, 121, 117, 115, 124, 115, 107, 101, 141, 119, 134, 119]

prenatal = [108,128,122,119,131,140,121,133,153,135,106,129,120,133,125,115,115,129,100,149,117,115,124,116,97,111,141,119,120,121]

desvios_quadrados = [round(valor - 122.96) ** 2 for valor in ortopedia]

print(f'Desvios quadrados: {desvios_quadrados}')
print(f'Variância Amostral: {sum(desvios_quadrados) / 29:.3f}')
print(f'Desvio Padrão: {math.sqrt(sum(desvios_quadrados) / 29):.3f}')
print(f'Coeficiente de Variação: {math.sqrt(sum(desvios_quadrados) / 29) / 122.96 * 100:.3f}')

ortopedia.sort()
prenatal.sort()
print(ortopedia)
print(prenatal)