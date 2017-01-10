import java.awt.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class achtung{

	public static void main(String[] args) {

		int xScale = 2500;
		int yScale = 1800;

		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(xScale,yScale);
		StdDraw.setXscale(0,xScale);
		StdDraw.setYscale(0,yScale);
		
		Snake snake1 = new Snake();
		Snake snake2 = new Snake();
		snake1.Snake(xScale,yScale,10,StdDraw.RED,3,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT);
		snake2.Snake(xScale,yScale,10,StdDraw.GREEN,3,KeyEvent.VK_A,KeyEvent.VK_D);

		StdDraw.clear(StdDraw.BLACK);

		boolean endGame = false;

		while(!endGame){

			for(int i=0; i<snake1.xLine.size();i++){
				if(Snake.collision(snake1.xLine.get(i),snake1.yLine.get(i),snake2.xLine.get(i),snake2.yLine.get(i),10)){
					endGame = true;
				}
			}

			snake1.turnSnake();
			snake2.turnSnake();
			snake1.moveSnake();
			snake2.moveSnake();
			snake1.drawSnake();
			snake2.drawSnake();

			StdDraw.show();
			StdDraw.pause(40);

		}
	}


}