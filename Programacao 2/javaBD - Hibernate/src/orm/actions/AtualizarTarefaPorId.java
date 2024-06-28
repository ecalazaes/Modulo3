package orm.actions;

import orm.model.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AtualizarTarefaPorId {
    public static void main(String[] args) {

        //1. Criar a tarefa a ser atualizada
        Tarefa tarefa = new Tarefa();
        tarefa.setId(2L);
        tarefa.setDescricao("Estudar Python!");
        tarefa.setFinalizada(false);
        tarefa.setDataFinalizacao(null);

        //2. Conectar ao operador do ORM/JPA
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();

        //3. Executar a operação
        manager.getTransaction().begin();
        //o "U" do crud é dado pelo método "merge" de Hibernate
        manager.merge(tarefa);
        manager.getTransaction().commit();

        System.out.println("Tarefa Atualizada, ID: " + tarefa.getId());

        manager.close();
        factory.close();

    }
}
