package PROJETOCOLAB;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;

public class Grafo {
	public ListaAdj[] grafo; // armazena os destinos (lista encadeada)
	private int tamanho; //numero de vertices ()
	private Vertice[] vertices; // armazena os vertices (lista encadeada)
	private int numeroAresta = 0;

	public Grafo(int tamanho) {
		this.tamanho = tamanho;
		this.grafo = new ListaAdj[tamanho];
		this.vertices = new Vertice[tamanho];

		for(int i = 0; i < tamanho; i++) { // preenche as duas listas (começa na lista dos grafos)
			vertices[i] = new Vertice();
			grafo[i] = null; // começam null pois pode nao fazer ligações
		}
	}

	public void criaAdj(int origem, int destino, double custo) { // origem começa em 0 e destino é o valor do local e o custo é o peso da aresta
		if(grafo[origem] == null) { // se a origem estiver nula na lista de adjacencia
			grafo[origem] = new ListaAdj(destino,custo); // adiciona uma nova lista adjacente pois nao tem nada
		}else { // caso ja tenha algum valor
			ListaAdj x = grafo[origem]; // pega o x como origem
			while(x.proximo != null) { // enquanto a origem for diferente de null
				x = x.proximo; // ele vai percorrendo
			}
			x.proximo = new ListaAdj(destino,custo); //e quando achar o local, vai acriar
		}
	}

	public void removeAdj(int origem, int destino) {
		if(grafo[origem] != null) { //se a origem for diferente de vazia
			ListaAdj x = grafo[origem]; // x é a origem
			ListaAdj y = null; // y começa como null (vai ser util mais pra frente)
			while(x.destino != destino) { // enquanto nao achar o destino na nossa lista encadeada
				y = x; // y vira a origem
				x = x.proximo; // pega o proximo valor
			}
			if(y == null){ // se a origem for null
				grafo[origem] = x.proximo; // grafo origem vira o destino proximo pois so tem um elemento na lista
			}else{ //senao
				y.proximo = x.proximo; // y recebe o proximo de X, eliminando o x
			}
		}
	}

	public void setaInfo(int i, String info) {
		vertices[i].info = info;
	}

	public double peso(int i, int j) {
		if(grafo[i] != null) { // se a origem for diferente de null
			ListaAdj x = grafo[i]; // x recebe o valor da origem
			while(x.destino != j) { // percorre todos os destinos
				x = x.proximo;
			}
			return x.peso; // depois retorna o peso entre eles
		}
		return 0;
	}

	public Grafo criaGrafo(File file) throws Exception { // serve para criar os gragos, passamos com parametro o arquivo txt
		ArrayList<String> nomes = Calcular.getNumeroemails(file); // alocamos de forma unica os emails presentes no arquivo
		int tamanho = nomes.size(); // pegamos a quantidade de emails unicos
		Grafo g = new Grafo(tamanho); //Criando um novo espaço para o grafo com o número de usuarios diferentes.

		for (int i = 0; i < tamanho; i++) {
			g.vertices[i].info = nomes.get(i); // inicializa os vertices
		}

		BufferedReader br2 = new BufferedReader(new FileReader(file)); // abre o arquivo
		String linha;

		while ((linha = br2.readLine()) != null) { // temos o while que percorre todas as linhas do nosso arquivo, ai quando chegar no final

			String[] splitlinha = linha.split(" "); // separa o remetente, destinatario e peso com espaços
			String remetente = splitlinha[0]; // defini o remetente como o index 0
			String destinatario = splitlinha[1]; // e defini o destinatario como index 1
			String peso = splitlinha[2];  // e defini o peso como index 2

			int indexRemetente = 0;
			int indexDestinatario = 0;

			for(int i = 0; i<g.vertices.length; i++){ // passa por toda a lista de verices
				if(g.vertices[i].info.equals(remetente)){ // pega o index do remetente no vertice
					indexRemetente = i;
					break;
				}
			}

			for(int i = 0; i<g.vertices.length; i++){ // repete o processo de cima, agora com o destinatario
				if(g.vertices[i].info.equals(destinatario)){
					indexDestinatario = i;
					break;
				}
			}

			g.criaAdj(indexRemetente, indexDestinatario, Double.parseDouble(peso)); // cria a adjacencia
			g.numeroAresta++; // conta o numero de arestas
		}

		br2.close(); // fecha o arquivo
		return g; //retorna o grafo
	}

	public int numeroVertices(){

		return tamanho; // nos retorna o numero de vertices
	}

	public int numeroArestas(){

		return numeroAresta; //retorna o numero de arestas
	}

