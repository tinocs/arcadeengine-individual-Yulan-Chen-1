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

/**
 * 
 */
public class Paddle extends Actor{
	private final Image PADDLE = new Image(getClass().getClassLoader().getResource("breakoutresources/paddle.png").toString());
	
	public Paddle() {
		setImage(PADDLE);
	}

	@Override
	public void act(long now) {
		
	}
}
