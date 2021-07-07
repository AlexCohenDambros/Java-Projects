package Trabalho3;

public class Cliente {
	private String nome;
	private ContaCorrente contacorrente;
	
	public Cliente(String nome, int numero) {
		contacorrente = new ContaCorrente();
		this.nome = nome;
		contacorrente.setNumero(numero);	
	}
	
	public void operar() {
		System.out.println("Nome: " + nome);

		contacorrente.depositar(100);
		contacorrente.retirar(50);
		contacorrente.verificar();
		contacorrente.imprimir();
	}
	
	

}
