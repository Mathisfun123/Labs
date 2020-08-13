// Lab30st.java
// The Screen Saver Program
// Student Version
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Random;
import javax.swing.JOptionPane;
public class Lab30st
{
	public static void main(String args[])
	{
		String circleamt = JOptionPane.showInputDialog("Enter number of circles");
		String circleDiameter = JOptionPane.showInputDialog("Enter Diameter of Circles");
		GfxApp gfx = new GfxApp(Integer.parseInt(circleamt), Integer.parseInt(circleDiameter));
		gfx.setSize(800,600);
		gfx.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		gfx.show();
	}
}
class GfxApp extends Frame
{
	private int circleCount, circleSize;
	public GfxApp(int circleAmt1, int circleDia)
	{
		circleCount = circleAmt1;
		circleSize = circleDia;
	}
	class Coord
	{
		private int xPos;
		private int yPos;
		public Coord(int x, int y)
		{
			xPos = x;
			yPos = y;
		}
	}

	public void paint(Graphics g)
	{
		int incX = 5;
		int incY = 5;
		int diameter = circleSize;
		int timeDelay = 10;
		Queue1<Coord> q = new Queue1<>();
		Circle c = new Circle(g,diameter,incX,incY,timeDelay);
		for (int k = 1; k <= circleCount; k++)
		{
			q.add(new Coord(c.getTlX(),c.getTlY()));
			if(q.size()>=50){
				Coord lmoa = q.remove();
				c.eraseCircle(g,lmoa.xPos,lmoa.yPos);
			}
			c.drawCircle(g);
			c.hitEdge();
		}
	}
}


class Circle
{
	private int tlX; // top-left X coordinate
	private int tlY; // top-left Y coordinate
	private int incX; // increment movement of X coordinate
	private int incY; // increment movement of Y coordinate
	private boolean addX; // flag to determine add/subtract of increment for X
	private boolean addY; // flag to determine add/subtract of increment for Y
	private int size; // diameter of the circle
	private int timeDelay; // time delay until next circle is drawn

	public Circle(Graphics g, int s, int x, int y, int td)
	{
		incX = x;
		incY = y;
		size = s;
		addX = true;
		addY = false;
		tlX = 400;
		tlY = 300;
		timeDelay = td;
	}

	public void delay(int n)
	{
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < n)
		endDelay = System.currentTimeMillis();
	}
	public void drawCircle(Graphics g)
	{

			Color color;
			Random random = new Random();
			 float hue = random.nextFloat();
			float saturation = 1.0f;
			float luminance = 1.0f;
			color = Color.getHSBColor(hue, saturation, luminance);
			g.setColor(color);

		g.drawOval(tlX,tlY,size,size);
		delay(timeDelay);
		if (addX)
			tlX+=incX;
		else
			tlX-=incX;
		if (addY)
			tlY+=incY;
		else
			tlY-=incY;
	}


	public void newData()
	{
		incX = (int) Math.round(Math.random() * 7 + 5);
		incY = (int) Math.round(Math.random() * 7 + 5);
	}
	public void hitEdge()
	{
		boolean flag = false;
		if (tlX < incX)
		{
			addX = true;
			flag = true;
		}
		if (tlX > 800 - (30 + incX))
		{
			addX = false;
			flag = true;
		}
		if (tlY < incY + 30) // The +30 is due to the fact that the title bar covers the top 30 pixels of the window
		{
			addY = true;
			flag = true;
		}
		if (tlY > 600 - (30 + incY))
		{
			addY = false;
			flag = true;
		}
		if (flag)
			newData();
	}
	public void eraseCircle(Graphics g,int topx, int topy){
		g.setColor(Color.WHITE);
		int midx = (int)(topx + (size)*Math.sqrt(2));
		int midy = (int)(topy - (size)*Math.sqrt(2));
		g.drawOval(topx,topy,size,size);

	}
	public int getTlX(){return tlX;}
	public int getTlY() {return tlY;};

}