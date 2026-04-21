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
import javafx.scene.input.KeyCode;

/**
 * 
 */
public class Paddle extends Actor{
	private final Image PADDLE = new Image(getClass().getClassLoader().getResource("breakoutresources/paddle.png").toString());
	private final int SPEED = 3;
	
	public Paddle() {
		setImage(PADDLE);
	}

	@Override
	public void act(long now) {
		if (getWorld().isKeyPressed(KeyCode.LEFT)) {
			move(-SPEED,0);
		}
		if (getWorld().isKeyPressed(KeyCode.RIGHT)) {
			move(SPEED,0);
		}
	}
}
