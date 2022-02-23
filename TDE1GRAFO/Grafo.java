package TDE1GRAFO;

public class Grafo {
    //instancia os atributos
    private ListaAdj[] grafo; // armazenar os destinos (as lista encadeadas)
    private int tamanho; // numero de vertices
    private Vertice[] vertices; // guardar a informação do vertice

    public Grafo(int tamanho) {
        this.tamanho = tamanho; // quantidade de vertices
        this.grafo = new ListaAdj[tamanho];
        this.vertices = new Vertice[tamanho];

        for(int i = 0; i < tamanho; i++) { // vai iniciar as duas litas
            vertices[i] = new Vertice();
            grafo[i] = null; // e instanciando a lista encadeada Lista ADJ
        }
    }

    public void criaAdj(int origem, int destino, double custo) { // custo peso da aresta
        if(grafo[origem] == null) { // caso a origem passada nao tenha ainda sido criada
            grafo[origem] = new ListaAdj(destino,custo,null); //  cria uma aresta da origem com o destino
        }else {
            ListaAdj x = grafo[origem]; // pecorre os destinos atraves do .proximo de x até achar um valor nulo para adicionar um novo destino a origem
            while(x.proximo != null) { // ate achar um lugar vazio
                x = x.proximo;
            }
            x.proximo = new ListaAdj(destino,custo,null);
        }
    }

    public void removeAdj(int origem, int destino) {
        // se a origem for nula nao tem o que remover
        if(grafo[origem] != null) {
            ListaAdj x = grafo[origem];
            ListaAdj y = null; // guardar o anterior
            while(x.destino != destino) { // vai percorrer a lista encadeada de destino até achar o destino correto
                y = x; // e armazenar o anterior de x
                x = x.proximo;
            }
            if(y == null){
                grafo[origem] = x.proximo; // caso ele queira retirar o primeiro destino do vertice da lista encadeada
            }
            else{ // o proximo anterior de x que é o y vai receber o proximo de x, eliminando o x
                y.proximo = x.proximo;
            }
        }
    }

    public void imprimeAdj() {
        for(int i = 0; i < tamanho; i++) { // horizontal
            if(i == tamanho - 1) {
                System.out.println(i);
                break;
            }else if(i == 0) {
                System.out.print("  ");
            }
            System.out.print(i + " ");
        }


        for(int i = 0; i < tamanho; i++) { // vertical
            System.out.print(i + " ");
            for(int y = 0; y < tamanho; y++) {
                ListaAdj x = grafo[i];
                if(x == null) {
                    System.out.print("0 ");
                    continue;
                }
                while(x != null) {
                    if(x.destino == y) {
                        System.out.print("1 ");
                        break;
                    }
                    x = x.proximo;
                }
                if(x == null) {
                    System.out.print("0 ");
                    continue;
                }
            }
            System.out.println("");
        }
    }

    public void setaInfo(int i, String info) {
        vertices[i].info = info;
    }

    // contador de adjacentes, passando uma lista vazia e armzazendo os destinos da origem
    public int adjacentes(int i, int[] adj) { // i = origem  adj é uma nova lista para guardar as adejacentes
        int n_adj = 0;
        int y = 0;
        ListaAdj x = grafo[i];
        while(x != null) {
            adj[y] = x.destino;
            n_adj++;
            x = x.proximo;
            y++;
        }
        return n_adj;
    }

    public double peso(int i, int j) { // passamos a origem e o destino
        if(grafo[i] != null) {
            ListaAdj x = grafo[i];
            while(x.destino != j) {  // vai percorrer a lista encadeada de destino até achar o destino correto
                x = x.proximo;
            }
            return x.peso;
        }
        return 0;
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(3);
        g.criaAdj(0, 1, 300);
        g.criaAdj(0, 0, 30);
        g.criaAdj(0, 2, 400);
        g.imprimeAdj();
        System.out.println(g.peso(0, 2));
    }
}