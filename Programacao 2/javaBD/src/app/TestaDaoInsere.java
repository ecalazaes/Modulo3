package app;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;

public class TestaDaoInsere {
    public static void main(String[] args) {

        Contato contato = new Contato();
        contato.setNome("Ronaldo");
        contato.setEmail("Fuzipa@hotmail.com");
        contato.setEndereco("Rua Geovani de Castro, 90");

        try {
            ContatoDao dao = new ContatoDao();
            dao.adiciona(contato);
            System.out.println("Gravação feita no Banco de Dados");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
