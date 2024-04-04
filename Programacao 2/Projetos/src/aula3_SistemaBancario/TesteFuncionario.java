package aula3_SistemaBancario;

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();

        f1.setNome("Erick");
        f1.setSalario(500.00);
        f1.setStatus("ativo");

        System.out.println("Salario: " + f1.getSalario());
        f1.bonificacao(100);

        System.out.printf("Salario: R$ %.2f", f1.getSalario());

    }
}
