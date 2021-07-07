package Trabalho3;

public class Banco {
	
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Alek", 1234);
		Cliente cliente2 = new Cliente("brandonis", 7896);
		Cliente cliente3 = new Cliente("gabu", 4561);
		
		cliente1.operar();
		cliente2.operar();
		cliente3.operar();
		
	}
}
