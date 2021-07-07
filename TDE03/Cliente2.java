package TDE03;

import TDE03.ContaCorrente2;

public class Cliente2 {
	private String nome;
	private ContaCorrente2 contacorrente;
	
	public Cliente2(String nome, int numero) {
		contacorrente = new ContaCorrente2(nome);
		this.nome = nome;
		contacorrente.setNumero(numero);	
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void imprimir()
	{
		contacorrente.imprimir();
	}
	public void operar(int deposito, int saque, int numero, String nome) throws ExecaoSaldoInsuficiente, ExcecaoContaInvalida, ExcecaoNomeInvalido {
		System.out.println("Nome: " + nome);
		contacorrente.setCliente(this.nome);
		contacorrente.depositar(deposito, numero, nome);
		contacorrente.retirar(saque, numero, nome);
		contacorrente.verificar();
		contacorrente.imprimir();
	}
	
	

}