package Trabalho6;

public class Arquivo {
	private String nome;
	private int endere�o;
	private int total;
	
	public Arquivo(String nome, int endere�o, int total)
	{
		this.nome = nome;
		this.endere�o = endere�o;
		this.total = total;
	}
	public String getNome() {
		return this.nome;
	}
	public int getAdress() {return this.endere�o;}
	public int getTotal() {return this.total;}
	
	public void imprimir_nome()
	{
		System.out.println("Nome do arquivo: " + this.nome);
	}
	public void abrir() 
	{
		System.out.println("Abriu o arquivo " + this.nome + " para editar.");
	}
}

