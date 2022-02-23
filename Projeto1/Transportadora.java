package Projeto1;

import java.util.concurrent.Semaphore;

public class Transportadora extends Thread{
    public String nomeTransportadora;
    public FilaEntrega filaEntrega;
    public Semaphore mutexEntrega;
    public Semaphore sEntregas;
    public Semaphore limiteFilaEntrega;
    public Semaphore sinal;

    public Transportadora(String nomeTransportadora, FilaEntrega filaEntrega, 
    Semaphore mutexEntrega, Semaphore sEntregas, Semaphore limiteFilaEntrega, int limiteEntregas){
        this.nomeTransportadora = nomeTransportadora;
        this.filaEntrega = filaEntrega;
        this.mutexEntrega = mutexEntrega;
        this.sEntregas = sEntregas;
        this.limiteFilaEntrega = limiteFilaEntrega;
        this.sinal = new Semaphore(limiteEntregas);
    }

    public void run(){
        try{
            while(true){
                sEntregas.acquire();
                // ============== ENTREGA ==============
                mutexEntrega.acquire();

                filaEntrega.remove();
                limiteFilaEntrega.release();

                mutexEntrega.release();
                // ============== ENTREGA ==============
                sinal.acquire();
                Transporte t = new Transporte(nomeTransportadora,sinal);
                t.start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
