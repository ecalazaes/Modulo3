package aula2_Aula3_Exercicios;

import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] registros = new String[3][2];

        for (int i = 0; i < registros.length; i++) {
            System.out.println("Digite o nome da pessoa " + (i+1) + ": ");
            registros[i][0] = scanner.nextLine();
            System.out.println("Digite o telefone da pessoa " + (i+1) + ": ");
            registros[i][1] = scanner.nextLine();
        }

        for (int i = 0; i < registros.length; i++) {
            String nome = registros[i][0];
            String telefone = registros[i][1];
            System.out.println("Nome: " + nome + ", Telefone: " + telefone);
        }
    }
}

