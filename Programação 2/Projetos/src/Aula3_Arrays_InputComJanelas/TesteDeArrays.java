package Aula3_Arrays_InputComJanelas;

public class TesteDeArrays {
    public static void main(String[] args) {
//        Declaração de arrays
        int notas[];

//        Construção do array
        notas = new int[100];

//        declaração e contstrução na mesma linha
        int notas2[] = new int[100];

//        posso declarar, construir e inicializar na mesma linha
        int notas3[] = {5, 6, 7, 8, 9};

        boolean resultados[] = {true, false, true, false};

        String diasDaSemana[] = {"seg", "ter", "qua", "qui", "sex", "sab", "dom"};

        System.out.println(notas[2]);
    }
}
