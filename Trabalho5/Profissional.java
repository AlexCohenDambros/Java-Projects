package Trabalho5;

public class Profissional extends Jogador {
	private double capital;
	
	public Profissional(String nome, int score, double capital) {
		super(nome, score);
		this.capital = capital;
	}
	

	public void imprimir() {
		super.imprimir(); // chama m�todo da superclasse
		System.out.println("O capital do jogador �: " + capital);
	}
	
	public void ganhar(int p) {
		super.score = super.score + p;
		capital += p * 4;
	}
	
	public void perder(int p) {
		super.score = super.score - p;
		capital -= p * 4;
	}
}
