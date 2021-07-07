package ReceitaFederal;

public class Receita {
	
	public static void main(String[] args) {
		
		Contribuinte contribuinte1 = new Contribuinte( "Willian");
		Dependente dependente1 = new Dependente( "George");
		Dependente dependente2 = new Dependente( "Charlotte");
		Dependente dependente3 = new Dependente( "Louis");
		contribuinte1.ligarDependente(dependente1);
		contribuinte1.ligarDependente(dependente2);
		contribuinte1.ligarDependente(dependente3);
		contribuinte1.Imprimir();
		System.out.println("Número de dependentes: " + contribuinte1.numeroDependentes( ) + '\n');
		
		
		Contribuinte contribuinte2 = new Contribuinte("Harry");
		Dependente dependente4 = new Dependente("Archile");
		contribuinte2.ligarDependente(dependente4);
		contribuinte2.Imprimir();
		System.out.println("Número de dependentes: " + contribuinte2.numeroDependentes( ) + '\n');

	}

}
