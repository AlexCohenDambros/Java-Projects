package Trabalho8;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ContaCorrente {
	
	private int numero;
	private String senha;
	private double saldo;
	
	public ContaCorrente(int numero, String senha, double saldo) {
		this.numero = numero;
		this.senha = senha;
		this.saldo = saldo;
	}
	
	public int verificadorHorario() {
		
		SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss" );
	    Calendar cal = Calendar.getInstance();
	    
	    cal.set(Calendar.HOUR_OF_DAY, 10);
	    
	    return Calendar.HOUR_OF_DAY - 1;
	    
		
	}
	
	@Override
	public String toString() {
		return "ContaCorrente [numero =" + this.numero + ", senha=" + this.senha + ", saldo=" + this.saldo +"]";
	}
	
	public void retirar(int numero, String senha, double valor, int horas)
			throws	ExecaoSaldoInsuficiente, ExcecaoHorarioInvalido,
			 		ExcecaoContaInvalida, ExcecaoSenhaInvalida
	
	{
		
		if(this.numero> 10) 
			throw new ExcecaoContaInvalida("Conta Invalida");

			
		if(!this.senha.equals("POO"))
			throw new ExcecaoSenhaInvalida("Senha Invalida");
		
		if(saldo < valor)
			throw new ExecaoSaldoInsuficiente("Saldo Insuficiente");
		
		if(horas < 8 || horas > 22)
			throw new ExcecaoHorarioInvalido("Horaria Invalido");
			
		this.saldo -= valor;
	}

}
