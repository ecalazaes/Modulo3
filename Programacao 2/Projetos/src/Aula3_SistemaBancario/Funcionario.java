package Aula3_SistemaBancario;

public class Funcionario {
    String nome;
    String cpf;
    String departamento;
    String dataAdmissao;
    double salario;
    String status;

    void bonificacao(double bonus){
        salario += bonus;

    }
}
