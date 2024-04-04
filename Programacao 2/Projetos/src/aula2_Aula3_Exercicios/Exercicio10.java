package aula2_Aula3_Exercicios;

public class Exercicio10 {
    public static void main(String[] args) {
        // Criar um array bidimensional de strings para armazenar nomes e telefones
        String[][] registros = {
                {"Erick", "988420291"},
                {"Daniele", "983085378"},
                {"Ronaldo", "996637709"}
        };

        // Iterar sobre os registros e imprimir os nomes e telefones
        for (int i = 0; i < registros.length; i++) {
            String nome = registros[i][0];
            String telefone = registros[i][1];
            System.out.println("Nome: " + nome + ", Telefone: " + telefone);
        }
    }
}
