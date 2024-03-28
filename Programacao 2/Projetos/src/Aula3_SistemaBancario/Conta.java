package Aula3_SistemaBancario;

public class Conta {
    int numero;
    String nome;
    double saldo;
    double limite;

    void sacar(double valor) {
        double saldoAlterado = this.saldo - valor;
        this.saldo = saldoAlterado;
    }

    void depositar(double valor) {
        this.saldo = this.saldo + valor;
    }




}
