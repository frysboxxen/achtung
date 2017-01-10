import java.awt.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake{

	private double x, y, radie, xScale, yScale, deltaX, deltaY,v,degree;
	private int tLeft,tRight;
	private Color c;
	ArrayList<Double> xLine = new ArrayList<Double>();
	ArrayList<Double> yLine = new ArrayList<Double>();

	public void Snake(double xS, double yS,double r,Color cS,double vS,int tLefts,int tRights){
		xScale = xS;
		yScale = yS;
		radie = r;
		v = vS;
		c = cS;
		tLeft = tLefts;
		tRight = tRights;
		degree = Math.random()*360;
		x = Math.random()*(xScale-400)+200;
		y = Math.random()*(yScale-400)+200;
	}

	public void drawSnake(){

		StdDraw.setPenColor(c);
		StdDraw.filledSquare(x,y,radie);

		xLine.add(x);
		yLine.add(x);
	}

	public void moveSnake(){

		deltaX = v * Math.cos(Math.toRadians(degree));
		deltaY = v * Math.sin(Math.toRadians(degree));

		x = x + deltaX;
		y = y + deltaY;

	}

	public void turnSnake(){

		if(StdDraw.isKeyPressed(tLeft)) degree = degree+5;
		if(StdDraw.isKeyPressed(tRight)) degree = degree-5;
	}

	public static boolean collision(double x1,double y1,double x2,double y2,int radie){

		if(Math.abs(x1-x2) < radie && Math.abs(y1-y2) < radie)
			return true;
		else return false;
	}

}