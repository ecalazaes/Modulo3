package aula2_EstruturasControles;

public class EstruturaInterrupt {
    public static void main(String[] args) {
        String names[] = {"Bernardo", "Bianca", "Breno", "Carlos"};

        String searchName = "Erick";

        boolean foundName = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(searchName)) {
                foundName = true;
                break;
            }
        }
        if (foundName) {
            System.out.println(searchName + " encontrado!");
        } else {
            System.out.println(searchName + " não encontrado!");
        }
    }
}
