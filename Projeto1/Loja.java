package Projeto1;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Loja extends Thread{
    public String nomeLoja;
    public int nSequencial = 0;
    public String[] produtos = {"A","B","C","D","E","F","G","H"};
    public int contadorVendas = 0;
    public FilaVenda filaVenda;
    public Semaphore mutexVenda;
    public Semaphore sVendas;
    public Semaphore limiteFilaVenda;

    public Loja(String nomeLoja, FilaVenda filaVenda, Semaphore mutexVenda, Semaphore sVendas, Semaphore limiteFilaVenda){
        this.nomeLoja = nomeLoja;
        this.filaVenda = filaVenda;
        this.mutexVenda = mutexVenda;
        this.sVendas = sVendas;
        this.limiteFilaVenda = limiteFilaVenda;
    }

    public void run(){
        try{
            Random rand = new Random();
            while(true){
                // ============== VENDA ==============
                Venda v = new Venda(nomeLoja + nSequencial, produtos[rand.nextInt(8)]);
                System.out.println("A loja "+nomeLoja+" vendeu o produto "+v.idVenda);

                limiteFilaVenda.acquire();
                mutexVenda.acquire();
                
                filaVenda.insere(v);
                
                mutexVenda.release();
                // ============== VENDA ==============
                contadorVendas++;
                sVendas.release();
                Thread.sleep(rand.nextInt(1401)+100);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
