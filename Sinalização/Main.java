package Sinalização;

import java.util.concurrent.Semaphore;

public class Main {
    public static String aleatoria = "";
    public static String padronizada = "";

    public static void main(String[] args) {

        Semaphore aleatorio = new Semaphore(0);
        Semaphore aleatorio_1 = new Semaphore(1);
        Semaphore padronizado = new Semaphore(0);
        Semaphore padronizado_1 = new Semaphore(1);

        Gerador g = new Gerador(aleatorio,aleatorio_1);
        Padronizador p = new Padronizador(aleatorio,aleatorio_1,padronizado,padronizado_1);
        Contador c = new Contador(padronizado,padronizado_1);

        g.start();
        p.start();
        c.start();
    }
}
