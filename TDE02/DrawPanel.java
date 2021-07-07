
//figura 8.22
package TDE02;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;



public class DrawPanel extends JPanel{
	private Random randomNumbers = new Random();
	private MyRectangle[] lines;
	private MyOval[] lines2;
	private MyLine[] lines3;
	
	
	
	public DrawPanel()
	{
		
		setBackground( Color.WHITE );
		//+ randomNumbers.nextInt( 3 ) 
		lines = new MyRectangle[ 4 ];
		lines2 = new MyOval[ 4 ];
		lines3 = new MyLine[ 4 ];
		
		for ( int count = 0; count < lines.length; count ++ )
		{
			int x1 = randomNumbers.nextInt(200);
			int y1 = randomNumbers.nextInt(200);
			int x2 = randomNumbers.nextInt(400) + 100;
			int y2 = randomNumbers.nextInt(400) + 100;
			
			Color color = new Color( randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ));
			
			lines[ count ] = new MyRectangle( x1, y1, x2, y2, color, true);
			
			int x1_2 = randomNumbers.nextInt(200) + 100;
			int y1_2 = randomNumbers.nextInt(200) + 100;
			int x2_2 = randomNumbers.nextInt(500) + 50;
			int y2_2 = randomNumbers.nextInt(500) + 50;
			Color color2 = new Color( randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ));
			lines2[ count ] = new MyOval( x1_2, y1_2, x2_2, y2_2, color2, false);
			
			int x1_3 = randomNumbers.nextInt(200);
			int y1_3 = randomNumbers.nextInt(200);
			int x2_3 = randomNumbers.nextInt(400) + 100;
			int y2_3 = randomNumbers.nextInt(400) + 100;
			Color color3 = new Color( randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ));
			lines3[ count ] = new MyLine(x1_3, y1_3, x2_3, y2_3, color3);
		}
		
	}
	public String status()
	{
		String texto = "Linhas: "  + lines3.length +   "; Retangulos = " + lines.length + "; Ovais = " + lines2.length;
		return texto;
	}
	
	

	
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g );
		for ( MyRectangle line : lines )
		{
			line.draw( g );
		}
		for (MyOval oval : lines2)
		{
			oval.draw(g);
		}
		for (MyLine lines : lines3)
		{
			lines.draw(g);
		}
	}
	
}
