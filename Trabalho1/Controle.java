package Trabalho1;

public class Controle {
	public static void main(String[] args){
        Semaforo classe = new Semaforo();
        System.out.println("Cor atual do sem�foro: " + classe.cor);
        for (int i = 0; i<10; i++){
            classe.MudaProximaCor();
            System.out.println("Sequencia de cor do sem�foro (1 at� 10): valor: " + i + " ,cor do sem�foro: "+ classe.cor);
        }

        classe.MudaCorFixa(1);
        System.out.println("Cor fixa do sem�foro em amarelo: " + classe.cor);
	}
}
