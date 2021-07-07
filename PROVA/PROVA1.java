package PROVA;

import java.util.Scanner;

public class PROVA1 {
	public static void main(String[] args){
		
		boolean running = true;
		while (running) {
			Scanner n = new Scanner(System.in);
			System.out.println("----------MENU----------");
            System.out.println("1 - Jogar");;
            System.out.println("2 - Sair");
            System.out.println("------------------------");
            System.out.print("Entre com a operação desejada: ");
			int num = n.nextInt();
			switch (num) {
			
				case 1:

					while (running) {
						System.out.println("----------- Advinhe um número!!!!-------------");
						System.out.print("Insira um valor que esteja em sua mente que esteja entre 1 há 1000:");
						Scanner n2 = new Scanner(System.in);
						int valor = n2.nextInt();
						
						if (valor < 1) {
							System.out.println("Você digitou um valor muito baixo !!! Tente novamente!!!");
							running = true;
							
							
						}
						else if (valor > 1000) {
							
							System.out.println("Você digitou um valor muito alto !!! Tente novamente!!!");
							running = true;
							
						}
						
						else {
							
							int num_random = 0;
					        num_random = (int)(Math.random() * 999 + 1);
					        System.out.println("------------------------");
					        System.out.println("VALOR SORTEADO PELO JOGO: " + num_random); 
					        
					        if (valor == num_random) {
					        	System.out.println("****************************************");
					        	System.out.println("PARABENS O VALOR QUE VOCÊ DIGITOU " + valor + " ESTÁ CORRETO!!! PARABENS!!!" );
					        	System.out.println("****************************************");

					        }
					        else {
					        	System.out.println("------------------------");
						        System.out.println("Poxa, você digitou um valor diferente do que foi sorteado :< Tente novamente!!!");
					        	running = true;
					        }
					        System.out.println("------------------------");
					        System.out.println("Deseja jogar novamente? Sim = 1 / Não = 2");
					        System.out.print("Entre com a operação desejada: ");
					        Scanner chute = new Scanner(System.in);
					        int resposta = chute.nextInt();
					        
					        if (resposta == 2) {
								running = false;
					        }
					        else {
					        	running = true;
					        }
					
					}
				}
						
				
				case 2:
					System.out.println("------------------------");
					System.out.print("OBRIGADO POR PARTICIPAR, VOLTE SEMPRE!!");
					running = false;
					
			}
		}
	} 
}
