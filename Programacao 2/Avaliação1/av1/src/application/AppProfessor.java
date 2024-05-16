package application;

import entities.DisciplinasGraduacao;
import entities.DisciplinasPosGraduacao;
import entities.Professor;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AppProfessor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op;
        Professor professor = null;

        do {
            System.out.println("1 - Cadastrar Professor");
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
                    sc.nextLine(); // Limpa o buffer do teclado
                    System.out.print("Informe o telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Informe o E-mail: ");
                    String email = sc.nextLine();
                    System.out.print("Informe o endereco: ");
                    String endereco = sc.nextLine();


                    professor = new Professor(nome, cpf, matricula, telefone, email, endereco);

                    int op2;
                    do {
                        System.out.println();
                        System.out.println("1 - Disciplinas de Graduação");
                        System.out.println("2 - Disciplinas de Pós-Graduação");
                        System.out.println("9 - Voltar");
                        try {
                            op2 = sc.nextInt();
                            sc.nextLine();

                            if (op2 == 1) {
                                System.out.println("Quantas matérias deseja cadastrar: ");
                                int n = sc.nextInt();
                                sc.nextLine();

                                for (int i = 0; i < n; i++) {
                                    System.out.print("Informe a " + (i + 1) + "ª matéria: ");
                                    String materia = sc.nextLine();
                                    DisciplinasGraduacao disciplinasGraduacao = new DisciplinasGraduacao(materia);
                                    professor.adicionarDisciplina(disciplinasGraduacao);
                                }
                            } else if (op2 == 2) {
                                System.out.println("Quantas matérias deseja cadastrar: ");
                                int n = sc.nextInt();
                                sc.nextLine();

                                for (int i = 0; i < n; i++) {
                                    System.out.print("Informe a " + (i + 1) + "ª matéria: ");
                                    String materia = sc.nextLine();
                                    DisciplinasPosGraduacao disciplinasPosGraduacao = new DisciplinasPosGraduacao(materia);
                                    professor.adicionarDisciplina(disciplinasPosGraduacao);
                                }
                            } else if (op2 != 9) {
                                System.out.println("Opção inválida, tente novamente.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, digite um número válido.");
                            sc.nextLine();
                            op2 = 0;
                        }
                    } while (op2 != 9);


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
                    System.out.println("Disciplinas Pós-Graduação:");
                    List<DisciplinasPosGraduacao> disciplinasPosGraduacao = professor.getDisciplinaPosGrduacao();
                    for (DisciplinasPosGraduacao disciplina : disciplinasPosGraduacao) {
                        System.out.println("- " + disciplina.getNome());
                    }

                } else if (op != 9) {
                    System.out.println("Opção inválida, tente novamente");
                }

            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número válido.");
                sc.nextLine();
                op = 0;
            }

        } while (op != 9);

        System.out.println("Obrigado, saindo do programa...!");
        sc.close();
    }
}
