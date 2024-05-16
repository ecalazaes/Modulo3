package entities;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {

    private List<DisciplinasGraduacao> disciplinaGraduacao;
    private List<DisciplinasPosGraduacao> disciplinaPosGraduacao;

    public Professor(String nome, String cpf, int matricula, String telefone, String email, String endereco) {
        super(nome, cpf, matricula, telefone, email, endereco);
        this.disciplinaGraduacao = new ArrayList<>();
        this.disciplinaPosGraduacao = new ArrayList<>();
    }

    public List<DisciplinasGraduacao> getDisciplinaGraduacao() {
        return disciplinaGraduacao;
    }

    public void adicionarDisciplina(DisciplinasGraduacao disciplina) {
        this.disciplinaGraduacao.add(disciplina);
    }

    public List<DisciplinasPosGraduacao> getDisciplinaPosGrduacao() {
        return disciplinaPosGraduacao;
    }

    public void adicionarDisciplina(DisciplinasPosGraduacao disciplina) {
        this.disciplinaPosGraduacao.add(disciplina);
    }

    public String lancarNota(String aluno, String  materia, double nota){
        return "Foi lançada a nota " + nota + " na matéria " + materia + " para o aluno " + aluno + ".";
    }

    public String lancarFrequencia(String aluno){
        return "Foi lançada presença para o aluno " + aluno + ".";

    }
}
