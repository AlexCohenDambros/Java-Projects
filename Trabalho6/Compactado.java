package Trabalho6;

import java.util.ArrayList;

public class Compactado extends Arquivo{
	
	private ArrayList<Arquivo> arquivos;
	public Compactado(String nome) 
	{
		
		super(nome, 0, 0);
		arquivos = new ArrayList<Arquivo>();
	}
	
	public void abrir()
	{
		System.out.println("Abriu o arquivo compactado " + super.getNome() + ".zip");
	}
	public void listar_arquivos()
	{
		for (Arquivo a : this.arquivos)
		{
			System.out.println("Nome: " + a.getNome());
			System.out.println("Primeiro bloco: " + a.getAdress());
			System.out.println("Total de blocos: " + a.getTotal());
		}
	}
}
