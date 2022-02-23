package TDE2GRAFO;

// achar um caminho possivel -> ai retorna true

public class Grafo {
    private double[][] matriz;
    private int tamanho;
    private Vertice[] vertices;
    private Boolean[][] matrizFechamento;

    public Grafo(int tamanho) { // construtor
        this.tamanho = tamanho;
        this.matriz = new double[tamanho][tamanho];
        this.vertices = new Vertice[tamanho];
        this.matrizFechamento = new Boolean[tamanho][tamanho];

        for(int i = 0; i < tamanho; i++) { // preenche a listas com os vertices
            vertices[i] = new Vertice();
            for(int x = 0; x < tamanho; x++) { // preenche a listas com os MAX_VALUE
                matriz[i][x] = Integer.MAX_VALUE;
                matrizFechamento[i][x] = false; // deixamos eles false
            }
        }
    }

    public void criaAdj(int origem, int destino, double custo) {
        matriz[origem][destino] = custo;
    }

    public void removeAdj(int origem, int destino) {
        matriz[origem][destino] = Integer.MAX_VALUE;
    }

    public void imprimeAdj() {
        // utilizamos pra imprimir as listas adjacentes
        for(int i = 0; i < tamanho; i++) {
            if (i == tamanho - 1) {
                System.out.println(i + 1);
                break;
            } else if (i == 0) {
                System.out.print("  ");
            }
            System.out.print(i + 1 + "|");
        }

        for(int i = 0; i < tamanho; i++) {
            for(int x = 0; x < tamanho; x++) {
                if(x == 0) {
                    System.out.print(i+1 + " ");
                }else if(x == tamanho - 1) {
                    System.out.print(matriz[i][x]);
                    break;
                }
                System.out.print(matriz[i][x] + "|");
            }
            System.out.println("");
        }
    }

    public void setaInfo(int i, String info) {
        vertices[i].info = info;
    }

    public int adjacentes(int i, int[] adj) {
        int n_adj = 0; // instanciamos as variaveis
        int y = 0;
        for(int x = 0; x < tamanho; x++) {
            if(matriz[i][x] != Integer.MAX_VALUE) { //se os elementos forem diferente de false
                n_adj++; //incrementa +1 na variavel
                adj[y] = y;
                y++; //incrementa +1 na variavel
            }
        }
        return n_adj; // retorna as adjacentes
    }

    public double peso(int i, int j) {
        return matriz[i][j];
    }

    public void fechamento(Boolean[][] matrizFechamento2){
        int i, j, k;

        // inicialização da matriz de fechamento
        for (i = 0; i < tamanho; i++ ){// percorremos as matrizes
            for(j = 0; j < tamanho; j++){
                if(matriz[i][j] != Integer.MAX_VALUE){// verificamos os elementos que são diferentes de false
                    matrizFechamento2[i][j] = true; // deixamos eles true
                }
            }
        }

        // algoritmo de Warshall
        for(k = 0; k < tamanho; k++){// percorremos as matrizes
            for(i = 0; i < tamanho; i++){
                if (matrizFechamento2[i][k])// verificar se esta true
                    for(j = 0; j < tamanho; j++){// verifica os caminhos, compara eles, mantem os true e caso tenha um T e um F, ele troca o falso para true
                        matrizFechamento2[i][j] = matrizFechamento2[i][j]  ||  matrizFechamento2[k][j]; // verificar se alguns deles está true
                    }
            }
        }
        // imprime os caminhos com T e F
        for(int x = 0; x < tamanho; x++){
            System.out.println("");
            for(int y = 0; y < tamanho; y++){
                System.out.print(" "+matrizFechamento2[x][y]);
            }
        }
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(3);

        // destino 0 da false pois nao existe adjacencia com o destino 0
        g.criaAdj(0, 1, 300);

        g.criaAdj(1, 2, 400);

        g.criaAdj(2, 1, 300);
        g.criaAdj(2, 2, 400);

        g.fechamento(g.matrizFechamento); // retornamos a matriz completa
    }
}