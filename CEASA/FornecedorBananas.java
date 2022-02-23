package CEASA;

import java.util.Random;

public class FornecedorBananas extends Thread {
    private BufferLimitado buffer;
    private Random aleatorio;

    public FornecedorBananas(BufferLimitado buffer)
    {
        this.buffer = buffer;
        aleatorio = new Random();
    }

    public void run()
    {
        while (true)
        {
            try {
                int dado = aleatorio.nextInt(1000);
                buffer.depositar1( dado );
                int tempo = aleatorio.nextInt(500);
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
