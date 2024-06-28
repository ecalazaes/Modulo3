package orm.actions;

import orm.model.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BuscaTarefas {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();

        String sql = "select t from Tarefa as t where t.finalizada = :paramFinalizada";

        //JPQL: Class query de "Javax.persistence"
        Query query = manager.createQuery(sql);
        query.setParameter("paramFinalizada", true);

        //Mostrando o resultado
        List<Tarefa> listaTarefas = query.getResultList();

        for (Tarefa tarefa : listaTarefas) {
            System.out.println(tarefa.getDescricao());
        }
    }
}
