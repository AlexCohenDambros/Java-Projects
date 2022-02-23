package Projeto1;

import java.util.Random;
import java.util.concurrent.Semaphore;
public class Transporte extends Thread{
    public String nomeTransportadora;
    public Semaphore sinal;

    public Transporte(String nomeTransportadora, Semaphore sinal){
        this.nomeTransportadora = nomeTransportadora;
        this.sinal = sinal;
    }

    public void run(){
        try{
            System.out.println("O produto será entregue pela empresa: "+nomeTransportadora);
            Random rand = new Random();
            switch (nomeTransportadora) {
                case "A":
                    Thread.sleep(rand.nextInt(1001)+1000);
                    break;
                case "B":
                    Thread.sleep(rand.nextInt(4001)+2000);
                    break;
            }
            sinal.release();
            System.out.println("O produto foi entregue pela empresa: "+nomeTransportadora);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}