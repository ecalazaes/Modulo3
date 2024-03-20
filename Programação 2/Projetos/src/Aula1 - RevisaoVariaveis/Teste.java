package aula1_RevisaoVariaveis;

public class Teste {
    public static void main(String[] args) {

        // Comentário de Linha

        /* Comentário de Bloco
         */

        /**
         * Comentário de bloco reconhecido pelo javadocs
         */

        System.out.println("Teste 123");

        int c9 = 20;
        int $1 = 25;
        char c = 'f';
        byte b = 5;
        short s = 10;
        //int i = 15;
        long x = 10L;
        double d = 100.0;
        float f = 1500.0f;

        boolean resultado1; // declaração
        resultado1 = false; // inicialização

        boolean resultado2 = true; //
        // "=" operador de atribuição
        // igual em Java é "=="

        //System.out.println("O valor de i é: " + i);

        String nome = "Erick";

        // pós e pré-incremento
        int i = 10;
        int j = 5;
        int k = j++ + i; // pós-incremento
        //int k = ++j + i; // pré-incremento

        int w = k;

        System.out.println("O valor de k é: "+k);
        System.out.println("O valor de j é: "+j);
        System.out.println("O valor de w é: "+w);

    }
}
