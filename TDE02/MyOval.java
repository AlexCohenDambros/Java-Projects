package TDE02;

import java.awt.Color;
import java.awt.Graphics;


public class MyOval {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color myColor;
	private boolean flag;
	
	
	public MyOval(int x1, int y1, int x2, int y2, Color myColor, boolean flag) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.myColor = myColor;
		this.flag = flag;
		
	}

	public int getUpperLeftX()
	{
		return this.x1;
	}
	public int getUpperLeftY()
	{
		return this.y1;
	}
	public int getWidth()
	{
		return this.x2-this.x1;
	}
	public int getHeight()
	{
		return this.y2-this.y1;
	}
	public void draw( Graphics g )
	{
		g.setColor(myColor);
		g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		if (flag)
		{
			g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		}
	
}
	
	
	
	
	
	
}
