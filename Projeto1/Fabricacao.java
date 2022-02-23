package Projeto1;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Fabricacao extends Thread{
    public String nomeFabricante;
    public String produto;
    public Semaphore sinal;
    public String idVenda;
    public FilaEntrega filaEntrega;
    public Semaphore limiteFilaEntrega;
    public Semaphore mutexEntrega;
    public Semaphore sEntregas;

    public Fabricacao(String nomeFabricante, Venda v, Semaphore sinal, FilaEntrega filaEntrega, 
    Semaphore mutexEntrega, Semaphore limiteFilaEntrega, Semaphore sEntregas){

        this.nomeFabricante = nomeFabricante;
        this.produto = v.produto;
        this.idVenda = v.idVenda;
        this.sinal = sinal;
        this.filaEntrega = filaEntrega;
        this.limiteFilaEntrega = limiteFilaEntrega;
        this.mutexEntrega = mutexEntrega;
        this.sEntregas = sEntregas;
    }

    public void run(){
        try{
            System.out.println("O produto "+idVenda+" entrou na fabrica "+nomeFabricante);
            switch (nomeFabricante) { 
                case "A":
                    fabA(produto);
                    break;
                case "B":
                    fabA(produto);
                    break;
                case "C":
                    fabA(produto);
                    break;
                case "D":
                    fabA(produto);
                    break;
            }

            // ============== Adicionando nova entrega ==============
            Entrega e = new Entrega(idVenda,produto);
                
            limiteFilaEntrega.acquire();
            mutexEntrega.acquire();

            filaEntrega.insere(e);

            mutexEntrega.release();
            // ============== Adicionando nova entrega ==============
            sEntregas.release();
            sinal.release();
            
            System.out.println("O produto "+idVenda+" saiu na fabrica "+nomeFabricante);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void fabA(String produto) throws InterruptedException{
    	Random r = new Random();
    	switch(produto){
            case "A":
                Thread.sleep(r.nextInt(4001)+6000);
                break;
            case "B":
                Thread.sleep(r.nextInt(2001)+2000);
                break;
            case "C":
                Thread.sleep(r.nextInt(2001)+10000);
                break;
            case "D":
                Thread.sleep(r.nextInt(2001)+4000);
                break;
            case "E":
                Thread.sleep(r.nextInt(2001)+8000);
                break;
            case "F":
                Thread.sleep(r.nextInt(2001)+14000);
                break;
            case "G":
                Thread.sleep(r.nextInt(2001)+4000);
                break;
            case "H":
                Thread.sleep(r.nextInt(2001)+8000);
                break;
    	}
    }
    public void fabB(String produto) throws InterruptedException{
    	Random r = new Random();
    	switch(produto){
            case "A":
                Thread.sleep(r.nextInt(2001)+4000);
                break;
            case "B":
                Thread.sleep(r.nextInt(2001)+8000);
                break;
            case "C":
                Thread.sleep(r.nextInt(2001)+12000);
                break;
            case "D":
                Thread.sleep(r.nextInt(2001)+8000);
                break;
            case "E":
                Thread.sleep(r.nextInt(2001)+2000);
                break;
            case "F":
                Thread.sleep(r.nextInt(2001)+10000);
                break;
            case "G":
                Thread.sleep(r.nextInt(2001)+10000);
                break;
            case "H":
                Thread.sleep(r.nextInt(2001)+6000);
                break;
    	}
    }
    public void fabC(String produto) throws InterruptedException{
    	Random r = new Random();
    	switch(produto){
            case "A":
                Thread.sleep(r.nextInt(2001)+10000);
                break;
            case "B":
                Thread.sleep(r.nextInt(2001)+12000);
                break;
            case "C":
                Thread.sleep(r.nextInt(2001)+4000);
                break;
            case "D":
                Thread.sleep(r.nextInt(2001)+6000);
                break;
            case "E":
                Thread.sleep(r.nextInt(2001)+4000);
                break;
            case "F":
                Thread.sleep(r.nextInt(2001)+4000);
                break;
            case "G":
                Thread.sleep(r.nextInt(2001)+10000);
                break;
            case "H":
                Thread.sleep(r.nextInt(2001)+4000);
                break;
    	}
    }
    public void fabD(String produto) throws InterruptedException{
    	Random r = new Random();
    	switch(produto){
            case "A":
                Thread.sleep(r.nextInt(2001)+8000);
                break;
            case "B":
                Thread.sleep(r.nextInt(2001)+6000);
                break;
            case "C":
                Thread.sleep(r.nextInt(2001)+4000);
                break;
            case "D":
                Thread.sleep(r.nextInt(2001)+10000);
                break;
            case "E":
                Thread.sleep(r.nextInt(2001)+12000);
                break;
            case "F":
                Thread.sleep(r.nextInt(2001)+8000);
                break;
            case "G":
                Thread.sleep(r.nextInt(2001)+6000);
                break;
            case "H":
                Thread.sleep(r.nextInt(2001)+12000);
                break;
    	}
    }
}
