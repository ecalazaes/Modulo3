package orm.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "tarefas")
public class Tarefa {

//    @Entity definir uma tabela no banco
//    @Table(name = "tarefas") definir nome da tabela
//    @id identifica o atributo como chave primária
//    @GeneratedValue identifica o atributo como auto auto increment
//    @Column(nullable = false) para deixar o atributo not null
//    @Temporal(TemporalType.DATE) para definir que só retorne a data
//    @Column(name = "data_finalizado") para definir o nome da coluna
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String descricao;
    private boolean finalizada;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_finalizado")
    private Calendar dataFinalizacao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Calendar getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Calendar dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
}
