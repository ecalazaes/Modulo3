package aula2_Aula3_Exercicios;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int base = Integer.parseInt(sc.nextLine());

        System.out.println("Digite um numero: ");
        int expoente = Integer.parseInt(sc.nextLine());

        double resultado = 1;
        double resultado2 = 1;
        double resultado3= 1;

        for (int i = 0; i < expoente ; i++) {
            resultado *= base;
        }

        int z = 0;
        while (z < expoente) {
            resultado2 *= base;
            z++;
        }

        int x = 0;
        do {
            resultado3 *= base;
            x++;
        } while (x < expoente);


        System.out.println(base + " elevado a " + expoente  + " é = " + resultado);
        System.out.println(base + " elevado a " + expoente  + " é = " + resultado2);
        System.out.println(base + " elevado a " + expoente  + " é = " + resultado3);
    }
}
