package Sinalização;

import java.util.concurrent.Semaphore;

public class Padronizador extends Thread{
    private Semaphore aleatorio;
    private Semaphore padronizado;
    private Semaphore aleatorio_1;
    private Semaphore padronizado_1;

    public Padronizador(Semaphore aleatorio, Semaphore aleatorio_1, Semaphore padronizado, Semaphore padronizado_1) {
        this.aleatorio = aleatorio;
        this.padronizado = padronizado;
        this.aleatorio_1 = aleatorio_1;
        this.padronizado_1 = padronizado_1;
    }

    public void run() {
        for(int x = 0; x < 10; x++) {
            String padronizada;

            try {
                aleatorio.acquire();
                padronizado_1.acquire();
                String aleatoria = Main.aleatoria;
                padronizada = aleatoria.toUpperCase();
                Main.padronizada = padronizada;
                aleatorio_1.release();
                padronizado.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}