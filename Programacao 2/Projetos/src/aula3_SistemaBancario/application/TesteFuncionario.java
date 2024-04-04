package Aula3_SistemaBancario;

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();

        f1.nome = "Erick";
        f1.salario = 500.00;
        f1.status = "ativo";

        System.out.println("Salario: " + f1.salario);
        f1.bonificacao(100);

        System.out.printf("Salario: R$ %.2f", f1.salario);
    }
}
