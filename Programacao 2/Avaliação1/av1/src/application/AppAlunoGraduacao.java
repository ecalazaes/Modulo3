package application;

import entities.AlunoGraduacao;
import entities.DisciplinasGraduacao;

import java.util.List;
import java.util.Scanner;

public class AppAlunoGraduacao {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op;
        AlunoGraduacao alunoGraduacao = null;
        do {
            System.out.println("1 - Cadastrar AlunoGraduação");
            System.out.println("9 - Sair");
            op = sc.nextInt();
            sc.nextLine();
            if (op == 1) {
                System.out.print("Informe o nome: ");
                String nome = sc.nextLine();
                System.out.print("Informe o CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Informe a matricula: ");
                int matricula = sc.nextInt();
                sc.nextLine();
                System.out.print("Informe o telefone: ");
                String telefone = sc.nextLine();
                System.out.print("Informe o E-mail: ");
                String email = sc.nextLine();
                System.out.print("Informe o endereco: ");
                String endereco = sc.nextLine();

                // Instanciei o Aluno
                alunoGraduacao = new AlunoGraduacao(nome, cpf, matricula, telefone, email, endereco);

                // Inseri as disciplinas na lista
                System.out.println("Quantas matéria deseja cadastrar: ");
                int n = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < n ; i++) {
                    System.out.print("Informe a " + (i+1) + "° matéria: ");
                    String materia = sc.nextLine();
                    DisciplinasGraduacao disciplinasGraduacao = new DisciplinasGraduacao(materia);
                    alunoGraduacao.adicionarDisciplina(disciplinasGraduacao);

                }
                // Informações do AlunoGraduacao
                System.out.println();
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
                System.out.println();

                do {
                    System.out.println("1 - Solicitar Boleto");
                    System.out.println("2 - Solicitar Histórico");
                    System.out.println("9 - Sair");
                    op = sc.nextInt();
                    sc.nextLine();
                    if (op == 1) {
                        System.out.print("Informe o mês do boleto: ");
                        String mes = sc.nextLine();
                        System.out.print("Informe o ano do boleto: ");
                        int ano = sc.nextInt();
                        sc.nextLine();
                        System.out.println(alunoGraduacao.solicitarBoleto(mes, ano));
                    } else if (op == 2) {
                        System.out.print("Informe o ano do histórico: ");
                        int ano = sc.nextInt();
                        sc.nextLine();
                        System.out.println(alunoGraduacao.solicitarHistorico(ano));
                    } else if (op != 9) {
                        System.out.println("Opção inválida, tente novamente");
                    } else {
                        System.out.println("Obrigado, saindo do programa...!");
                    }
                } while (op != 9);

            } else if (op != 9) {
                System.out.println("Opção inválida, tente novamente.");
            } else {
                System.out.println("Obrigado, saindo do programa...!");
            }
        } while (op != 9);

        sc.close();
    }
}
