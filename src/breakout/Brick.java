/**
 * Elaine Chen 
 * P1 APCS
 * Date: Apr 21, 2026

 * Is this lab working: 
 * If not, explain: 
 * If resubmitting, explain what was wrong and what you fixed. 
 */
package breakout;

import engine.Actor;
import javafx.scene.image.Image;


public class Brick extends Actor{
	private final Image BRICK = new Image(getClass().getClassLoader().getResource("breakoutresources/brick.png").toString());
	
	public Brick() {
		setImage(BRICK);
	}

	@Override
	public void act(long now) {
		
	}
}
