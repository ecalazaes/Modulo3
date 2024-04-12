package aula3_SistemaBancario;

public abstract class Conta3 {
    protected int numero;
    protected double saldo;
    protected double limite;
    protected Cliente cliente;

    abstract double correcao();

    public Conta3() {
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
