package bibliotecas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LeStringTeclado {
    public static void main(String[] args) {

        System.out.print("Digite uma frase: ");

        //InputStream sabe capturar um bye
        InputStream is = System.in;

        //InputStreamReader sabe rebecer um byte e transofrmar em char
        InputStreamReader isr = new InputStreamReader(is);

        BufferedReader bfr = new BufferedReader(isr);

        String s;
        try {
            s = bfr.readLine();
            System.out.println("Você digitou a frase: " +s);
        }
        catch (IOException e ){
            e.printStackTrace();
        }
    }
}
