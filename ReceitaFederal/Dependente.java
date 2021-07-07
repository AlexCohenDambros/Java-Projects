package ReceitaFederal;

public class Dependente {
	
	private String nome;
	
	public Dependente(String nome) {
		this.nome = nome;
	}
	
	public void Imprimir () {
		System.out.println("Dependente: " + nome);
	}
}
