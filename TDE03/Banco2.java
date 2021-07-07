package TDE03;

import java.util.ArrayList;

import TDE03.ContaCorrente2;
import TDE03.ExcecaoContaInvalida;
import TDE03.ExcecaoNomeInvalido;
import TDE03.ExecaoSaldoInsuficiente;
import TDE03.ContaCorrente2;
import TDE03.Cliente2;
import java.util.Random;

public class Banco2 {
	private ArrayList<Cliente2> clientes2;
	private int[] listaConta = {1234, 7996, 1675, 9735, 1684, 2134, 7564, 4689, 4301, 5678, 1346};
	private String[] listaNomes = {"Aleki", "Joao", "Gabriel", "Roberto", "Rogerio", "Alex", "Alberto", "Elon", "Elaine", "Roberta", "Fabio"};
	
	public Banco2()
	{
		clientes2 = new ArrayList<Cliente2>();
	}
	
	public void operações() throws ExcecaoContaInvalida, ExcecaoNomeInvalido
	{
		int index = 0;
		int cont1 = 20;
		int cont2 = 10;
		for (Cliente2 c : clientes2) {
				
				System.out.println("---------------------------");
				System.out.println("ANTES DA OPERACAO:");
				c.imprimir();
				int x = listaConta[index];
				String name = listaNomes[index];
				try {
					c.operar(cont1, cont2, x, name);
					System.out.println("Saque OK");
				}catch (ExcecaoNomeInvalido e)
				{
					System.out.println("*** Erro: " +  e.getMessage());
					
				}catch (ExcecaoContaInvalida e){
					System.out.println("*** Erro: " +  e.getMessage());
					
				
				}catch (ExecaoSaldoInsuficiente e) {
					System.out.println("*** Erro: " +  e.getMessage());
						
				}
				finally {
					System.out.println("\nAPOS A OPERACAO: ");
					c.imprimir();
					cont1 += 10;
					cont2 = cont2 + 35;
					index++;
			}
			
		}
	}
	public static void main(String[] args) throws ExecaoSaldoInsuficiente, ExcecaoContaInvalida, ExcecaoNomeInvalido {
		Banco2 bank = new Banco2();
		bank.clientes2.add(new Cliente2("Alek", 1234));
		bank.clientes2.add(new Cliente2("Joao", 7896));
		bank.clientes2.add(new Cliente2("Gabriel", 1675));
		bank.clientes2.add(new Cliente2("Roberto", 9735));
		bank.clientes2.add(new Cliente2("Roger", 1684));
		bank.clientes2.add(new Cliente2("Alex", 2534));
		bank.clientes2.add(new Cliente2("Alfredo", 7564));
		bank.clientes2.add(new Cliente2("Elon", 4189));
		bank.clientes2.add(new Cliente2("Elaine", 4301));
		bank.clientes2.add(new Cliente2("Roberta", 5678));
		bank.clientes2.add(new Cliente2("Fabio", 1346));
		
		bank.operações();
		
		//cliente1.operar();
		//cliente2.operar();
		//cliente3.operar();
		
	}
}