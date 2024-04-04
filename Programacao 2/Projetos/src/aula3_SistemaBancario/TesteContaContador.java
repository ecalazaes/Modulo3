package aula3_SistemaBancario;

public class TesteContaContador {
    public static void main(String[] args) {

        ContaContador c1 = new ContaContador("Erick", "000.000.000-00");
        System.out.println("Nome do cliente: " + c1.getCliente());
        int contador = c1.getContadorContas();
        System.out.println("Até agora temos " + contador + " clientes");

        System.out.println();

        ContaContador c2 = new ContaContador("Daniele", "111.111.111.-11");
        System.out.println("Nome do cliente: " + c2.getCliente());
        contador = c2.getContadorContas();
        System.out.println("Até agora temos " + contador + " clientes");

        System.out.println();
        System.out.println("Até agora temos " + ContaContador.getContadorContas());

    }
}
