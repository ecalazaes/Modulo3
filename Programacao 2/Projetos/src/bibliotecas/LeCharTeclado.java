package bibliotecas;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LeCharTeclado {
    public static void main(String[] args) {

        System.out.print("Digite uma tecla: ");

        //InputStream sabe capturar um bye
        InputStream is = System.in;

        //InputStreamReader sabe rebecer um byte e transofrmar em char
        InputStreamReader isr = new InputStreamReader(is);

        char c;

        try {
            c = (char) isr.read();
            System.out.println("Você digitou a tecla: " +c);
        }
        catch (IOException e ) {
            e.printStackTrace();
        }



    }
}
