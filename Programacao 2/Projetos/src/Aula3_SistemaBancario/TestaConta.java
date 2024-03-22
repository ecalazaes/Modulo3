package Aula3_SistemaBancario;

public class TestaConta {
    public static void main(String[] args) {
//        Conta c1; // Declarei o objeto c1 do tipo classe Conta
//       c1 = new Conta(); // Construção ou Instanciação
        Conta c1 = new Conta(); // Declaração e Instanciação

        c1.numero = 001;
        c1.nome = "Erick";
        c1.saldo = 100.0;
        c1.limite = 10.0;

        System.out.println("Numero da conta: " +c1.numero);
        System.out.println("Nome: " +c1.nome);
        System.out.println("Saldo Atual: " +c1.saldo);
        System.out.println("Limite: " +c1.limite);
    }
}
