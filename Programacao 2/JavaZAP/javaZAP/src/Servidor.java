import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	private JTextArea areaDeChat;
	private JTextField campoDeEntrada;
	private PrintStream saida;
	private Socket cliente;

	// Construtor do Servidor
	public Servidor() {
		// Configuração da janela principal
		JFrame janela = new JFrame("Servidor");

		// Área de texto onde as mensagens serão exibidas
		areaDeChat = new JTextArea(20, 40);
		areaDeChat.setEditable(false);
		JScrollPane rolagemDoChat = new JScrollPane(areaDeChat);

		// Campo de texto onde o usuário digita as mensagens
		campoDeEntrada = new JTextField(30);
		JButton botaoEnviar = new JButton("Enviar");

		// Envia a mensagem ao pressionar Enter
		campoDeEntrada.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					enviarMensagem();
				}
			}
		});

		// Envia a mensagem ao clicar no botão "Enviar"
		botaoEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enviarMensagem();
			}
		});

		// Painel que contém o campo de texto e o botão de enviar
		JPanel painel = new JPanel();
		painel.add(campoDeEntrada);
		painel.add(botaoEnviar);

		// Adiciona a área de texto e o painel à janela principal
		janela.add(rolagemDoChat, BorderLayout.CENTER);
		janela.add(painel, BorderLayout.SOUTH);
		janela.pack();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);

		// Mensagem inicial na área de texto
		areaDeChat.append("Porta 10000 aberta, aguardando uma conexão\n");

		// Inicia o servidor em uma nova thread
		new Thread(() -> {
			try {
				// Abre um socket na porta 10000
				ServerSocket servidor = new ServerSocket(10000);
				cliente = servidor.accept();
				areaDeChat.append("Conexão do cliente " + cliente.getInetAddress().getHostAddress() + "\n");

				// Scanner para ler as mensagens do cliente
				Scanner entradaDoCliente = new Scanner(cliente.getInputStream());
				saida = new PrintStream(cliente.getOutputStream());

				// Lê e exibe as mensagens do cliente
				while (entradaDoCliente.hasNextLine()) {
					String mensagem = entradaDoCliente.nextLine();
					areaDeChat.append("Cliente: " + mensagem + "\n");
				}

				// Fecha os recursos
				entradaDoCliente.close();
				cliente.close();
				servidor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	// Método para enviar mensagens
	private void enviarMensagem() {
		String mensagem = campoDeEntrada.getText();
		if (mensagem != null && !mensagem.isEmpty()) {
			saida.println(mensagem);
			areaDeChat.append("Servidor: " + mensagem + "\n");
			campoDeEntrada.setText("");
		}
	}

	public static void main(String[] args) {
		new Servidor();
	}
}
