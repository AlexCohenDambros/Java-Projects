package Trabalho5;

public class Teste {
	
	public static void main(String[] args) {
		
		Senior senior1 = new Senior("Alex" , 10, 100, 1000);
		Principiante principiante1 = new Principiante("Matheus", 1, 5);
		Profissional profissional1 = new Profissional("Gabiel", 10, 100);
		
		System.out.println("-------");
		System.out.println("Principiante");
		principiante1.imprimir();
		principiante1.ganhar(1);
		System.out.println("-------");

		System.out.println("Profissional");
		profissional1.imprimir();
		profissional1.perder(2);
		System.out.println("-------");

		System.out.println("Senior");
		senior1.imprimir();
		senior1.ganhar(10);
		
		
		
	}

}
