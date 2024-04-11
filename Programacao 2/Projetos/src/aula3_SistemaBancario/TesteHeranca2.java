package aula3_SistemaBancario;

public class TesteHeranca2 {
    public static void main(String[] args) {

        Funcionario f1 = new Funcionario();
        f1.setSalario(2000);
        System.out.println("O salário do funcionário é: " + f1.getSalario());
        System.out.println("O bônus do funcionário é: " + f1.getBonus());

        System.out.println();

        Gerente2 g2 = new Gerente2();
        g2.setSalario(10000);
        System.out.println("O salário do Gerente é: " + g2.getSalario());
        System.out.println("O bônus do Gerente é: " + g2.getBonus());
    }
}
