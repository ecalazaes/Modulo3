package Aula2_Aula3_Exercicios;

import java.util.Arrays;

public class Exercicio8 {
    public static void main(String[] args) {
        String[] diasDaSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};

        for (int i = 0; i < diasDaSemana.length ; i++) {
            System.out.println(diasDaSemana[i]);
        }

        for (String dia : diasDaSemana) {
            System.out.println(dia);
        }

        System.out.println(Arrays.toString(diasDaSemana));
    }
}
