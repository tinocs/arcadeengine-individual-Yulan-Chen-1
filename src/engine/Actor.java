/**
 * Elaine Chen 
 * P1 APCS
 * Date: Apr 9, 2026

 * Is this lab working: 
 * If not, explain: 
 * If resubmitting, explain what was wrong and what you fixed. 
 */
package engine;

import javafx.css.Styleable;
import javafx.event.EventTarget;
import javafx.scene.image.ImageView;

public abstract class Actor extends ImageView implements Styleable, EventTarget{
	private World world;
	
	public abstract void	act(long now);
	public void	addedToWorld(){
		//w = ;
	}
	public double	getHeight(){
		return getFitHeight();
	}
	public <A extends Actor> java.util.List<A>	getIntersectingObjects(java.lang.Class<A> cls){
		
	}
	public <A extends Actor> A	getOneIntersectingObject(java.lang.Class<A> cls) {
		
	}
	public double	getWidth(){
		return getFitWidth();
	}
	public World getWorld(){
		return world;
	}
	public void	move(double dx, double dy) {
		setX(dx);
		setY(dy);
	}
}
