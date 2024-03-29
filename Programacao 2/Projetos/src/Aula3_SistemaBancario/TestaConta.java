package Aula3_SistemaBancario;

public class TestaConta {
    public static void main(String[] args) {
        Conta c1 = new Conta();
        Conta c2 = new Conta();

        c1.numero = 001;
        c1.nome = "Erick";
        c1.saldo = 100.0;
        c1.limite = 200.0;

        c2.numero = 002;
        c2.nome = "Maria";
        c2.saldo = 10.0;
        c2.limite = 20.0;

        System.out.println("Numero da conta: " +c2.numero);
        System.out.println("Nome: " +c2.nome);
        System.out.println("Saldo Atual: " +c2.saldo);
        System.out.println("Limite: " +c2.limite);

        int saque = 5;
        boolean resultado = c2.sacar(saque);
        if (resultado) {
            System.out.println("\nVocê sacou R$ " + saque);
            System.out.println("Saldo atual: " + c2.saldo);
        } else {
            System.out.println("Saque não efetuado, valor acima do possível.");
        }
    }
}
