package CEASA;

import java.util.Random;

public class FornecedorMacas extends Thread {
    private BufferLimitado buffer;
    private Random aleatorio;

    public FornecedorMacas(BufferLimitado buffer)
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
                buffer.depositar2( dado );
                int tempo = aleatorio.nextInt(500);
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
