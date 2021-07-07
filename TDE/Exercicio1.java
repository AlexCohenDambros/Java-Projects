package TDE;

import java.util.Scanner;

public class Exercicio1{
	public int media(int a, int b, int c) {
		int media = (a+b+c)/3;
		return media;
	}
	public int soma(int a, int b, int c) {
		int soma = a+b+c;
		return soma;
		
	}
	public int produto(int a, int b, int c) {
		int produto = a*b*c;
		return produto;	
	}
	public int maior(int a, int b, int c) {
		if (a>b && a>c) {
			return a;
		}
		else if (c>a && c>b) {
			return c;
		}
		else {
			return b;
		}
	}
	public int menor(int a, int b, int c) {
		if (a<b && a<c) {
			return a;
		}
		else if (b<a && b<c) {
			return b;
		}
		else {
			return c;
		}
	}
	public static void main(String[] args) {
		Exercicio1 exec1 = new Exercicio1();
		System.out.println("Digite os três números (número+enter três vezes)");
		Scanner v1 = new Scanner(System.in);
		Scanner v2 = new Scanner(System.in);
		Scanner v3 = new Scanner(System.in);
		int a = v1.nextInt();
		int b = v2.nextInt();
		int c = v3.nextInt();
		System.out.println("média: " + exec1.media(a,b,c));
		System.out.println("soma: " + exec1.soma(a,b,c));
		System.out.println("produto: " + exec1.produto(a,b,c));
		System.out.println("maior: " + exec1.maior(a,b,c));
		System.out.println("menor: " + exec1.menor(a,b,c));
	}
}
