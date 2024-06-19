package app;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;
import java.util.List;

public class TestaDaoLista {
    public static void main(String[] args) throws SQLException {
        ContatoDao cdao = new ContatoDao();
        List<Contato> contatos = cdao.getLista();

        for (Contato contato : contatos ) {
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Email: " + contato.getEmail());
            System.out.println("Edenereço: " + contato.getEndereco());
            System.out.println("====================================================");
        }
    }
}
