package Trabalho6;

public class Arquivo {
	private String nome;
	private int endereço;
	private int total;
	
	public Arquivo(String nome, int endereço, int total)
	{
		this.nome = nome;
		this.endereço = endereço;
		this.total = total;
	}
	public String getNome() {
		return this.nome;
	}
	public int getAdress() {return this.endereço;}
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

