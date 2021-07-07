package PROVA02;

public class Carro implements PegadaDeCarbono {
	
	private double gasolina;
	private double kmrodados;
	private double estadocarro;
	
	public Carro(double gasolina, double kmrodados) {
		this.gasolina = gasolina;
		this.kmrodados = kmrodados;
	}

	public void verificar() throws ExcecaoCarro {		
		if (gasolina == 0) {
			throw new ExcecaoCarro("Carro sem gasolina");
		}
		if(kmrodados == 0) {
			throw new ExcecaoCarro("Seu carro não possui km rodados");
		}
		
	}

	@Override
	public double getPegadaDeCarbono() {
		estadocarro = gasolina * kmrodados / 2;
		return estadocarro;
	}

}
