package bibliotecas;

public class TesteString {
	public static void main(String[] args) {
		String a = new String("Java no Senac");
		String b = new String("Java no Senac");
		
		if (a == b) {
			System.out.println("a e b são iguais");
		} else {
			System.out.println("a e b são diferentes");
		}
		
		int i = 6;
		int j = 6;
		
		if (i == j) {
			System.out.println("i e j são iguais");
		} else {
			System.out.println("i e j são diferentes");
		}
		
		if (a.equals(b)) {
			System.out.println("a e b são iguais");
		} else {
			System.out.println("a e b são diferentes");
		}
	}

}
