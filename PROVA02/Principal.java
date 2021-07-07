package PROVA02;

import java.util.ArrayList;


public class Principal {
	
public static void main(String[] args) {
	
	ArrayList<Edificio> predio1 = new ArrayList<Edificio>();
	ArrayList<Carro> carro1 = new ArrayList<Carro>();
	ArrayList<Bicicleta> bike1 = new ArrayList<Bicicleta>();
	
	
	predio1.add(new Edificio(110,100));
	carro1.add(new Carro(20,300));
	bike1.add(new Bicicleta(0,0));
	
	try {
		for(Edificio a : predio1)
		{	
			
			System.out.println("Edificio");
			System.out.println("Estado do Edificio: " + a.getPegadaDeCarbono());
			System.out.println("=====================================================");
			a.verificar();
			
		}
		
		for(Carro b : carro1)
		{
			System.out.println("Carro");
			System.out.println("Estado do carro: " + b.getPegadaDeCarbono());
			System.out.println("=====================================================");
			b.verificar();
			
		}
		
		for(Bicicleta c : bike1)
		{
			System.out.println("Bicicleta");
			System.out.println("Estado da bicileta: " + c.getPegadaDeCarbono());
			System.out.println("=====================================================");
			c.verificar();
		}
	}
	catch(ExcecaoPredio e)
	{
		
		System.out.println("ERRO: " + e.getMessage());
		
	}
	catch(ExcecaoCarro e)
	{
		
		System.out.println("ERRO: " + e.getMessage());
		
	}
	catch(ExcecaoBike e)
	{
		
		System.out.println("ERRO: " + e.getMessage());
		
	}
		
}
}
	
