import java.util.Scanner;

public class EntradadeDados {
	
	public static void main(String[] args) {
		
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o nome do aluno: ");
		String  nome = teclado.nextLine();
		
		
		System.out.println("Digite as notas do aluno: ");
		Float nota2 = teclado.nextFloat();
		Float nota3 = teclado.nextFloat();
		
		Float nota = (nota2 + nota3) / 2;
		
		System.out.println("A nota " + nome + " é " + nota);

		
	}
}
