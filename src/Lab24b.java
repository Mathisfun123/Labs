// Lab24bst.java
// This is the student version of the lab24b assignment.


import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Lab24b {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter <numCircles initial x initial y increment> bounds [0, 10000] and [5,40] ==>");
        int x = 5, y = 5, num = 1000;
        try{
        	String s[] = sc.nextLine().split(" ");
        	x = Integer.parseInt(s[1]);
        	y = Integer.parseInt(s[2]);
        	num = Integer.parseInt(s[0]);
        	if(x < 5 || y < 5 || x > 40 || y > 40) throw new Exception();
		} catch (Exception e) {
        	System.err.println("Invalid params. Out of bounds [0,10000]/[5, 40] or not Integers");
        	System.out.println("Using default increments..");
		}
        Gfx gfx = new Gfx(num, x, y);
        gfx.setSize(900,700);
        gfx.addWindowListener(new WindowAdapter() {public void
        windowClosing(WindowEvent e) {System.exit(0);}});
        gfx.show();
    }
}

class Gfx extends Frame {
	Circle1 c;
	public Gfx(int numCircles, int xInc, int yInc) {
		c = new Circle1(30, xInc, yInc, 20, numCircles);
	}
    public void paint(Graphics g) {
		c.start(g);
    }

}

//screen size = 1280, 720
class Circle1 {
    int size , incX,  incY, timeDelay, tlX, tlY, numCircles;

    public Circle1(int size, int incX, int incY, int timeDelay, int numCircles) {
        this.size = size;
        this.incX = incX;
        this.incY = incY;
        this.tlX = (900/2);
        this.tlY = (700/2);
        this.timeDelay = timeDelay;
        this.numCircles = numCircles;
    }

	public void start(Graphics g) {
		while(numCircles > 0) {
			if(tlX/*+ size*/ > 860) {
				tlX = 860/*-size*/;
				int degree = new Random().nextInt(180)+90;
				incX = (int)(Math.cos(degree)*20);
				incY = (int)(Math.sin(new Random().nextInt(360))*20);
				settlY();
				settlX();
			} else if(tlX < 40) {
				tlX = 40;
				int degree = (new Random().nextInt(180)+270) % 360;
				incX = (int)(Math.cos(degree)*20);
				incY = (int)(Math.sin(new Random().nextInt(360))*20);
				settlY();
				settlX();
			} else if(tlY > 660) {
				tlY = 660;
				int degree = (new Random().nextInt(180));
				incY = (int)(Math.sin(degree)*20);
				incX = (int)(Math.cos(new Random().nextInt(360))*20);
				System.out.println(tlX + " " +tlY+" "+ incX + " " + incY);
				settlX();
				settlY();
			} else if(tlY < 40) {
				tlY = 40;
				int degree = (new Random().nextInt(180)+180)%360;
				incY = (int)(Math.sin(degree)*20);
				incX = (int)(Math.cos(new Random().nextInt(360))*20);
				settlX();
				settlY();
			} else {
				settlX();
				settlY();
				drawCircle(g);
				numCircles--;
				System.out.println(numCircles);
				delay(timeDelay);
			}
		}
	}


	public void delay(double n) {
		for(double x = 0.0; x < 10000; x+=0.001);
    }
    public void drawCircle(Graphics g){
    	g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
        g.drawOval(tlX,tlY,size,size);

    }
    public void settlX() {
        tlX += incX;
    }
    public void settlY() {
        tlY += incY;
    }
}