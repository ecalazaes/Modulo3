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

	private JTextArea chatArea;
	private JTextField inputField;
	private PrintStream out;
	private Socket client;

	public Servidor() {
		JFrame frame = new JFrame("Servidor");
		chatArea = new JTextArea(20, 40);
		chatArea.setEditable(false);
		JScrollPane chatScroll = new JScrollPane(chatArea);
		inputField = new JTextField(30);
		JButton sendButton = new JButton("Enviar");

		// Adicionar funcionalidade de enviar a mensagem ao pressionar Enter
		inputField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		JPanel panel = new JPanel();
		panel.add(inputField);
		panel.add(sendButton);

		frame.add(chatScroll, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Exibe a mensagem inicial na área de texto
		chatArea.append("Porta 10000 aberta, aguardando uma conexão\n");

		// Inicia o servidor em uma nova thread
		new Thread(this::startServer).start();
	}

	private void sendMessage() {
		String message = inputField.getText();
		if (message != null && !message.isEmpty()) {
			out.println(message);
			chatArea.append("Servidor: " + message + "\n");
			inputField.setText("");
		}
	}

	private void startServer() {
		try {
			ServerSocket server = new ServerSocket(10000);
			client = server.accept();
			chatArea.append("Conexão do cliente " + client.getInetAddress().getHostAddress() + "\n");

			Scanner clientInput = new Scanner(client.getInputStream());
			out = new PrintStream(client.getOutputStream());

			while (clientInput.hasNextLine()) {
				String message = clientInput.nextLine();
				chatArea.append("Cliente: " + message + "\n");
			}

			clientInput.close();
			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Servidor::new);
	}
}
