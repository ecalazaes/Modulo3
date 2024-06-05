//package redes;
//
//import java.io.IOException;
//import java.io.PrintStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Servidor {
//	public static void main(String[] args) throws IOException {
//		ServerSocket server = new ServerSocket(10000);
//		System.out.println("Porta 10000 aberta, aguardando conexões");
//
//		while (true) {
//			Socket client = server.accept();
//			System.out.println("Conexão do cliente " + client.getInetAddress().getHostAddress());
//
//			// Cria uma nova thread para lidar com a conexão do cliente
//			ClientHandler clientHandler = new ClientHandler(client);
//			new Thread(clientHandler).start();
//		}
//	}
//}
//
//class ClientHandler implements Runnable {
//	private Socket client;
//
//	public ClientHandler(Socket client) {
//		this.client = client;
//	}
//
//	@Override
//	public void run() {
//		try {
//			String clientIp = client.getInetAddress().getHostAddress();
//			Scanner in = new Scanner(client.getInputStream());
//			PrintStream out = new PrintStream(client.getOutputStream());
//
//			// Cria um thread para ouvir mensagens do cliente
//			new Thread(() -> {
//				try {
//					Scanner s = new Scanner(System.in);
//					while (s.hasNextLine()) {
//						out.println(s.nextLine());
//					}
//					s.close();
//				} catch (Exception e) {
//					System.out.println("Erro ao enviar mensagem para o cliente: " + e.getMessage());
//				}
//			}).start();
//
//			// Lê mensagens do cliente e as exibe no console
//			while (in.hasNextLine()) {
//				String message = in.nextLine();
//				System.out.println("[" + clientIp + "]: " + message);
//			}
//
//			in.close();
//			client.close();
//		} catch (IOException e) {
//			System.out.println("Erro ao lidar com o cliente: " + e.getMessage());
//		}
//	}
//}


package redes;

import java.io.IOException;
import java.io.PrintStream;
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
			Scanner in = new Scanner(client.getInputStream());
			PrintStream out = new PrintStream(client.getOutputStream());

			// Cria um thread para ouvir mensagens do console do servidor e enviá-las ao cliente
			new Thread(() -> {
				try {
					Scanner serverInput = new Scanner(System.in);
					while (serverInput.hasNextLine()) {
						out.println(serverInput.nextLine());
					}
					serverInput.close();
				} catch (Exception e) {
					System.out.println("Erro ao enviar mensagem para o cliente: " + e.getMessage());
				}
			}).start();

			// Lê mensagens do cliente e as exibe no console do servidor
			while (in.hasNextLine()) {
				String message = in.nextLine();
				System.out.println("[" + clientIp + "]: " + message);
			}

			in.close();
			client.close();
		} catch (IOException e) {
			System.out.println("Erro ao lidar com o cliente: " + e.getMessage());
		}
	}
}
