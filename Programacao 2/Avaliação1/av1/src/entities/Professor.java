package entities;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {

    private List<DisciplinasGraduacao> disciplinaGraduacao;
    private List<DisciplinasPosGraduacao> disciplinaPosGrduacao;

    public Professor(String nome, String cpf, int matricula, String telefone, String email, String endereco) {
        super(nome, cpf, matricula, telefone, email, endereco);
        this.disciplinaGraduacao = new ArrayList<>();
        this.disciplinaPosGrduacao = new ArrayList<>();
    }

    public List<DisciplinasGraduacao> getDisciplinaGraduacao() {
        return disciplinaGraduacao;
    }

    public void adicionarDisciplina(DisciplinasGraduacao disciplina) {
        this.disciplinaGraduacao.add(disciplina);
    }

    public List<DisciplinasPosGraduacao> getDisciplinaPosGrduacao() {
        return disciplinaPosGrduacao;
    }

    public void adicionarDisciplina(DisciplinasPosGraduacao disciplina) {
        this.disciplinaPosGrduacao.add(disciplina);
    }

    public String lancarNota(double nota, String materia, String aluno){
        return "Foi lançada a nota " + nota + " na matéria " + materia + " para o aluno " + aluno;
    }

    public String lancarFrequencia(String aluno){
        return "Foi lançada presença para o aluno " + aluno;

    }
}
