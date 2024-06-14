import java.util.Scanner;

public class Converte {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o endereço virtual (em decimal ou hexadecimal): ");
        String input = sc.nextLine();

        // Converte o input para um número inteiro
        int enderecoVirtual = parseEndereco(input);

        // Calcula o número da página e o deslocamento
        int tamanhoPagina = 4096; // 4 KB em bytes
        int numeroPagina = enderecoVirtual / tamanhoPagina;
        int deslocamento = enderecoVirtual % tamanhoPagina;

        // Mostra o resultado
        System.out.printf("número da página = %d\n", numeroPagina);
        System.out.printf("deslocamento = %d\n", deslocamento);

        sc.close();
    }

    // Função auxiliar para converter a entrada (decimal ou hexadecimal) em um número inteiro
    private static int parseEndereco(String input) {
        if (input.startsWith("0x") || input.startsWith("0X")) {
            return Integer.parseInt(input.substring(2), 16); // Hexadecimal
        } else {
            return Integer.parseInt(input); // Decimal
        }
    }
}