	public void maiorGrauSaida(){ // as pessoas que mais enviaram emails
		int[] maiores = new int[20]; // 20 maiores valores de envio
		String[] nomes = new String[20]; // 20 nomes que mais aparecem

		for(int i = 0; i < 20; i++){ // iniciamos o vetor como 0
			maiores[i] = 0;
		}

		for(int i = 0; i < grafo.length; i++){ // percorre o grafo
			int soma = 0;
			ListaAdj l = grafo[i]; // cria uma lista adj l que armazena os index do grafo

			while(l != null){ // enquanto o L nao seja null
				soma += l.peso; // concatena todos os pesos na variavel soma
				l = l.proximo; // e pega o proximo elemento percorrendo a lista
			}

			if(soma > maiores[19]){ // verifica se o valor é maior que o ultimo elemento da lista
				maiores[19] = soma; // o elemento adicionado vira o ultimo elemento da lista
				nomes[19] = vertices[i].info; // pega o email da pessoa correspondente a soma
				int x = 18; // usamos no while
				int y = 19;
				while(x >= 0 && maiores[y] > maiores[x]){ // temos o while que ordena todos os numeros do maior para o menor dentro do vetor
					int z = maiores[x];
					String nomeAnterior = nomes[x];
					nomes[x] = nomes[y];
					nomes[y] = nomeAnterior;
					maiores[x] = maiores[y];
					maiores[y] = z;
					x--;
					y--;
				}
			}
		}

		for(int i = 0; i < 20; i++){ // printar bonitinho
			System.out.println(i+1+"°: "+nomes[i]+": "+maiores[i]);
		}
	}

	public void maiorEntrada(File file) throws Exception{ // as pessoas que mais receberam emails
		int[] maiores = new int[20]; // 20 maiores valores de recebimento
		String[] nomes = new String[20]; // 20 nomes que mais aparecem

		for(int i = 0; i < 20; i++){ // iniciamos o vetor como 0
			maiores[i] = 0;
		}

		String linha;

		for(int i = 0; i < vertices.length; i++){
			int soma = 0;
			BufferedReader br2 = new BufferedReader(new FileReader(file)); // abre o arquivo
			while ((linha = br2.readLine()) != null) { // temos o while que percorre todas as linhas do nosso arquivo, ai quando chegar no final
				String[] splitlinha = linha.split(" "); // separa o remetente, destinatario e peso com espaços
				String destinatario = splitlinha[1]; // definimos o dertinatario como index 1

				if(destinatario.equals(vertices[i].info)){
					soma += Integer.parseInt(splitlinha[2]);
				}
			}

			if(soma > maiores[19]){ // verifica se o valor é maior que o ultimo elemento da lista
				maiores[19] = soma; // aloca o novo elemento na ultima posição
				nomes[19] = vertices[i].info; // pega o email da pessoa correspondente a soma
				int x = 18;
				int y = 19;
				while(x >= 0 && maiores[y] > maiores[x]){ // temos o while que ordena todos os numeros do maior para o menor dentro do vetor
					int z = maiores[x];
					String nomeAnterior = nomes[x];
					nomes[x] = nomes[y];
					nomes[y] = nomeAnterior;
					maiores[x] = maiores[y];
					maiores[y] = z;
					x--;
					y--;
				}
			}
			br2.close(); // fechamos o arquivo
		}

		for(int i = 0; i < 20; i++){ // printamos bonitinho
			System.out.println(i+1+"°: "+nomes[i]+": "+maiores[i]);
		}
	}

	public int[] adjacentes(int i) {
		int[] adj = new int[tamanho]; // criamos uma lista adj com o peso do grafo

		for(int x = 0; x < tamanho; x++){ // percorre toda a lista
			adj[x] = -1; // adiciona o valor de -1 a todos os index
		}
		ListaAdj l = grafo[i]; // lista adj recebe o index do grafo
		int x = 0;
		while(l != null){ // enquanto o while for diferente de null
			adj[x] = l.destino; // alocamos o destino na lista adj
			l = l.proximo; // pegamos o proximo elemento
			x++; //concatenamos
		}
		return adj; //retornamos a lista adj
	}



