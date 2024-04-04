package aula2_Aula3_Exercicios;

import javax.swing.*;

public class Exercicio6 {
    public static void main(String[] args) {
        String nome = "";
        nome = JOptionPane.showInputDialog("Insira seu nome: ");

        for (int i = 0; i < 100 ; i++) {
            System.out.println(nome + " " + i + "°");
        }

        String nome2 = "";
        nome2 = JOptionPane.showInputDialog("Insira seu nome2: ");

        int x = 0;
        while ( x < 100) {
            System.out.println(nome2 + " " + x + "°");
            x++;
        }

        String nome3 = "";
        nome3 = JOptionPane.showInputDialog("Insira seu nome3: ");

        int z = 0;
        do {
            System.out.println(nome3 + " " + z + "°");
            z++;
        } while (z < 100);


    }
}
