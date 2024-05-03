package colecoes;

import aula3_SistemaBancario.Conta;

import java.util.ArrayList;
import java.util.List;

public class TestaLista2 {
    public static void main(String[] args) {

        List<Conta> contas = new ArrayList<>();

        Conta c1 = new Conta();
        Conta c2 = new Conta();
        Conta c3 = new Conta();

        c1.depositar(10);
        c1.nome = "Erick";

        c2.depositar(20);
        c2.nome = "Daniele";

        c3.depositar(30);
        c3.nome = "Higor";

        contas.add(c1);
        contas.add(c2);
        contas.add(c3);

        System.out.println(contas);
        System.out.println(c1);

        for (Conta c : contas) {
            System.out.println(c.saldo);
        }
    }
}
