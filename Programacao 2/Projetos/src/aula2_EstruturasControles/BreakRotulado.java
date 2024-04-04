package aula2_EstruturasControles;

public class BreakRotulado {
    public static void main(String[] args) {
        int[][] numbers = {{1,2,3}, {4,5,6}, {7,8,9}};

        int seachNum = 5;

        boolean foundNum = false;

        searchLabel: for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(seachNum == numbers[i][j]) {
                    foundNum = true;
                    break searchLabel;
                }
            }
        }
        if (foundNum) {
            System.out.println(seachNum + " foi encontrado!");
        } else {
            System.out.println(seachNum + " não foi encontrado!");
        }
    }
}