	public void Dijkstra(String origem, String destino){
		int x = 0;
		int y = 0;
		boolean passouOrigem = false;
		boolean passouDestino = false;

		for(int i = 0; i < vertices.length; i++){ // basicamente vamos armazenar o index da origem e do destino
			if(passouDestino && passouOrigem){
				break;
			}
			if(vertices[i].info.equals(origem)){
				x = i;
				passouOrigem = true;
			}if(vertices[i].info.equals(destino)){
				y = i;
				passouDestino = true;
			}
		}

		ArrayList<Integer> caminho = new ArrayList<Integer>(); // vai armazenar o menor caminho
		double[] distancia = new double[tamanho]; // vai armazenar a menor distancia
		int[] pai = new int[tamanho]; // vai armazenar os pais do caminho
		boolean[] aberto = new boolean[tamanho]; // para saber se o caminho foi fechado ou esta aberto

		for(int i = 0; i < tamanho; i++){
			if(i == x){ // caso ele seja igual a origem
				distancia[i] = 0;
				pai[i] = -1; // nao vai ter pai
				aberto[i] = true;
			}else{
				distancia[i] = Integer.MAX_VALUE;
				pai[i] = -1;
				aberto[i] = true;
			}
		}

		while(true){ // enquanto true
			double menorDist = Integer.MAX_VALUE;
			int menorIndex = -1;
			for(int i = 0; i < tamanho; i++){ // vai pegar cada um dos valores e vai verificar o menor valor que ta aberto
				if(aberto[i] && distancia[i] < menorDist){
					menorDist = distancia[i]; // transformamos este elemento como o menor
					menorIndex = i;
				}
			}

			if(menorIndex == -1){// se ja verificamos todos os index
				break;
			}

			aberto[menorIndex] = false;  // fecha o caminho pois ja verificamos
			int[] adj = new int[tamanho];
			adj = adjacentes(menorIndex); // vai pegar a adjacencias desse valor

			for(int i : adj){
				if(i != -1 && distancia[menorIndex] + 1/peso(menorIndex, i) < distancia[i]){ // vai verificar se a distancia do caminho é menor que a distancia entre as adjacencias
					distancia[i] = distancia[menorIndex] + 1/peso(menorIndex, i);  // troca as distancias pela menor
					pai[i] = menorIndex;
				}else if(i == -1){
					break;
				}
			}
		}
		int p = y;
		while(p!=-1){ // enquanto o p for diferente de -1
			caminho.add(p); // adicionamos um pai ao caminho
			p = pai[p];
		}
		Collections.reverse(caminho); // invertemos a ordem
		System.out.println("menor distancia entre "+origem+" e "+destino+" é: "+distancia[y]);
		System.out.println("Caminho entre  "+origem+" e "+destino+" é:");
		for(int i = 0; i < caminho.size(); i++){
			System.out.println(vertices[caminho.get(i)].info);
		}
	}

	public void buscaProfundidade(int atual, int destino, ArrayList<Integer> caminho){
		if(!caminho.contains(atual)){ //se o atual nao consta no caminho
			caminho.add(atual); // adicionamos o atual no caminho
		}

		if(atual == destino){ // caso o atual seja igual ao destino (ordem de parada)
			System.out.println("Caminho: ");// print
			for(int i = 0; i < caminho.size(); i++){
				System.out.println(vertices[caminho.get(i)].info+" "); // printa todo o caminho ate chegar no destino
			}
		}

		int[] adj = adjacentes(atual); // cria uma lista adj
		for(int i : adj){ // percorre a lista adj que foi criada
			if(!caminho.contains(i)){ // seo i nao estiver no caminho
				if(i == -1){ // se o i for igual ao -1
					break; // paramos
				}
				buscaProfundidade(i, destino, caminho); // chamamos a função recursiva
				if(caminho.contains(destino)){ // verifica se o destino ja esta dentro do caminho
					break; // paramos
				}
			}
		}
	}

	public void buscarLargura(int atual, int destino, ArrayList<Integer> caminho){
		ArrayList<Integer> listaSaltos = new ArrayList<>(); //criamos um novo arraylist

		for(int i = 0; i < tamanho; i++){ // percorre a lista
			ArrayList<Integer> visitados = new ArrayList<>(); //criamos um novo arraylist
			saltos(atual, i, listaSaltos, visitados); // chama recursivamente o metodo saltos
			if(listaSaltos.contains(destino)){ // verifica se o destino ja esta na listaSaltos
				break; // paramos
			}
		}
		System.out.println(vertices[atual].info); // printa o vertice atual
		for(int i : listaSaltos){ // percorre a listaSaltos
			System.out.println(vertices[i].info); // printa o email do index
			if(i == destino){ // caso o i seja igual ao destino
				break; // paramos
			}
		}
	}

	public void saltos(int origem, int pulos, ArrayList<Integer> listaSaltos, ArrayList<Integer> visitados){  // pulos numero qualquer
		int[] adj = adjacentes(origem); // pegar as adjacentes da origem

		if(!visitados.contains(origem)){ // verifica se a origem ja foi adicionada nos visitados
			visitados.add(origem);
		}

		if(pulos == 1){  // criterio para adicionar um numero nos listas saltos
			for(int i : adj){ // passar pelas adjacencias da origem
				if(i == -1){ // verificar se acabaram as adjacentes
					break;
				}else if(!listaSaltos.contains(i) && !visitados.contains(i)){ // verifica se nao esta em nenhuma das litas para adicionar
					listaSaltos.add(i);
				}
			}
		}
		if(pulos > 1){
			for(int i : adj){ // passar pelas adjacencias da origem
				if(i == -1){ // verificar se acabaram as adjacentes
					break;
				}
				if(!visitados.contains(i)){  // caso ela nao foi vizitada
					saltos(i, pulos-1, listaSaltos,visitados); // chama recursivamente diminuindo 1 do pulo
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		Grafo g = new Grafo(0);
		File file = new File("dadosFinal.txt");
		g = g.criaGrafo(file);

		ArrayList<Integer> caminho = new ArrayList<>();
		g.buscarLargura(0, 5, caminho);

	}
}