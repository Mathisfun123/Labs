import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Lab24ast {

	public static void main(String args[]) {
		GfxApp1 gfx = new GfxApp1();
		gfx.setSize(1500,900);
		gfx.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		gfx.show();

	}
}
class GfxApp1 extends Frame {
	public void paint(Graphics g) {
		Scanner sc = new Scanner(System.in);
		int checker = -1;
		if (checker == -1){
			System.out.println("Enter Radius of " + RegPoly.name(3));
		}else{
			System.out.println("Thanks for playing");
		}
		int radius = sc.nextInt();
		g.setColor(Color.RED);
		g.fillPolygon(RegPoly.draw(3,radius,100,110));
		System.out.println("Enter Radius of "+RegPoly.name(4) );
		radius = sc.nextInt();
		g.setColor(Color.orange);
		g.fillPolygon(RegPoly.draw(4,radius,175,175));
		g.setColor(Color.yellow);
		System.out.println("Enter Radius of "+RegPoly.name(5) );
		radius = sc.nextInt();
		g.fillPolygon(RegPoly.draw(5, radius,250,250 ));
		g.setColor(Color.green);
		System.out.println("Enter Radius of "+RegPoly.name(6) );
		radius = sc.nextInt();
		g.fillPolygon(RegPoly.draw(6,radius,350,330));
		g.setColor(Color.blue);
		System.out.println("Enter Radius of "+RegPoly.name(7) );
		radius = sc.nextInt();
		g.fillPolygon(RegPoly.draw(7,radius,450,400));
		g.setColor(new Color(211, 4, 7));
		System.out.println("Enter Radius of "+RegPoly.name(8) );
		radius = sc.nextInt();
		g.fillPolygon(RegPoly.draw(8,radius,560,450));
		System.out.println("Thanks for playing");
		try{
			TimeUnit.SECONDS.sleep(5);
			System.exit(0);
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}


	}
}


class RegPoly
{
	public RegPoly(int numSide,int r, int cenx, int ceny){
		draw(numSide,r, cenx,ceny);
	}
	public static Polygon draw(int numSide,int r, int cenx, int ceny){
		int xcood[];
		ArrayList <Integer> xcord = new ArrayList();
		int ycood[];
		ArrayList <Integer> ycord = new ArrayList<>();

		Polygon sg = new Polygon();
		switch(numSide){
			case 3:
				sg.addPoint(cenx+r,ceny);
				sg.addPoint(cenx-(r/2),(int)(ceny+(Math.sqrt(3))*(r/2)));
				sg.addPoint(cenx-(r/2),(int)(ceny-(Math.sqrt(3))*(r/2)));
				break;
			case 4:
				//Order: top, left, right, bottom
				ycord.add(ceny-r);
				ycord.add(ceny);
				ycord.add(ceny+r);
				ycord.add(ceny);
				xcord.add(cenx);
				xcord.add(cenx-r);
				xcord.add(cenx);
				xcord.add(cenx+r);
				for(int i = 0; i< xcord.size();i++){
					sg.addPoint(xcord.get(i),ycord.get(i));
				}
				break;
			case 5:
				sg.addPoint(cenx + r, ceny);

				sg.addPoint((int)(cenx + r *

						Math.cos(2 * Math.PI / 5)), (int)(ceny - r*

						Math.sin(2 * Math.PI / 5)));

				sg.addPoint((int)(cenx + r *

						Math.cos(2 * 2 * Math.PI / 5)), (int)(ceny - r *

						Math.sin(2 * 2 * Math.PI / 5)));

				sg.addPoint((int)(cenx + r *

						Math.cos(3 * 2 * Math.PI / 5)), (int)(ceny - r *

						Math.sin(3 * 2 * Math.PI / 5)));

				sg.addPoint((int)(cenx + r *

						Math.cos(4 * 2 * Math.PI / 5)), (int)(ceny - r *

						Math.sin(4 * 2 * Math.PI / 5)));

				sg.addPoint((int)(cenx + r *

						Math.cos(5 * 2 * Math.PI / 5)), (int)(ceny - r *

						Math.sin(5 * 2 * Math.PI / 5)));
				break;
			case 6:
				sg.addPoint(cenx + r, ceny);

				sg.addPoint((int)(cenx + r *

						Math.cos(2 * Math.PI / 6)), (int)(ceny - r*

						Math.sin(2 * Math.PI / 6)));

				sg.addPoint((int)(cenx + r *

						Math.cos(2 * 2 * Math.PI / 6)), (int)(ceny - r *

						Math.sin(2 * 2 * Math.PI / 6)));

				sg.addPoint((int)(cenx + r *

						Math.cos(3 * 2 * Math.PI / 6)), (int)(ceny - r *

						Math.sin(3 * 2 * Math.PI / 6)));

				sg.addPoint((int)(cenx + r *

						Math.cos(4 * 2 * Math.PI / 6)), (int)(ceny - r *

						Math.sin(4 * 2 * Math.PI / 6)));

				sg.addPoint((int)(cenx + r *

						Math.cos(5 * 2 * Math.PI / 6)), (int)(ceny - r *

						Math.sin(5 * 2 * Math.PI / 6)));
				break;
			case 7:
				for(int i = 0; i<=6;i++){
					sg.addPoint((int)(cenx+r*Math.cos(i*2*Math.PI/7)),(int)(ceny+r*Math.sin(i*2*Math.PI/7)));
				}
				break;
			case 8:
				for(int i =0 ; i<= 7;i++){
					sg.addPoint((int)(cenx+r*Math.cos(i*2*Math.PI/8)),(int)(ceny+r*Math.sin(i*2*Math.PI/8)));
				}

		}

		return sg;


	}
	public static double toRaidian(double degree){
		return (degree/180.0) *Math.PI;
	}
	public static String name(int numSide){
		switch(numSide){
			case 3:
				return "Triangle";

			case 4:
				return "Square";

			case 5:
				return "Pentagon";
			//break;
			case 6:
				return "Hexagon";
			//break;
			case 7:
				return "Septagon/Heptagon";
			//break;
			case 8:
				return "Octogon";
			//break;


		}
		return "";
	}
	/*
    public static Polygon Calc(int numSide, int xCenter,int radius, int yCenter){
    	Polygon sg =new Polygon();
		sg.addPoint(xCenter + radius, yCenter);

		sg.addPoint((int)(xCenter + radius *

				Math.cos(2 * Math.PI / numSide)), (int)(yCenter - radius *

				Math.sin(2 * Math.PI / numSide)));

		sg.addPoint((int)(xCenter + radius *

				Math.cos(2 * 2 * Math.PI / numSide)), (int)(yCenter - radius *

				Math.sin(2 * 2 * Math.PI / numSide)));

		sg.addPoint((int)(xCenter + radius *

				Math.cos(3 * 2 * Math.PI / numSide)), (int)(yCenter - radius *

				Math.sin(3 * 2 * Math.PI / numSide)));

		sg.addPoint((int)(xCenter + radius *

				Math.cos(4 * 2 * Math.PI / numSide)), (int)(yCenter - radius *

				Math.sin(4 * 2 * Math.PI / numSide)));

		sg.addPoint((int)(xCenter + radius *

				Math.cos(5 * 2 * Math.PI / numSide)), (int)(yCenter - radius *

				Math.sin(5 * 2 * Math.PI / numSide)));
		sg.addPoint((int)(xCenter + radius *

				Math.cos(6 * 2 * Math.PI / numSide)), (int)(yCenter - radius *

				Math.sin(6 * 2 * Math.PI / numSide)));

		return sg;
	}*/


}