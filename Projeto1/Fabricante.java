package Projeto1;

import java.util.concurrent.Semaphore;


public class Fabricante extends Thread{
    public String nomeFabricante;
    public FilaVenda filaVenda;
    public Semaphore mutexVenda;  
    public Semaphore sVendas;  
    public Semaphore limiteFilaVenda;
    public FilaEntrega filaEntrega;
    public Semaphore mutexEntrega;
    public Semaphore sEntregas;
    public Semaphore limiteFilaEntrega;
    public Semaphore sinal;
    public int limiteFabrica;

    public Fabricante(String nomeFabricante, FilaVenda filaVenda, Semaphore mutexVenda, 
    Semaphore sVendas, Semaphore limiteFilaVenda, FilaEntrega filaEntrega, 
    Semaphore mutexEntrega, Semaphore sEntregas, Semaphore limiteFilaEntrega, int limiteFabrica){

        this.nomeFabricante = nomeFabricante;
        this.filaVenda = filaVenda;
        this.mutexVenda = mutexVenda;
        this.sVendas = sVendas;
        this.limiteFilaVenda = limiteFilaVenda;
        this.filaEntrega = filaEntrega;
        this.mutexEntrega = mutexEntrega;
        this.sEntregas = sEntregas;
        this.limiteFilaEntrega = limiteFilaEntrega;
        this.limiteFabrica = limiteFabrica;
        this.sinal = new Semaphore(limiteFabrica);
    }

    public void run(){
        try{
            while(true){
                sVendas.acquire();
                // ============== VENDA ==============
                mutexVenda.acquire();

                Venda v = filaVenda.remove();
                limiteFilaVenda.release();

                mutexVenda.release();
                // ============== VENDA ==============

                // ============== FABRICAÇÃO ==============
                sinal.acquire();
                Fabricacao f = new Fabricacao(nomeFabricante,v,sinal,filaEntrega,mutexEntrega,limiteFilaEntrega,sEntregas);
                f.start();
                // ============== FABRICAÇÃO ==============
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
