package Trabalho6;
import java.util.ArrayList;

public class Disco extends Pasta{
	private char nome;
	private ArrayList<Pasta> pastas;
	
	
	
	public Disco(char nomechar) {
		super("");
		this.nome = nomechar;
		this.pastas = new ArrayList<Pasta>();
	}
	public Pasta criar_pasta(String nome)
	{
		Pasta novaPasta = new Pasta(nome);
		this.pastas.add(novaPasta);
		return novaPasta;
	}
	public void remover(String nome)
	{
		int number = 1;
		for (Pasta pasta1: this.pastas)
		{
			
			if (pasta1.getNome().equals(nome))
			{
				
				number = 0;
				this.pastas.remove(this.pastas.indexOf(pasta1));
				break;
			}
			
		}
		if (number == 1)
		{
			System.out.println("Pasta não encontrada");
		}
		
	}
	public void listar() {
		System.out.println("__________________");
		System.out.println("Pastas:");
		for (Pasta pasta1 : this.pastas)
		{
			
			System.out.println(pasta1.getNome());
		}
		System.out.println("__________________");
		
	}
	
}
