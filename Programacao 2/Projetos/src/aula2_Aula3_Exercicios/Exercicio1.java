package aula2_Aula3_Exercicios;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        ArrayList<String> listaDePalavras = new ArrayList<>();
//
//        for (int i = 0; i < 3; i++) {
//            System.out.print("Digite uma palavra: ");
//            String palavra = sc.nextLine();
//            listaDePalavras.add(palavra);
//        }
//        System.out.println("As palavras são: " + listaDePalavras);

        Scanner sc = new Scanner(System.in);
        String[] listaPalavras = new String[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Informe uma palavra: ");
            listaPalavras[i] = sc.nextLine();
        }

        System.out.println(Arrays.toString(listaPalavras));

        sc.close();
    }
}
