package orm.actions;

import orm.model.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoverTarefaPorId {
    public static void main(String[] args) {
        //1. Conectar ao operador do ORM/JPA
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();

        //2. Buscar o objeto a ser excluido
        Tarefa tarefa = new Tarefa();
        tarefa = manager.find(Tarefa.class, 9L);

        //3. o "D" do crud é dado pelo método "remove" de Hibernate
        manager.getTransaction().begin();
        manager.remove(tarefa);
        manager.getTransaction().commit();

        System.out.println("Tarefa Excluída");

        manager.close();
        factory.close();
    }
}
