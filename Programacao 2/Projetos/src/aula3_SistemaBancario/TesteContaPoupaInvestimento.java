package aula3_SistemaBancario;

import java.util.Locale;
import java.util.Scanner;

public class TesteContaPoupaInvestimento {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o saldo para simulação de lucro na poupança: ");
        double saldoPoupanca = sc.nextDouble();

        System.out.print("Informe o saldo para simulação de lucro na Investimento: ");
        double saldoInvestimento = sc.nextDouble();

        ContaPoupanca cp = new ContaPoupanca(saldoPoupanca);
        System.out.println("Saldo Poupança com correção: R$ " + String.format("%.2f ", cp.correcao()));

        ContaInvestimento ci = new ContaInvestimento(saldoInvestimento);
        System.out.println("Saldo Investimento com correção: R$ " + String.format("%.2f ", ci.correcao()));

        sc.close();
    }
}
