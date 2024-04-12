package aula3_SistemaBancario;

public class ContaPoupanca extends Conta3 {


    public ContaPoupanca(double saldo) {
        this.saldo = saldo;
    }

    public double correcao(){
        return saldo * 1.01;
    }
}
