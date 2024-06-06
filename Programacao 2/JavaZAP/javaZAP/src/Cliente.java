import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	private JTextArea chatArea;
	private JTextField inputField;
	private PrintStream out;

	public Cliente() {
		JFrame frame = new JFrame("Cliente");
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

		startClient();
	}

	private void sendMessage() {
		String message = inputField.getText();
		if (message != null && !message.isEmpty()) {
			out.println(message);
			chatArea.append("Cliente: " + message + "\n");
			inputField.setText("");
		}
	}

	private void startClient() {
		try {
			String serverIP = "127.0.0.1";
			Socket client = new Socket(serverIP, 10000);
			chatArea.append("Cliente conectado ao servidor!\n");

			Scanner serverInput = new Scanner(client.getInputStream());
			out = new PrintStream(client.getOutputStream());

			new Thread(new Runnable() {
				@Override
				public void run() {
					while (serverInput.hasNextLine()) {
						String message = serverInput.nextLine();
						chatArea.append("Servidor: " + message + "\n");
					}
				}
			}).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Cliente();
			}
		});
	}
}
