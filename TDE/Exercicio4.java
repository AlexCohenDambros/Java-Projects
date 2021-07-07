package TDE;

import java.util.Scanner;
public class Exercicio4 {
	public int Celsius(int fahr) {
		float Cels = ((fahr - 32)/1.8f);
		int i = (int)Cels;
		return i;
	}
	public int Fahrenheint (int celsius) {
		float fahr = (1.8f * celsius +32);
		int i = (int)fahr;
		return i;
	}
	public static void main(String[] args) {
		Exercicio4 conversor = new Exercicio4();
		System.out.println("== Conversor de Temperatura ==");
		Scanner temperatura = new Scanner(System.in);
		Scanner escala = new Scanner(System.in);
		System.out.println("Fahrenheint -> Celsius");
		System.out.println("1 + temperatura");
		System.out.println("Celsius -> Fahrenheint");
		System.out.println("2 + temperatura");
		int scale = escala.nextInt();
		int degrees = temperatura.nextInt();
		if (scale == 1) {
			System.out.println(String.format("Fahrenheit: %s", conversor.Celsius(degrees)));			
		}
		else if (scale == 2) {
			System.out.println(String.format("Celsius: %s", conversor.Fahrenheint(degrees)));
		}
		else {
			System.out.println("Numero inválido");
		}
	}
}

