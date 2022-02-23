package Sinalização;

import java.util.concurrent.Semaphore;

public class Contador extends Thread{
    private Semaphore padronizado;
    private Semaphore padronizado_1;

    public Contador(Semaphore padronizado, Semaphore padronizado_1) {
        this.padronizado = padronizado;
        this.padronizado_1 = padronizado_1;
    }

    public void run() {
        for(int z = 0; z < 10; z++) {
            try {
                String vogais = "AEIOU";
                padronizado.acquire();
                String padronizada = Main.padronizada;
                int n_vogais = 0;
                for(int i = 0; i < padronizada.length(); i++) {
                    for(int x = 0; x < vogais.length();x ++) {
                        if(padronizada.charAt(i) == vogais.charAt(x)) {
                            n_vogais++;
                        }
                    }
                }
                System.out.println("O número de vogais da palavra "+padronizada+" é: "+n_vogais);
                padronizado_1.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
