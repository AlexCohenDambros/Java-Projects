package AtividadeMutex;

import java.util.concurrent.Semaphore;

import java.util.concurrent.Semaphore;

public class Main {
    public static int i;
    public static int[] CHAVE = new int[100];
    public static int nPar;
    public static int nImpar;

    public static void main(String[] args) {

        int[] CHAVE = new int[100];
        nPar = 0;
        nImpar = 0;

        Semaphore mutex = new Semaphore(2);
        i = 0;

        Par p = new Par(CHAVE, mutex);
        Impar ip = new Impar(CHAVE, mutex);
        Par p2 = new Par(CHAVE, mutex);
        Impar ip2 = new Impar(CHAVE, mutex);

        p.start();
        ip.start();
        p2.start();
        ip2.start();

        try {
            p.join();
            ip.join();
            p2.join();
            ip2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("[");
        for (int i = 0; i < 100; i++) {
            if (i != 99) {
                System.out.print(CHAVE[i] + ",");
            } else {
                System.out.print(CHAVE[i]);
            }
        }
        System.out.println("]");
        System.out.println("Número de pares: " + nPar);
        System.out.println("Número de impares: " + nImpar);
    }
}
