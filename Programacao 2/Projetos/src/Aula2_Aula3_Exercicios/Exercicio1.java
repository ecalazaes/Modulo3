package Aula2_Aula3_Exercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> listaDePalavras = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.print("Digite uma palavra: ");
            String word = sc.nextLine();
            listaDePalavras.add(word);
        }

        System.out.println("As palavras são: " + listaDePalavras);
    }
}
