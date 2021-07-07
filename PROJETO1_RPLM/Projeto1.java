package PROJETO1_RPLM;

import java.util.Arrays;
import java.util.Scanner;

public class Projeto1 {
		
	//ARRAY PARA COMPARAR E FAZER UM FBF
	static String [] array = {"p", "~p", "pvq", "p^q","~pvq", "pv~q", "~p^q", "p^~q", "~pv~q", "pvq^r", "~p^~q", "p^qvr", "p^q^r", "pvqvr", "~p^qvr", "~pvq^r", "pv~q^r",   "pvq^~r", "pvqv~r", "~pvqvr", "pv~qvr", "p^~qvr", "p^qv~r", "~pv~q^r", "~pvq^~r", "pv~q^~r", "~p^~qvr", "~p^qv~r", "p^~qv~r", "~pv~qvr", "~pvqv~r", "pv~qv~r", "~p^~q^r", "~p^q^~r", "p^~q^~r", "~pv~q^~r", "~p^~qv~r",  "~p^~q^~r", "~pv~qv~r"};
	
	// MÉTODO PARA TRANSFORMAR A STRING EM LETRA MINU
	public static String transformar(String input){
        String dados_saida = "";
        for(int i = 0; i < input.length(); i++){
            char minus = input.charAt(i);
            if(minus == ' ')
            {
            	continue;
            }
            dados_saida += minus;
        }
        return dados_saida;
    }
	
    public static void main (String[] args) {
    	
    	String EntradaFinal = "";
    	
    	//ENTRADA DE DADOS
    	boolean running = true;
		while (running) { 
			System.out.println("=================================================================================");
			System.out.println("Use apenas as variáveis 'p', 'q' ou 'r' junto com os conectivos '~', 'v' ou '^' ");
			System.out.print("Entre com a formula desejada: ");
			Scanner teclado = new Scanner(System.in);
			String entrada = transformar(teclado.nextLine().toLowerCase());
	
			//VERIFICANDE SE É UMA FBF 
			if (Arrays.stream(array).anyMatch(t -> t.equals(entrada))){
					System.out.println("############################################################################");
					System.out.println("                     FORMULA BEM FORMADA!!!");
					System.out.println("############################################################################");
					EntradaFinal = entrada;
					break;
			}
			else
				System.out.println("############################################################################");
				System.out.println("    Você digitou uma formula não bem formada!!! Tente Novamente!!!");
				System.out.println("############################################################################");
				running = true;
			
		}
		
		Projeto1.PlotarTabelaVerdade(EntradaFinal);
		
	}
    
    //FUNÇÃO PARA RETORNAR O VALOR DE UMA VARIAVEL (VERDADEIRO OU FALSO)
    public static char printBit(boolean p) {
		if (p)
		return 'V';
		else
		return 'F';
	}
    
