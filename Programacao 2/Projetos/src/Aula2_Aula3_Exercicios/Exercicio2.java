package Aula2_Aula3_Exercicios;

import javax.swing.*;

public class Exercicio2 {
    public static void main(String[] args) {
        String word1,word2,word3 = "";
        word1 = JOptionPane.showInputDialog("Digite a primeira palavra: ");
        word2 = JOptionPane.showInputDialog("Digite a segunda palavra: ");
        word3 = JOptionPane.showInputDialog("Digite a terceira palavra: ");
        String msg = "Palavras: "+word1+", "+word2+", "+word3+".";
        System.out.println(msg);
        JOptionPane.showMessageDialog(null, msg);
    }
}
