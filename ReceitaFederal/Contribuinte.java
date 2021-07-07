package ReceitaFederal;

import java.util.ArrayList;

public class Contribuinte {
	
	private String nome;
	private ArrayList<Dependente> dep;
	
	public Contribuinte(String nome) {
		
		this.nome = nome;
		dep = new ArrayList<Dependente>();
		
	}
	
	public void ligarDependente(Dependente d) {
		
		dep.add(d);
		
	}
	
	public void Imprimir() {
		
		System.out.println("Contribuinte: " + nome);
		imprimirDependentes();
		
	}
	
	private void imprimirDependentes() {
		
		for (Dependente d : dep) {
			d.Imprimir();
		}
		
	}
	
	public int numeroDependentes() {
		return dep.size();
		
	}
	
	
}