    //FUNÇÃO PARA PLOTAR/MOSTRAR A TABELA VERDADE
    public static void PlotarTabelaVerdade(String entrada)
	{
		boolean p,q,r;
		int tamanho = entrada.length();
		
		System.out.println ("                     Tabela Verdade!");
		System.out.println ("Fórmula: " + entrada + "    | Resultado Final(última coluna)");
		System.out.println ("-------------------------------------------------------");
		
		int variaveis = 0;
		for (int i = 0; i < entrada.length(); i++)
		{
			if (entrada.charAt(i) == 'p' || entrada.charAt(i) == 'q' || entrada.charAt(i) == 'r')
			{
				variaveis++;
			}
		}
		
		switch (variaveis)
		{
		case 3:
			for (int i = 7; i >= 0; i--) {
				switch (i) {
				case 7:
					p = true; q = true; r = true;
					break;
				case 6:
					p = true; q = true; r = false;
					break;
				case 5:
					p = true; q = false; r = true;
					break;
				case 4:
					p = true; q = false; r = false;
					break;
				case 3:
					p = false; q = true; r = true;
					break;
				case 2:
					p = false; q = true; r = false;
					break;
				case 1:
					p = false; q = false; r = true;
					break;
					
				default:
					p = false; q =false; r = false;
				}
				
				
				switch (tamanho)
				{
				
				case 3:
					if (entrada.equals("pvq"))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q));
						System.out.println(" | " + printBit(p || q) + "|");
					}
					else if (entrada.equals("p^q"))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q));
						System.out.println(" | " + printBit(p && q) + "|");
					}
				case 4:
					if (entrada.equals("~pvq"))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q));
						System.out.println(" | " + printBit(!p || q) + "|");
					}
					else if (entrada.equals("pv~q"))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q) );
						System.out.println(" | " + printBit(p || !q) + "|");
					}
					else if (entrada.equals("~p^q"))
					{
						
						System.out.print ("| " + printBit(p) + " | " + printBit(q));
						System.out.println(" | " + printBit(!p && q) + "|");
					}
					else if (entrada.equals("p^~q"))
					{
						
						System.out.print ("| " + printBit(p) + " | " + printBit(q));
						System.out.println(" | " + printBit(p && !q) + "|");
					}
				case 5:
					if (entrada.equals("~pv~q"))
					{
						
						System.out.print ("| " + printBit(p) + " | " + printBit(q) );
						System.out.println(" | " + printBit(!p || q) + "|");
					}
					else if (entrada.equals("~p^~q"))
					{
						
						System.out.print ("| " + printBit(p) + " | " + printBit(q) );
						System.out.println(" | " + printBit(!p && !q) + "|");
					}
					else if (entrada.equals("pvq^r"))
					{
						
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p || q && r) + "|");
					}
					else if (entrada.equals("p^qvr"))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p && q || r) + "|");
					}
				case 6:
					if (entrada.equals("~p^qvr "))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p && q || r) + "|");
					}
					else if (entrada.equals("~pvq^r"))
					{
				
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p || q && r) + "|");
					}
					else if (entrada.equals("pv~q^r "))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p || !q && r) + "|");
					}
					else if (entrada.equals("pvq^~r"))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p || q && !r) + "|");
					}
					else if (entrada.equals("pvqv~r"))
					{
				
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p || q || !r) + "|");
					}
					else if (entrada.equals("pv~qvr"))
					{
			
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p || q || !r) + "|");
					}
					else if (entrada.equals("~pvqvr"))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p || q || r) + "|");
					}
					else if (entrada.equals("p^~qvr"))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p && !q || r) + "|");
					}
					else if (entrada.equals("p^qv~r"))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p && q || !r) + "|");
					}
				case 7:
					if (entrada.equals("~pv~q^r"))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p || !q && r) + "|");
					}
					else if(entrada.equals("~pvq^~r "))
					{
			
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p || q && !r) + "|");
					}
					else if(entrada.equals("pv~q^~r "))
					{

						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p || !q && !r) + "|");
					}
					else if(entrada.equals("~p^~qvr"))
					{
			
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p && !q || r) + "|");
					}
					else if(entrada.equals("~p^qv~r"))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p && q || !r) + "|");
					}
					else if(entrada.equals("p^~qv~r"))
					{
				
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p && !q || !r) + "|");
					}
					else if(entrada.equals("~pv~qvr"))
					{
			
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p || !q || r) + "|");
					}
					else if(entrada.equals("~pvqv~r"))
					{
			
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p || q || !r) + "|");
					}
					else if(entrada.equals("pv~qv~r"))
					{
				
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p || !q || !r) + "|");
					}
					else if(entrada.equals("~p^~q^r"))
					{
					
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p && !q && r) + "|");
					}
					else if(entrada.equals("~p^q^~r"))
					{
		
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p && q && !r) + "|");
					}
					else if(entrada.equals("p^~q^~r"))
					{
		
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p && !q && !r) + "|");
					}
				case 8:
					if (entrada.equals("~pv~q^~r"))
					{
	
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p || !q && !r) + "|");
					}
					else if (entrada.equals("~p^~qv~r"))
					{
		
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p && !q || !r) + "|");
					}
					else if (entrada.equals("~pv~qv~r"))
					{

						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p || !q || !r) + "|");
					}
					
					else if (entrada.equals("pvqvr"))
					{

						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(p || q || r) + "|");
					}
					
					else if (entrada.equals("~p^~q^~r"))
					{
		
						System.out.print ("| " + printBit(p) + " | " + printBit(q) + " | " + printBit(r) );
						System.out.println(" | " + printBit(!p && !q && !r) + "|");
					}
				}
			}
			
		case 2:
			for (int i = 3; i >= 0; i--) {
				switch (i) {
					case 3:
						p = true; q = true;
						break;
					case 2:
						p = true; q = false;
						break;
					case 1:
						p = false; q = true;
						break;
						
				default:
				p = false; q = false;
				}
				switch (tamanho)
				{
				case 1:
					if (entrada.equals("p"))
					{
		
						System.out.print ("| " + printBit(p));
						System.out.println(" | " + printBit(p) + "|");
					}
				case 2:
					if (entrada.equals("~p"))
					{
	
						System.out.print ("| " + printBit(p));
						System.out.println(" | " + printBit(!p) + "|");
					}
					
				case 3:
					if (entrada.equals("pvq"))
					{

						System.out.print ("| " + printBit(p) + " | " + printBit(q));
						System.out.println(" | " + printBit(p || q) + "|");
					}
					else if (entrada.equals("p^q"))
					{
		
						System.out.print ("| " + printBit(p) + " | " + printBit(q));
						System.out.println(" | " + printBit(p && q) + "|");
					}
				case 4:
					if (entrada.equals("~pvq"))
					{
			
						System.out.print ("| " + printBit(p) + " | " + printBit(q));
						System.out.println(" | " + printBit(!p || q) + "|");
					}
					else if (entrada.equals("pv~q"))
					{

						System.out.print ("| " + printBit(p) + " | " + printBit(q) );
						System.out.println(" | " + printBit(p || !q) + "|");
					}
					else if (entrada.equals("~p^q"))
					{
		
						System.out.print ("| " + printBit(p) + " | " + printBit(q));
						System.out.println(" | " + printBit(!p && q) + "|");
					}
					else if (entrada.equals("p^~q"))
					{
			
						System.out.print ("| " + printBit(p) + " | " + printBit(q));
						System.out.println(" | " + printBit(p && !q) + "|");
					}
				case 5:
					if (entrada.equals("~pv~q"))
					{

						System.out.print ("| " + printBit(p) + " | " + printBit(q) );
						System.out.println(" | " + printBit(!p || q) + "|");
					}
					else if (entrada.equals("~p^~q"))
					{

						System.out.print ("| " + printBit(p) + " | " + printBit(q) );
						System.out.println(" | " + printBit(!p && !q) + "|");
					}
				}
			} 
		case 1:
			for (int i = 1; i >= 0; i--) {
				switch (i) {
				case 1:
				p = true;
				break;
				default:
					p = false;
				}
			switch (tamanho)
			{
			case 1:
				if (entrada.equals("p"))
				{

					System.out.print ("| " + printBit(p));
					System.out.println(" | " + printBit(p) + "|");
				}
			case 2:
				if (entrada.equals("~p"))
				{

					System.out.print ("| " + printBit(p));
					System.out.println(" | " + printBit(!p) + "|");
				}
			  }
			}	
		}	
	}
}
  
           