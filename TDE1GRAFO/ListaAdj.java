package TDE1GRAFO;

public class ListaAdj { // lista encadeada
    public int destino;
    public double peso; // peso da aresta
    public ListaAdj proximo;

    public ListaAdj(int destino, double peso,ListaAdj proximo) {
        this.destino = destino; // todas os vertices que a origem pode se ligar
        this.peso = peso;
        this.proximo = proximo;
    }
}
