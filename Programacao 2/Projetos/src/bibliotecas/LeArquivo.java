package bibliotecas;

import java.io.*;

public class LeArquivo {
    public static void main(String[] args) throws IOException {

        InputStream is = new FileInputStream("teste.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bfr = new BufferedReader(isr);

        String s;

        while ((s = bfr.readLine()) != null) {
            System.out.println(s);
        }
    }
}
