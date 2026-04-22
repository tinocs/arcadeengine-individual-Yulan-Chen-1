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
	
	private final Image BALL = new Image(getClass().getClassLoader().getResource("breakoutresources/ball.png").toString());
	
	public Ball() {
		setImage(BALL);
		dx = 1;
		dy = 1;
	}

	@Override
	public void act(long now) {
		move(dx,dy);
		
		//use abs to deal with user resizing world issues
		if (getX()<0)dx = Math.abs(dx);
		if (getX()+getWidth() > getWorld().getWidth()) dx = -Math.abs(dx);
		if (getY()<0)dy = Math.abs(dy);
		if (getY()+getHeight() > getWorld().getHeight())dy = -Math.abs(dy);
		
		//paddel 
		if (getOneIntersectingObject(Paddle.class) != null) {
			dy = -dy;
		}
		
		if (getOneIntersectingObject(Brick.class) != null) {
			Brick b = getOneIntersectingObject(Brick.class);
			
			double ballX = getX()+getWidth()/2;
			double ballY = getY()+getHeight()/2;
			
			if (ballX > b.getX()-b.getWidth() && ballX < b.getX()+b.getWidth()) {
				dx = -dx;
			}else if (ballY > b.getY()-b.getHeight() && ballY < b.getY()+b.getHeight()) {
				dy = -dy;
			}else {
				dx = -dx;
				dy = -dy;
			}
			
			getWorld().remove(b);
		}
		
	}
	
}
