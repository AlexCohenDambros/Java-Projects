package Trabalho6;
import java.util.ArrayList;

public class Pasta extends Arquivo{
	private String nome;
	private ArrayList<Arquivo> arquivos;

	public Pasta(String nome)
	{
		super("", 0, 0);
		this.nome = nome;
		this.arquivos = new ArrayList<Arquivo>();
		
	}
	public String getNome() {
		return nome;
	}
	public void inserir(Documento D)
	{
		Arquivo archive = new Arquivo(D.getNome(), D.getAdress(), D.getTotal());
		this.arquivos.add(archive);
	}
	public void remover(String nome)
	{
		int num = 0;
		int index = 0;
		for (Arquivo arq : this.arquivos)
		{
			if (arq.getNome().equals(nome))
			{
				num = 1;
				this.arquivos.remove(index);
				break;
			}
			index++;
		}
		if (num == 0)
		{
			System.out.println("Arquivo não encontrado");
		}
	}
	public void listar()
	{
		System.out.println("Arquivos:");
		for (Arquivo arq : this.arquivos)
		{
			System.out.println(arq.getNome());
		}
		System.out.println("__________________");
	}
	public void abrir_todos_arquivos()
	{
		System.out.println("Abrindo arquivos de " + this.nome);
		for (Arquivo arq : this.arquivos)
		{
			arq.abrir();
		}
		System.out.println("__________________");
	}
	public Compactado compactar()
	{
		Compactado c = new Compactado(this.nome);
		System.out.println("O arquivo " + this.nome + " foi compactado para " + this.nome + ".zip");
		return c;
	}
	public void duplicar(String nome)
	{
		int index = 0;
		for (Arquivo arq : this.arquivos)
		{
			if (arq.getNome().equals(nome))
			{
				
				Arquivo c = this.arquivos.get(index);
				this.arquivos.add(c);
				break;
			}
			index++;
		}
	}
	public void imprimir_nome()
	{
		System.out.println("Nome da pasta: " + this.nome);
	}
}
