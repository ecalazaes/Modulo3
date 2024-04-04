package aula3_SistemaBancario;

public class TestaConta {
    public static void main(String[] args) {
        Conta c1 = new Conta();
        Conta c2 = new Conta();

        c1.setNumero(001);
        c1.setNome("Erick");
        c1.setSaldo(100.0);
        c1.setLimite(200.0);

        c2.setNumero(002);
        c2.setNome("Maria");
        c2.setSaldo(10.0);
        c2.setLimite(20.0);

        System.out.println("Numero da conta: " +c2.getNumero());
        System.out.println("Nome: " +c2.getNome());
        System.out.println("Saldo Atual: " +c2.getSaldo());
        System.out.println("Limite: " +c2.getLimite());

        int saque = 5;
        boolean resultado = c2.sacar(saque);
        if (resultado) {
            System.out.println("\nVocê sacou R$ " + saque);
            System.out.println("Saldo atual: " + c2.getSaldo());
        } else {
            System.out.println("Saque não efetuado, valor acima do possível.");
        }
    }
}
