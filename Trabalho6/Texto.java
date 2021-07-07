package Trabalho6;

public class Texto extends Documento{
	public Texto(String nome, int endereço, int total)
	{
		super(nome, endereço, total);
	}
	
	public void abrir() {
		System.out.println("Texto");
	}

}
