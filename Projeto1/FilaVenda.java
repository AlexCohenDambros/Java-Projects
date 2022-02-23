package Projeto1;

public class FilaVenda {
    private Venda[] filaVenda;
    private int primeiro;
    private int ultimo;
    private int MAX;
    private int tamanho;

    public FilaVenda(int tamanho) {  
        this.filaVenda = new Venda[tamanho];
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
    
    public Venda insere(Venda venda) {
        if (cheia()) {
            return null;
        }
        if (ultimo == MAX - 1) {
            ultimo = 0;
            filaVenda[ultimo] = venda;
        }
        else {
            ultimo++;
            filaVenda[ultimo] = venda;
        }
        tamanho++;
        System.out.println("Adicionou na filaVenda: "+venda.produto);
        return venda;
    }
    
    public Venda remove() {
        Venda venda = primeiro();
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
        System.out.println("Removeu na filaVenda: " +venda.produto);
        return venda;
    }
    
    public Venda primeiro(){
        if (!vazia()) {
            return filaVenda[primeiro];
        }
        return null;
    }
    
    public Venda ultimo(){
        return filaVenda[ultimo];
    }
    
    public int getMAX() {
        return MAX;
    }
}