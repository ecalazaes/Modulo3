package orm.utilsDB;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Classe responsável pelo DDL -> Data Definition Language
public class GeraTabelaTarefa {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        factory.close();
    }
}
