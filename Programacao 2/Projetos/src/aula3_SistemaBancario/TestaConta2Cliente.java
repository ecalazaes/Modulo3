package aula3_SistemaBancario;

public class TestaConta2Cliente {

    public static void main(String[] args) {
        Conta2 c2 = new Conta2();
        c2.saldo = 100;
        c2.cliente.nome = "Erick";

        System.out.println("Saldo: " + c2.saldo);
        System.out.println("Limite: " + c2.limite);
        System.out.println("Nome: " + c2.cliente.nome);
    }
}
