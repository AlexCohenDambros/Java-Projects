package CEASA;

import java.util.Random;

public class CompradorBananas extends Thread {
    private BufferLimitado buffer;
    private Random aleatorio;

    public CompradorBananas(BufferLimitado buffer)
    {
        this.buffer = buffer;
        aleatorio = new Random();
    }

    public void run()
    {
        while (true)
        {
            try {
                buffer.retirar1();
                int tempo = aleatorio.nextInt(2000);
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}