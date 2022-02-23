package Sinalização;

import java.util.concurrent.Semaphore;

public class Gerador extends Thread{
    private Semaphore aleatorio;
    private Semaphore aleatorio_1;

    public Gerador(Semaphore aleatorio, Semaphore aleatorio_1) {
        this.aleatorio = aleatorio;
        this.aleatorio_1 = aleatorio_1;
    }

    public void run(){
        for(int x = 0; x < 10; x++) {
            try{
                String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxwyz";
                aleatorio_1.acquire();
                String novaString = "";
                for (int i = 0; i < 10; i++) {

                    int index = (int)(alfabeto.length() * Math.random());

                    novaString += alfabeto.charAt(index);
                }
                Main.aleatoria = novaString;
                aleatorio.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
