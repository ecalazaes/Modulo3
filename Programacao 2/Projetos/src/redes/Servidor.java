//package redes;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Servidor {
//	public static void main(String[] args) throws IOException {
//		ServerSocket server = new ServerSocket(10000);
//		System.out.println("Porta 10000 aberta, aguardando uma conexão");
//
//		Socket client = server.accept();
//		System.out.println("Conexão do cliente "+client.getInetAddress().getHostAddress());
//
//		Scanner s = new Scanner(client.getInputStream());
//
//		while(s.hasNextLine()) {
//			System.out.println(s.nextLine());
//		}
//
//		s.close();
//		client.close();
//		server.close();
//
//	}
//
//}

package redes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(10000);
		System.out.println("Porta 10000 aberta, aguardando conexões");

		while (true) {
			Socket client = server.accept();
			System.out.println("Conexão do cliente " + client.getInetAddress().getHostAddress());

			// Cria uma nova thread para lidar com a conexão do cliente
			ClientHandler clientHandler = new ClientHandler(client);
			new Thread(clientHandler).start();
		}
	}
}

class ClientHandler implements Runnable {
	private Socket client;

	public ClientHandler(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			String clientIp = client.getInetAddress().getHostAddress();
			Scanner s = new Scanner(client.getInputStream());

			while (s.hasNextLine()) {
				String message = s.nextLine();
				System.out.println("[" + clientIp + "]: " + message);
			}

			s.close();
			client.close();
		} catch (IOException e) {
			System.out.println("Erro ao lidar com o cliente: " + e.getMessage());
		}
	}
}


