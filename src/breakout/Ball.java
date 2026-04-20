/**
 * Elaine Chen 
 * P1 APCS
 * Date: Apr 20, 2026

 * Is this lab working: 
 * If not, explain: 
 * If resubmitting, explain what was wrong and what you fixed. 
 */
package breakout;

import engine.Actor;
import javafx.scene.image.Image;

public class Ball extends Actor{
	private int dy;
	private int dx;
	
	private Image BALL = new Image(getClass().getClassLoader().getResource("breakoutresources/ball.png").toString());
	
	public Ball() {
		setImage(BALL);
		int dx = 5;
		int dy = 5;
	}

	@Override
	public void act(long now) {
		move(dx,dy);
		
		if (getX()<0 || getX()+getWidth() > getWorld().getWidth()) {
			dx = -dx;
		}
		if (getY()<0 || getY()+getHeight() < getWorld().getHeight()) {
			dy = -dy;
		}
		
	}
	
}
