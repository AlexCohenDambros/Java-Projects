package Trabalho4;

import java.util.ArrayList;
import java.util.Scanner;


public class Usuario {
	private String nome;
	private ArrayList<Contato> contato;
	
	
	public Usuario(String nome) {
		this.nome = nome;
		contato = new ArrayList<Contato>();
		
	}
	public void inserirContato(String nomeContato) {
		contato.add(new Contato(nomeContato));
	}
	
	public void enviarMensagem(String nome, String mensagem) {
		Contato ccontato = encontraContato(nome);
		if(ccontato != null){
            Mensagem msg = new Mensagem(this.nome + ": " + mensagem);
            ccontato.getMensagens().add(msg);
            System.out.println("------------------------");
            System.out.println("Mensagem enviada a " + nome);
		}
		else{
			System.out.println("------------------------");
            System.out.println("Contato nao existe");
        }
		
		
    }
    public void receberMensagem(String nome, String msg){
        Contato contato = this.encontraContato(nome);
        if (contato != null){
            contato.getMensagens().add(new Mensagem("[RECEBIDO]" + msg));
            System.out.println(" ** Enviado com Sucesso! ** ");
        }else{
            System.out.println("Contato " + nome + " inexistente");
        }
    }
	
    public void imprimirMensagens(){
        for (Contato c : this.contato){
            System.out.println(" - O contato com " + c.getNome()+ " tem "+ c.getMensagens().size() + " mensagens");
            c.imprimirMensagens();
        }
    }
 
	public Contato encontraContato(String nomeContato) {
		for (Contato contato : this.contato) {
            if (contato.getNome().equals(nomeContato)) {
                return contato;
            }
        }
        return null;
			
	}
	public static void main(String[] args) {
	     	Usuario usuario1 = new Usuario("Alex");
	        Usuario usuario2 = new Usuario("Brandolis");

	        usuario1.conversar();
	        usuario2.conversar();

	 }
		
	
	public void conversar(){
		
		boolean running = true;
		while (running) {
			Scanner n = new Scanner(System.in);
			System.out.println("----------MENU----------");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Enviar mensagem para contato");
            System.out.println("3 - Receber mensagem de contato");
            System.out.println("4 - Imprimir conversas");
            System.out.println("5 - Sair");
            System.out.println("------------------------");
            System.out.print("Entre com a operação desejada: ");
			Usuario user = new Usuario("");
			int num = n.nextInt();
			switch (num) {
			
				case 1:
					System.out.println("------------------------");
					System.out.println("Insira o nome do Contato: ");
					Scanner n2 = new Scanner(System.in);
					String nome = n2.nextLine();
					this.contato.add(new Contato(nome));
					System.out.println("------------------------");
					System.out.println("Contato Inserido!!");
					break;
					
				case 2:
					Scanner n3 = new Scanner(System.in);
					System.out.println("------------------------");
					System.out.println("Selecione o contato: ");
					String NomeContato = n3.nextLine();
					if ( this.encontraContato(NomeContato) != (null)) {
						Scanner n4 = new Scanner(System.in);
						System.out.println("------------------------");
						System.out.println("Insira a mensagem abaixo:");
						String Mensagem = n4.nextLine();
						this.enviarMensagem(NomeContato, Mensagem);
						break;
					}
					else {
						
						System.out.println("Contato Inexistente");	
						break;
					}
				
				case 3:
					Scanner n5 = new Scanner(System.in);
					System.out.println("------------------------");
					System.out.println("Selecione o contato: ");
					String nomeContato = n5.nextLine();
					if ( this.encontraContato(nomeContato) == null) {
						System.out.println("Contato Inexistente");	
						break;
					}
					else {
						System.out.println("------------------------");
						System.out.print("Entre com a mensagem para " + this.nome + ": ");
						Scanner n6 = new Scanner(System.in);
						String Mensagem = n6.nextLine();
						this.receberMensagem(nomeContato, Mensagem);
						break;
					}
					
				case 4:
					System.out.println("------------------------");
					System.out.println("Imprimir conversas");
					Scanner n7 = new Scanner(System.in);
					System.out.println("Selecione o contato");
					String nom = n7.nextLine();
					System.out.println("------------------------");
	                System.out.println("----- Conversas de [" + this.nome + "] -----");

	                imprimirMensagens();

	                break;
	                
				case 5:
					System.out.println("------------------------");
					System.out.println("FIM DO PROGRAMA!!!!!");
					running = false;

				
			
			}
			
		}
		
	}
	
}
