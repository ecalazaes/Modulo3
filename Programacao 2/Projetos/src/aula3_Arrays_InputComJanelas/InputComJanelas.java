package aula3_Arrays_InputComJanelas;

import javax.swing.*;

public class InputComJanelas {
    public static void main(String[] args) {
        String nome = "";
        nome = JOptionPane.showInputDialog("Insira seu nome: ");
        String msg = "Olá, "+nome+"!";
        System.out.println(msg);
        JOptionPane.showMessageDialog(null, msg);
    }
}
