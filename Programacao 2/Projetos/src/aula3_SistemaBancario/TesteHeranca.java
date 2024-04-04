package aula3_SistemaBancario;

public class TesteHeranca {
    public static void main(String[] args) {

        Funcionario f1 = new Funcionario();
        f1.setSalario(2000);
        System.out.println("O salário do funcionário é: " + f1.getSalario());
        System.out.println("O bônus do funcionário é: " + f1.getBonus());

        System.out.println();

        Gerente g1 = new Gerente();
        g1.setSalario(10000);
        System.out.println("O salário do Gerente é: " + g1.getSalario());
        System.out.println("O bônus do Gerente é: " + g1.getBonus());
    }
}
