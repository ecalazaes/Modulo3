package app;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;
import java.util.Scanner;

public class TestaDaoInsereScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Contato contato = new Contato();

        System.out.print("Insira o nome do contato: ");
        String nome = sc.nextLine();
        contato.setNome(nome);

        System.out.print("Insira o Email do contato: ");
        String email = sc.nextLine();
        contato.setEmail(email);

        System.out.print("Insira o Endereço do contato: ");
        String endereco = sc.nextLine();
        contato.setEndereco(endereco);

        try {
            ContatoDao dao = new ContatoDao();
            dao.adiciona(contato);
            System.out.println("Gravação feita no Banco de Dados");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
