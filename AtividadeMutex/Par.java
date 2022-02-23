package AtividadeMutex;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Par extends Thread {

    private int[ ] chave;
    private Semaphore mutex;

    public Par(int[ ] chave, Semaphore mutex) {
        this.chave = chave;
        this.mutex = mutex;
    }

    public void run() {
        try {
            Random r = new Random();
            Thread.sleep(r.nextInt(2001) + 1000);
            int[] pares = {0,2,4,6,8};

            while(Main.i < 100) {
                mutex.acquire(); // esperar
                Thread.sleep(r.nextInt(2001) + 1000);
                if(Main.i < 100) {
                    chave[Main.i] = pares[r.nextInt(5)];
                    Main.nPar += 1;
                    Main.i += 1;
                }
                mutex.release(); // sinalizar
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main.CHAVE = chave;
    }
}