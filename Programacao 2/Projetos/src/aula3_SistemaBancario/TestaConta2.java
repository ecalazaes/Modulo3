package aula3_SistemaBancario;

public class TestaConta2 {
    public static void main(String[] args) {
        Conta c1 = new Conta();
        c1.setLimite(100.0);

        Conta c2;
        c2 = c1;
        c2.setLimite(200.00);

        System.out.println("Limite de c1: " +c1.getLimite());
        System.out.println("Limite de c2: " +c2.getLimite());
    }
}
