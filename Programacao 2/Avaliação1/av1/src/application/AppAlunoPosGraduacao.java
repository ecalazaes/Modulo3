package application;

import entities.AlunoGraduacao;
import entities.AlunoPosGraduacao;
import entities.DisciplinasGraduacao;
import entities.DisciplinasPosGraduacao;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AppAlunoPosGraduacao {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op;
        AlunoPosGraduacao alunoPosGraduacao = null;

        do {
            System.out.println("1 - Cadastrar AlunoPósGraduação");
            System.out.println("9 - Sair");
            try {
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


                    alunoPosGraduacao = new AlunoPosGraduacao(nome, cpf, matricula, telefone, email, endereco);

                    System.out.println("Quantas matérias deseja cadastrar: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Informe a " + (i + 1) + "° matéria: ");
                        String materia = sc.nextLine();
                        DisciplinasPosGraduacao disciplina = new DisciplinasPosGraduacao(materia);
                        alunoPosGraduacao.adicionarDisciplina(disciplina);
                    }


                    System.out.println();
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
                    System.out.println();

                    int op2;
                    do {
                        System.out.println("1 - Solicitar Boleto");
                        System.out.println("2 - Solicitar Histórico");
                        System.out.println("9 - Voltar");
                        try {
                            op2 = sc.nextInt();
                            sc.nextLine();

                            if (op2 == 1) {
                                System.out.print("Informe o mês do boleto: ");
                                String mes = sc.nextLine();
                                System.out.print("Informe o ano do boleto: ");
                                int ano = sc.nextInt();
                                sc.nextLine();
                                System.out.println(alunoPosGraduacao.solicitarBoleto(mes, ano));
                            } else if (op2 == 2) {
                                System.out.print("Informe o ano do histórico: ");
                                int ano = sc.nextInt();
                                sc.nextLine();
                                System.out.println(alunoPosGraduacao.solicitarHistorico(ano));
                            } else if (op2 != 9) {
                                System.out.println("Opção inválida, tente novamente");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, digite um número válido.");
                            sc.nextLine();
                            op2 = 0;
                        }
                    } while (op2 != 9);

                } else if (op != 9) {
                    System.out.println("Opção inválida, tente novamente.");
                } else {
                    System.out.println("Obrigado, saindo do programa...!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número válido.");
                sc.nextLine();
                op = 0;
            }
        } while (op != 9);

        sc.close();
    }
}
