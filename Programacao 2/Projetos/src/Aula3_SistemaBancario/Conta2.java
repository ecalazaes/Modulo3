package Aula3_SistemaBancario;

public class Conta2 {
    int numero;
    //    String nome;
    //    Cliente cliente = new Cliente();
    Cliente cliente;
    double saldo;
    double limite;

    public Conta2( ) {
        cliente = new Cliente();
    }

    boolean sacar(double valor) {
        if ((this.saldo + this.limite) < valor) {
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }
    void depositar(double valor) {
        this.saldo += valor;
    }

}
