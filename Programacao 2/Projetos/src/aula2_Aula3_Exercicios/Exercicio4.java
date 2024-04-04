package aula2_Aula3_Exercicios;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        String nota1string = "";
        double nota1 = 0;

        System.out.print("Digite a nota1: ");
        try {
             nota1string = (dataIn.readLine());
             nota1 = Double.parseDouble(nota1string);

        } catch (
                IOException e) {
            System.out.println("Erro!");
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a nota2: ");
        double nota2 = Double.parseDouble(sc.nextLine());


        String nota3string = JOptionPane.showInputDialog("Digite a terceira nota: ");
        double nota3 = 0;
        try {
            nota3 = Double.parseDouble(nota3string);
        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada não é um número válido!");
            return;
        }


        double media = (nota1 + nota2 + nota3) / 3;
        System.out.println("Nota 01: " + nota1);
        System.out.println("Nota 02: " + nota2);
        System.out.println("Nota 03: " + nota3);
        System.out.println("A média foi "+media+"!");


       if (media >= 6 ) {
           System.out.println("Aluno Aprovado");
       } else {
           System.out.println("Aluno Reprovado!");
       }
    }
}
