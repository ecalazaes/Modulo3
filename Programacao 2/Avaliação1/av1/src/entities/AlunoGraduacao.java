package entities;

import java.util.ArrayList;
import java.util.List;

public class AlunoGraduacao extends Aluno {

    private List<DisciplinasGraduacao> disciplina;
    private String projetoIntegrador;

    public AlunoGraduacao(String nome, String cpf, int matricula, String telefone, String email, String endereco) {
        super(nome, cpf, matricula, telefone, email, endereco);
        this.projetoIntegrador = "Projeto Integrador";
        this.duracaoCurso = "30 Meses";
        this.disciplina = new ArrayList<>();
    }

    public String getProjetoIntegrador() {
        return projetoIntegrador;
    }

    public void setProjetoIntegrador(String projetoIntegrador) {
        this.projetoIntegrador = projetoIntegrador;
    }

    public List<DisciplinasGraduacao> getDisciplina() {
        return disciplina;
    }

    public void adicionarDisciplina(DisciplinasGraduacao disciplina) {
        this.disciplina.add(disciplina);
    }


    @Override
    public String solicitarBoleto(String mes, int ano) {
        return getNome() + ", o boleto " + mes + "/" + ano + " foi enviado com sucesso para o email " + getEmail();
    }

    @Override
    public String solicitarHistorico(int ano) {
        return getNome() + ", o histórico de " + ano + " foi enviado com sucesso para o email " + getEmail();
    }

}
