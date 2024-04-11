package aula3_SistemaBancario;

public class ContaInvestimento extends Conta2 {


    public ContaInvestimento(double saldo) {
        this.saldo = saldo;
    }

    public double correcao(){
        return saldo * 1.02;
    }
}
