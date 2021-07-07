package Trabalho5;

public class Principiante extends Jogador {
	private double bonus;
	
	public Principiante(String nome, int score, double bonus) {
		super(nome, score);
		this.bonus = bonus;
	}
	
	public void imprimir() {
	
		super.imprimir(); // chama método da superclasse
		System.out.println("O bonus do jogador é: " + bonus);
	}
	
	public void ganhar(int p) {
		super.score = super.score + p;
		bonus += 0.1 * p;
	}
	
	public void perder(int p) {
		super.score = super.score - p;
		bonus -= 0.9 * p;
	}


}
