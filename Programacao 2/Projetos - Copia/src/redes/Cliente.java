//package redes;
//
//import java.io.IOException;
//import java.io.PrintStream;
//import java.net.Socket;
//import java.net.UnknownHostException;
//import java.util.Scanner;
//
//public class Cliente {
//	public static void main(String[] args) throws UnknownHostException, IOException {
//		String serverAddress = "10.136.64.196";
//		Socket client = new Socket(serverAddress, 10000);
//		System.out.println("Cliente conectado ao servidor!");
//
//		Scanner s = new Scanner(System.in);
//		PrintStream out = new PrintStream(client.getOutputStream());
//
//		while(s.hasNextLine()) {
//			out.println(s.nextLine());
//		}
//	}
//}


package redes;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws UnknownHostException, IOException {
        String serverAddress = "10.136.64.196"; // Endereço do servidor
        Socket client = new Socket(serverAddress, 10000);
        System.out.println("Cliente conectado ao servidor!");

        // Cria um thread para ouvir mensagens do servidor
        new Thread(new Listener(client)).start();

        // Envia mensagens para o servidor
        Scanner s = new Scanner(System.in);
        PrintStream out = new PrintStream(client.getOutputStream());

        while (s.hasNextLine()) {
            out.println(s.nextLine());
        }

        s.close();
        client.close();
    }
}

class Listener implements Runnable {
    private Socket client;

    public Listener(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Scanner in = new Scanner(client.getInputStream());
            while (in.hasNextLine()) {
                System.out.println("Servidor: " + in.nextLine());
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Erro ao ouvir o servidor: " + e.getMessage());
        }
    }
}
