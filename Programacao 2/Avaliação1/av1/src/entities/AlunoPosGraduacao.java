package entities;

import java.util.ArrayList;
import java.util.List;

public class AlunoPosGraduacao extends Aluno {

    private List<DisciplinasPosGraduacao> disciplina;
    private String tcc;

    public AlunoPosGraduacao(String nome, String cpf, int matricula, String telefone, String email, String endereco) {
        super(nome, cpf, matricula, telefone, email, endereco);
        this.tcc = "TCC";
        this.duracaoCurso = "12 meses";
        this.disciplina = new ArrayList<>();
    }

    public String getTcc() {
        return tcc;
    }

    public void setTcc(String tcc) {
        this.tcc = tcc;
    }

    public List<DisciplinasPosGraduacao> getDisciplina() {
        return disciplina;
    }

    public void adicionarDisciplina(DisciplinasPosGraduacao disciplina) {
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
