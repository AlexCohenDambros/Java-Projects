// Lista de elementos (Matriz)
public class ArrayTeste {
	
	public static void main(String [] args) {
		
		int [] array = {70, 71 , 73, 74, 75, 76};
		
		// Para criar uma variavel array sem dados.
		// int[] a = new int[10];
		
		System.out.printf("%s%10s\n", " _______", " ________ ");
		System.out.printf("%s%10s\n", " Indice", "Valores");
		System.out.printf("%s%10s\n", "|-------", "|---------|");
		
		// array (nome da variavel, length(quantidade de numero dentro da variavel - contagem)
		for (int i = 0; i < array.length; i ++)
			System.out.printf("%5d%10d\n", i, array[i]);
		
		System.out.printf("%s%10s\n", "|-------", "|---------|");
	}
	
}
