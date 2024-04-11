package aula3_SistemaBancario;

public class Conta2 {
    int numero;
    public double saldo;
    public double limite;


    public Cliente cliente;


    public Conta2() {
        cliente = new Cliente();
    }

      public boolean sacar(double valor) {
        if ((this.saldo + this.limite) < valor) {
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }
}
