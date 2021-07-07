package Trabalho1;

public class Controle {
	public static void main(String[] args){
        Semaforo classe = new Semaforo();
        System.out.println("Cor atual do semáforo: " + classe.cor);
        for (int i = 0; i<10; i++){
            classe.MudaProximaCor();
            System.out.println("Sequencia de cor do semáforo (1 até 10): valor: " + i + " ,cor do semáforo: "+ classe.cor);
        }

        classe.MudaCorFixa(1);
        System.out.println("Cor fixa do semáforo em amarelo: " + classe.cor);
	}
}
