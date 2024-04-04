package aula2_Aula3_Exercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        ArrayList<Integer> listaDeNumeros2 = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Entre com um numero: ");
            int numero = Integer.parseInt(sc.nextLine());
            listaDeNumeros2.add(numero);
        }
        System.out.println(listaDeNumeros2);
    }
}
