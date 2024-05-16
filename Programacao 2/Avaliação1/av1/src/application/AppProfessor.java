package application;

import entities.DisciplinasGraduacao;
import entities.DisciplinasPosGraduacao;
import entities.Professor;

import java.util.List;

public class AppProfessor {
    public static void main(String[] args) {

        // Criando Professor
        Professor professor = new Professor("Clayton", "111111111", 789, "999999999", "clayton@gmail.com", "Rua Senac");

        // Criando matérias Graduação
        DisciplinasGraduacao java = new DisciplinasGraduacao(1, "Java");
        DisciplinasGraduacao python = new DisciplinasGraduacao(2, "Python");
        DisciplinasGraduacao js = new DisciplinasGraduacao(3, "JS");

        // Criando matérias PósGraduação
        DisciplinasPosGraduacao Maven = new DisciplinasPosGraduacao(1, "Maven");
        DisciplinasPosGraduacao Mensageria = new DisciplinasPosGraduacao(2, "Mensageria");
        DisciplinasPosGraduacao SpringBoot = new DisciplinasPosGraduacao(3, "SpringBoot");

        // Adiciona matérias que o Professor leciona de Graduação
        professor.adicionarDisciplina(java);
        professor.adicionarDisciplina(python);
        professor.adicionarDisciplina(js);

        // Adiciona matérias que o Professor leciona de PósGraduação
        professor.adicionarDisciplina(Maven);
        professor.adicionarDisciplina(Mensageria);
        professor.adicionarDisciplina(SpringBoot);

        // Lançar Nota
        System.out.println(professor.lancarNota(9, "Java", "Erick"));
        System.out.println(professor.lancarNota(8, "SpringBoot", "José"));

        System.out.println();

        // Lançar Frequencia
        System.out.println(professor.lancarFrequencia("Erick"));
        System.out.println(professor.lancarFrequencia("José"));

        System.out.println();

        // Informações do Professor
        System.out.println("-- Informações do Professor --");
        System.out.println("Nome: " + professor.getNome());
        System.out.println("CPF: " + professor.getCpf());
        System.out.println("Matricula: " + professor.getMatricula());
        System.out.println("Telefone: " + professor.getTelefone());
        System.out.println("E-mail: " + professor.getEmail());
        System.out.println("Endereço: " + professor.getEndereco());
        System.out.println();
        System.out.println("-- Matérias que o professor " + professor.getNome() + " leciona --");
        System.out.println("Disciplinas Graduação:");
        List<DisciplinasGraduacao> disciplinasGraduacao = professor.getDisciplinaGraduacao();
        for (DisciplinasGraduacao disciplina : disciplinasGraduacao) {
            System.out.println("- " + disciplina.getNome());
        }
        System.out.println("Disciplinas PósGradução:");
        List<DisciplinasPosGraduacao> disciplinasPosGraduacao = professor.getDisciplinaPosGrduacao();
        for (DisciplinasPosGraduacao disciplina : disciplinasPosGraduacao) {
            System.out.println("- " + disciplina.getNome());
        }
    }
}
