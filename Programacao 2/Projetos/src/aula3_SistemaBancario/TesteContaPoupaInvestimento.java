package aula3_SistemaBancario;

import java.util.Locale;

public class TesteContaPoupaInvestimento {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        ContaPoupanca cp = new ContaPoupanca(1000);
        System.out.println("Saldo Investimento com correção: R$" + String.format("%.2f ", cp.correcao()));

        ContaInvestimento ci = new ContaInvestimento(2000);
        System.out.println("Saldo Investimento com correção: R$" + String.format("%.2f ", ci.correcao()));
    }
}
