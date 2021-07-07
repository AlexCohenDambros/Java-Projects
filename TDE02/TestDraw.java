package TDE02;
import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class TestDraw {
	public static void main(String[] args) 
	{
		Random randomNumbers = new Random();
		DrawPanel panel = new DrawPanel();
	    JFrame app = new JFrame();
	    JLabel sul = new JLabel(panel.status());
	    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    app.add(panel);
	    app.add(sul, BorderLayout.SOUTH);
	    app.setSize(600, 600);
	    app.setVisible(true);
	}
	//fim da classe TestDraw
}
