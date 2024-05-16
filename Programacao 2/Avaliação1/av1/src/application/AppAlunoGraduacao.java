package application;

import entities.AlunoGraduacao;
import entities.DisciplinasGraduacao;

import java.util.List;

public class AppAlunoGraduacao {
    public static void main(String[] args) {

        // Criando aluno de Graduação
        AlunoGraduacao alunoGraduacao = new AlunoGraduacao("Erick", "14019044759", 123, "988420291", "ecalazaes@gmail.com", "Rua G");

        // Criando matérias
        DisciplinasGraduacao java = new DisciplinasGraduacao(1, "Java");
        DisciplinasGraduacao python = new DisciplinasGraduacao(2, "Python");
        DisciplinasGraduacao js = new DisciplinasGraduacao(3, "JS");

        // Adiciona matérias ao AlunoGraduacao
        alunoGraduacao.adicionarDisciplina(java);
        alunoGraduacao.adicionarDisciplina(python);
        alunoGraduacao.adicionarDisciplina(js);

        // Solicitar Boleto
        System.out.println(alunoGraduacao.solicitarBoleto("Janeiro", 2024));

        // Solicitar Histórico
        System.out.println(alunoGraduacao.solicitarHistorico(2023));
        System.out.println();

        // Informações do AlunoGraduacao
        System.out.println("-- Informações sobre o Aluno --");
        System.out.println("Nome: " + alunoGraduacao.getNome());
        System.out.println("CPF: " + alunoGraduacao.getCpf());
        System.out.println("Matricula: " + alunoGraduacao.getMatricula());
        System.out.println("Telefone: " + alunoGraduacao.getTelefone());
        System.out.println("E-mail: " + alunoGraduacao.getEmail());
        System.out.println("Endereço: " + alunoGraduacao.getEndereco());
        System.out.println();
        System.out.println("Disciplinas:");
        List<DisciplinasGraduacao> disciplinas = alunoGraduacao.getDisciplina();
        for (DisciplinasGraduacao disciplina : disciplinas) {
            System.out.println("- " + disciplina.getNome());
        }
        System.out.println();
        System.out.println("Avaliação Final: " + alunoGraduacao.getProjetoIntegrador());
        System.out.println("Duração do Curso: " + alunoGraduacao.getDuracaoCurso());
    }
}
