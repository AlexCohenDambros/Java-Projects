package Trabalho6;

public class Texto extends Documento{
	public Texto(String nome, int endere�o, int total)
	{
		super(nome, endere�o, total);
	}
	
	public void abrir() {
		System.out.println("Texto");
	}

}
