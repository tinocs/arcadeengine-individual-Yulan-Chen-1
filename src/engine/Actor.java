/**
 * Elaine Chen 
 * P1 APCS
 * Date: Apr 9, 2026

 * Is this lab working: 
 * If not, explain: 
 * If resubmitting, explain what was wrong and what you fixed. 
 */
package engine;

import java.util.ArrayList;
import java.util.List;

import javafx.css.Styleable;
import javafx.event.EventTarget;
import javafx.scene.image.ImageView;

public abstract class Actor extends ImageView implements Styleable, EventTarget{
	
	
	public abstract void act(long now);
	
	public void	addedToWorld(){
		
	}
	
	public double	getHeight(){
		return getBoundsInParent().getHeight();
	}
	public <A extends Actor> java.util.List<A>	getIntersectingObjects(java.lang.Class<A> cls){
		List<A> a = getWorld().getObjects(cls);
		List<A> ans = new ArrayList<A>();
		for (A b:a) {
			if(b.getBoundsInParent().intersects(this.getBoundsInParent()) && !b.equals(this)) {
				ans.add(cls.cast(b));
			}
		}
		return ans;
	}
	public <A extends Actor> A	getOneIntersectingObject(java.lang.Class<A> cls) {
		List<A> a = getWorld().getObjects(cls);
		for (Actor b:a) {
			if(b.getBoundsInParent().intersects(this.getBoundsInParent()) && !b.equals(this)) {
				return cls.cast(b);
			}
		}
		return null;
		
	}
	public double	getWidth(){
		return getBoundsInParent().getWidth();
	}
	public World getWorld(){
		return (World) getParent();
	}
	public void	move(double dx, double dy) {
		setX(getX()+dx);
		setY(getY()+dy);
	}
}
