/**
 * Elaine Chen 
 * P1 APCS
 * Date: Apr 20, 2026

 * Is this lab working: 
 * If not, explain: 
 * If resubmitting, explain what was wrong and what you fixed. 
 */
package breakout;

import engine.World;
/**
 * 
 */
public class BallWorld extends World{

	Score s;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDimensionsInitialized() {
		// TODO Auto-generated method stub
		add(new Ball());
		
		Paddle p = new Paddle();
		p.setX(getWidth()/2-p.getWidth()/2); p.setY(getHeight()*3/4);
		add(p);
		
		Brick b = new Brick();
		b.setX(getWidth()*3/4); b.setY(getHeight()/2-b.getHeight()/2);
		add(b);
		
		s = new Score();
		s.setX(0);s.setY(getHeight()*7/8);
		getChildren().add(s);
		
		
		this.setOnMouseMoved(event ->{
			p.setX(event.getSceneX()-p.getWidth()/2);
		});
		
		
	}
	
	public Score getScore() {
		return s;
	}

}
