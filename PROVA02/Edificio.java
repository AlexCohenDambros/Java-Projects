package PROVA02;

public class Edificio implements PegadaDeCarbono {
	
	private double altura;
	private double area;
	private double estado;
	
	public Edificio(double altura, double area) {
		this.altura = altura;
		this.area = area;
	}
	
	public void verificar() throws ExcecaoPredio {
		if (altura < 10) {
			throw new ExcecaoPredio("Voce nao mora em um predio");
		}
		if (area < 0) {
			throw new ExcecaoPredio("Voce nao esta em um prédio");
		}
	}

	@Override
	public double getPegadaDeCarbono(){
		estado = altura * area;
		return estado;
	}

}