package bibliotecas;

import java.io.*;

public class EscreveArquivo {
    public static void main(String[] args) throws IOException {

        OutputStream os = new FileOutputStream("escrita.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("Java no Senac");
        bw.close();
        System.out.println("Escrita realizada com sucesso!");
    }
}
