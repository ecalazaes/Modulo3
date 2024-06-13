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

    private JTextArea areaDeChat;
    private JTextField campoDeEntrada;
    private PrintStream saida;

    // Construtor do Cliente
    public Cliente() {
        // Configuração da janela principal
        JFrame janela = new JFrame("Cliente");

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
            // Método chamado quando o botão "Enviar" é clicado
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

        // Conecta ao servidor e inicia a comunicação
        try {
            String enderecoServidor = "10.136.64.224";
            Socket cliente = new Socket(enderecoServidor, 10000);
            areaDeChat.append("Cliente conectado ao servidor!\n");

            Scanner entradaDoServidor = new Scanner(cliente.getInputStream());
            saida = new PrintStream(cliente.getOutputStream());

            // Thread para ler as mensagens do servidor
            new Thread(() -> {
                while (entradaDoServidor.hasNextLine()) {
                    String mensagem = entradaDoServidor.nextLine();
                    areaDeChat.append("Servidor: " + mensagem + "\n");
                }

				// Fecha os recursos
				saida.close();
                entradaDoServidor.close();

            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para enviar mensagens
    private void enviarMensagem() {
        String mensagem = campoDeEntrada.getText();
        if (mensagem != null && !mensagem.isEmpty()) {
            saida.println(mensagem);
            areaDeChat.append("Cliente: " + mensagem + "\n");
            campoDeEntrada.setText("");
        }
    }

    public static void main(String[] args) {
        new Cliente();
    }
}
