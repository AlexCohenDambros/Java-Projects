package TDE03;

import TDE03.ExecaoSaldoInsuficiente;
import TDE03.Cliente2;
import TDE03.ExcecaoContaInvalida;

public class ContaCorrente2 {
	private int numero;
	private double saldo;
	private String cliente;
	
	public ContaCorrente2(String c) {
		this.saldo = 0;
		this.cliente = c;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setCliente(String c) {
		this.cliente = c;
	}
	public void depositar(double deposito, int num, String nome) throws  ExcecaoContaInvalida, ExcecaoNomeInvalido{
			
			if (num != numero) {
				throw new ExcecaoContaInvalida("Numero de Conta incorreta");
			}
			if (!nome.equals(cliente)) {
				throw new ExcecaoNomeInvalido("Nome Invalido");
			}
			
			this.saldo += deposito;
			System.out.println("Deposito: " + saldo);
			
		
	}

	
	public void retirar(double saque, int num, String nome) throws ExecaoSaldoInsuficiente, ExcecaoContaInvalida, ExcecaoNomeInvalido{
		
			if (num != numero) {
				throw new ExcecaoContaInvalida("Numero de Conta incorreta");
			}
			if (!nome.equals(cliente)) {
				throw new ExcecaoNomeInvalido("Nome Invalido");
			
			}
			if (saldo<saque) {
				throw new ExecaoSaldoInsuficiente("Saldo Insuficiente");
			}
			
			this.saldo -= saque;
			System.out.println("Saque: " + saldo);
}
	
	public void verificar() {
		System.out.println("O seu saldo atual é: " + saldo);
	}
	
	public void imprimir() {
		System.out.println("O numero de sua conta é: " + numero);
		System.out.println("O saldo de sua conta é: " + saldo);
		System.out.println("----------------------------------");
	}
	
	
	
}

