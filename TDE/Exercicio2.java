package TDE;


public class Exercicio2 {
	public static void main(String[] args) {
		int numero = 3489723;
		char[] digitos = String.valueOf( numero ).toCharArray();
		for ( char d : digitos ) {
			System.out.print( d + " " );
			}
	}
}