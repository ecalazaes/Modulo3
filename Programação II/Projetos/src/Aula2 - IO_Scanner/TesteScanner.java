package aula2_IO_Scanner;

import java.util.Scanner;

public class TesteScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String name = sc.nextLine();
        System.out.println("Olá, " +name+"!");
    }
}
