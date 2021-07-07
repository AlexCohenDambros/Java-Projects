package Trabalho3;

public class ContaCorrente {
	private int numero;
	private double saldo;
	private Cliente cliente;
	
	public ContaCorrente() {
		this.saldo = 0;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void depositar(double deposito) {
		this.saldo += deposito;
		System.out.println("Deposito: " + saldo);
	} 
	
	public void retirar(double saque) {
		if (saque > saldo)
			System.out.println("Valor de saque inválido!!");
		else
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
