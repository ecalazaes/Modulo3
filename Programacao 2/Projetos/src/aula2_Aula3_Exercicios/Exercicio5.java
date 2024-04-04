package aula2_Aula3_Exercicios;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com um número de 1 a 10: ");
        int op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1:
                System.out.println("O número "+op+" por extenso é UM !");
                break;
            case 2:
                System.out.println("O número "+op+" por extenso é DOIS !");
                break;
            case 3:
                System.out.println("O número "+op+" por extenso é TRÊS !");
                break;
            case 4:
                System.out.println("O número "+op+" por extenso é QUARTO !");
                break;
            case 5:
                System.out.println("O número "+op+" por extenso é CINCO !");
                break;
            case 6:
                System.out.println("O número "+op+" por extenso é SEIS !");
                break;
            case 7:
                System.out.println("O número "+op+" por extenso é SETE !");
                break;
            case 8:
                System.out.println("O número "+op+" por extenso é OITO !");
                break;
            case 9:
                System.out.println("O número "+op+" por extenso é NOVE !");
                break;
            case 10:
                System.out.println("O número "+op+" por extenso é DEZ !");
                break;
            default:
                System.out.println("Número inválido");
        }

        if (op == 1) {
            System.out.println("O número "+op+" por extenso é UM !");
        } else if (op == 2) {
            System.out.println("O número "+op+" por extenso é DOIS !");
        } else if (op == 3) {
            System.out.println("O número "+op+" por extenso é TRÊS !");
        } else if (op == 4) {
            System.out.println("O número "+op+" por extenso é QUARTO !");
        } else if (op == 5) {
            System.out.println("O número "+op+" por extenso é CINCO !");
        } else if (op == 6) {
            System.out.println("O número "+op+" por extenso é SEIS !");
        } else if (op == 7) {
            System.out.println("O número "+op+" por extenso é SETE !");
        } else if (op == 8) {
            System.out.println("O número "+op+" por extenso é OITO !");
        } else if (op == 9) {
            System.out.println("O número "+op+" por extenso é NOVE !");
        } else if (op == 10) {
            System.out.println("O número "+op+" por extenso é DEZ !");
        } else {
            System.out.println("Número inválido");
        }
    }
}
