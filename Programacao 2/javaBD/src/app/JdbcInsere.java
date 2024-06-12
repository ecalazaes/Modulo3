package app;

import javabanco.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsere {
    public static void main(String[] args) {
        try {
            // Base sql de insert
            String sql = "Insert into contatos (nome, email, endereco) values (?,?,?)";

            // Conexão ao banco
            Connection con =  ConnectionFactory.getConnection();

            // Manipular, injetar transação ao banco de dados (zero base)
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "Erick");
            stmt.setString(2, "ecalazaes@gmail.com");
            stmt.setString(3, "Rua Geovani de Castro, 90");
            stmt.execute();

            stmt.close();
            con.close();

            System.out.println("Gravou legal!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
