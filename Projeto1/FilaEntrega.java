package Projeto1;

public class FilaEntrega {
    private Entrega[] filaEntrega;
    private int primeiro;
    private int ultimo;
    private int MAX;
    private int tamanho;

    public FilaEntrega(int tamanho) {  
        this.filaEntrega = new Entrega[tamanho];
        this.primeiro = 0;
        this.ultimo = -1;
        this.MAX = tamanho;
        this.tamanho = 0;
    }
    
    public boolean cheia() {
        return (this.tamanho == this.MAX);
    }
    
    public boolean vazia() {
        return (tamanho == 0);
    }
    
    public Entrega insere(Entrega entrega) {
        if (cheia()) {
            return null;
        }
        if (ultimo == MAX - 1) {
            ultimo = 0;
            filaEntrega[ultimo] = entrega;
        }
        else {
            ultimo++;
            filaEntrega[ultimo] = entrega;
        }
        tamanho++;
        System.out.println("Adicionou na filaEntrega: "+entrega.produto);
        return entrega;
    }
    
    public Entrega remove() {
        Entrega entrega = primeiro();
        if (vazia()) {
            return null;
        }
        if (primeiro==ultimo){
            primeiro = 0;
            ultimo = -1;
            tamanho = 0;
        }
        else if (primeiro==MAX-1){
            primeiro = 0;
            tamanho--;
        }
        else {
            primeiro++;
            tamanho--;
        }
        System.out.println("Removeu na filaEntrega: " +entrega.produto);
        return entrega;
    }
    
    public Entrega primeiro(){
        if (!vazia()) {
            return filaEntrega[primeiro];
        }
        return null;
    }
    
    public Entrega ultimo(){
        return filaEntrega[ultimo];
    }
    
    public int getMAX() {
        return MAX;
    }
}
