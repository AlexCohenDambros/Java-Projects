package Trabalho6;

public class Apresentacao extends Documento{
	public Apresentacao(String nome, int endereço, int total)
	{
		super(nome, endereço, total);
	}
	
	public void abrir() {
		System.out.println("Texto");
	}

}