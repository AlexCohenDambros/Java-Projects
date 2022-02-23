package CEASA;

public class BufferLimitado {
	
	private int N;
	private int buffer[];
	private int buffer2[];
	private int front = 0;
	private int rear = 0;
	private int count = 0;
	private int front2 = 0;
	private int rear2 = 0;
	private int count2 = 0;


		
	public BufferLimitado(int N)
	{
		this.N = N;
		buffer = new int[N];
		buffer2 = new int[N];
	}
	
	public synchronized void depositar1(int dado) throws InterruptedException
	{
		while ( count == N ) wait();
		buffer[rear] = dado;
		rear = (rear + 1) % N;
		count++;
		System.out.println( "Produzido(Banana): " + dado + "[" + count + "]" );
		notifyAll();
	}
	
	public synchronized int retirar1() throws InterruptedException
	{
		while ( count == 0 ) wait();
		int dado = buffer[front];
		front = (front + 1) % N;
		count--;
		System.out.println( "Consumido(Banana): " + dado + "[" + count + "]" );
		notifyAll();
		return dado;
	}

	public synchronized void depositar2(int dado) throws InterruptedException
	{
		while ( count2 == N ) wait();
		buffer2[rear2] = dado;
		rear2 = (rear2 + 1) % N;
		count2++;
		System.out.println( "Produzido(Maça): " + dado + "[" + count2 + "]" );
		notifyAll();
	}

	public synchronized int retirar2() throws InterruptedException
	{
		while ( count2 == 0 ) wait();
		int dado = buffer2[front2];
		front2 = (front2 + 1) % N;
		count2--;
		System.out.println( "Consumido(Maça): " + dado + "[" + count2 + "]" );
		notifyAll();
		return dado;
	}
}
