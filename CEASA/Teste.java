package CEASA;
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BufferLimitado lista = new BufferLimitado( 10 );

		FornecedorBananas p1 = new FornecedorBananas ( lista );
		FornecedorMacas p2 = new FornecedorMacas ( lista );

		CompradorBananas c1 = new CompradorBananas ( lista );
		CompradorMacas c2 = new CompradorMacas ( lista );

		p1.start();
		p2.start();
		c1.start();
		c2.start();


	}

}
