package dao;

import javabanco.ConnectionFactory;
import model.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDao {
    private Connection con;

    public ContatoDao() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    public void adiciona(Contato contato) throws SQLException {
        String sql = "Insert into contatos (nome, email, endereco) values (?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getEmail());
        stmt.setString(3, contato.getEndereco());
        stmt.execute();

        stmt.close();
        con.close();
    }
}
