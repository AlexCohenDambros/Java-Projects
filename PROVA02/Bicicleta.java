package PROVA02;

public class Bicicleta implements PegadaDeCarbono {
	
	private double rodagem;
	private double numerodepedaladas;
	private double estadobike;
	
	public Bicicleta(double rodagem, double numerodepedaladas) {
		this.rodagem = rodagem;
		this.numerodepedaladas = numerodepedaladas;
	}
	
	public void verificar() throws ExcecaoBike {		
		if (rodagem <= 0) {
			throw new ExcecaoBike("Voce nao andou de bicicleta!");
		}
		
		if (numerodepedaladas <= 0) {
			throw new ExcecaoBike("Voce pedalou com a bicicleta!");
		}
	}

	@Override
	public double getPegadaDeCarbono() {
		estadobike = (rodagem * numerodepedaladas) / 3;
		return estadobike;
	}

}
