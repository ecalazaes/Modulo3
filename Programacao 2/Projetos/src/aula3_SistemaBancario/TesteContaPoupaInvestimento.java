package aula3_SistemaBancario;

import java.util.Locale;
import java.util.Scanner;

public class TesteContaPoupaInvestimento {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o saldo para simulação de poupança e investimento: ");
        double saldo = sc.nextDouble();

        ContaPoupanca cp = new ContaPoupanca(saldo);
        System.out.println("Saldo Poupança com correção: R$ " + String.format("%.2f ", cp.correcao()));

        ContaInvestimento ci = new ContaInvestimento(saldo);
        System.out.println("Saldo Investimento com correção: R$ " + String.format("%.2f ", ci.correcao()));

        sc.close();
    }
}
