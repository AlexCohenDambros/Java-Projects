package Grafos;

public class Grafo {
    private int[][] matriz;
    private int tamanho;
    private Vertice[] vertices;

    public Grafo(int tamanho) {
        this.tamanho = tamanho;
        this.matriz = new int[tamanho][tamanho];
        this.vertices = new Vertice[tamanho];

        for(int i = 0; i < tamanho; i++) {
            vertices[i] = new Vertice();
            for(int x = 0; x < tamanho; x++) {
                matriz[i][x] = Integer.MAX_VALUE;
            }
        }
    }

    public void criaAdj(int origem, int destino, int custo) {
        matriz[origem][destino] = custo;
    }

    public void removeAdj(int origem, int destino) {
        matriz[origem][destino] = Integer.MAX_VALUE;
    }

    public void imprimeAdj() {
        for(int i = 0; i < tamanho; i++) {
            if(i == tamanho - 1) {
                System.out.println(i+1);
                break;
            }else if(i == 0) {
                System.out.print("  ");
            }
            System.out.print(i+1 + "|");
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
        int n_adj = 0;
        int y = 0;
        for(int x = 0; x < tamanho; x++) {
            if(matriz[i][x] != Integer.MAX_VALUE) {
                n_adj++;
                adj[y] = y;
                y++;
            }
        }
        return n_adj;
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(3);
        g.criaAdj(0, 1, 300);
        g.criaAdj(0, 0, 30);
        g.criaAdj(0, 2, 400);

        int[] adj = new int[g.tamanho];
        g.adjacentes(0, adj);
        for(int i = 0; i < g.tamanho; i++) {
            System.out.println(adj[i]);
        }
        g.imprimeAdj();

    }
}