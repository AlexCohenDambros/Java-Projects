package Trabalho6;

public class Sistema {
	 public static void main(String[] args) {
		 
	 Disco d = new Disco('C');
	 Pasta escola = d.criar_pasta("Escola");
	 Pasta pessoal = d.criar_pasta("Pessoal");
	 Texto t = new Texto("Trabalho 10", 8, 4);
	 escola.inserir(t);
	 Apresentacao a = new Apresentacao("Defesa Projeto 2", 27, 3);
	 escola.inserir(a);
	 Planilha p = new Planilha("Calculo 2", 40, 6);
	 escola.inserir(p);
	 escola.listar();
	 Video v = new Video("Aniversario", 33, 5);
	 pessoal.inserir(v);
	 Imagem i = new Imagem("Foto RJ", 70, 2);
	 pessoal.inserir(i);
	 Som s = new Som("Musica Chico", 58, 7);
	 pessoal.inserir(s);
	 pessoal.listar();
	 Compactado k = pessoal.compactar();
	 d.listar(); 
	 d.remover("Pessoal");
	 k.abrir(); 
	 d.listar();
	 escola.abrir_todos_arquivos();
	 pessoal.abrir_todos_arquivos();
	 escola.remover("Trabalho 10");
	 escola.duplicar("Defesa Projeto 2");
	 escola.listar();
	 }
	}