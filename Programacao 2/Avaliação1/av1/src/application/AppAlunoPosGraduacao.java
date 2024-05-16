package application;

import entities.AlunoPosGraduacao;
import entities.DisciplinasPosGraduacao;

import java.util.List;

public class AppAlunoPosGraduacao {
    public static void main(String[] args) {

        // Criando aluno de Graduação
        AlunoPosGraduacao alunoPosGraduacao = new AlunoPosGraduacao("José", "23988495700", 456, "996637709", "lekizin@gmail.com", "Rua H");

        // Criando matérias
        DisciplinasPosGraduacao Maven = new DisciplinasPosGraduacao(1, "Maven");
        DisciplinasPosGraduacao Mensageria = new DisciplinasPosGraduacao(2, "Mensageria");
        DisciplinasPosGraduacao SpringBoot = new DisciplinasPosGraduacao(3, "SpringBoot");

        // Adiciona matérias ao AlunoGraduacao
        alunoPosGraduacao.adicionarDisciplina(Maven);
        alunoPosGraduacao.adicionarDisciplina(Mensageria);
        alunoPosGraduacao.adicionarDisciplina(SpringBoot);

        // Solicitar Boleto
        System.out.println(alunoPosGraduacao.solicitarBoleto("Julho", 2024));

        // Solicitar Histórico
        System.out.println(alunoPosGraduacao.solicitarHistorico(2021));
        System.out.println();

        // Informações do AlunoGraduacao
        System.out.println("-- Informações sobre o Aluno --");
        System.out.println("Nome: " + alunoPosGraduacao.getNome());
        System.out.println("CPF: " + alunoPosGraduacao.getCpf());
        System.out.println("Matricula: " + alunoPosGraduacao.getMatricula());
        System.out.println("Telefone: " + alunoPosGraduacao.getTelefone());
        System.out.println("E-mail: " + alunoPosGraduacao.getEmail());
        System.out.println("Endereço: " + alunoPosGraduacao.getEndereco());
        System.out.println();
        System.out.println("Disciplinas:");
        List<DisciplinasPosGraduacao> disciplinas = alunoPosGraduacao.getDisciplina();
        for (DisciplinasPosGraduacao disciplina : disciplinas) {
            System.out.println("- " + disciplina.getNome());
        }
        System.out.println();
        System.out.println("Avaliação Final: " + alunoPosGraduacao.getTcc());
        System.out.println("Duração do Curso: " + alunoPosGraduacao.getDuracaoCurso());
    }
}
