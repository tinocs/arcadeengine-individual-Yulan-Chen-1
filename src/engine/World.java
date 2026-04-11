/**
 * Elaine Chen 
 * P1 APCS
 * Date: Apr 9, 2026

 * Is this lab working: 
 * If not, explain: 
 * If resubmitting, explain what was wrong and what you fixed. 
 */
package engine;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.Styleable;
import javafx.event.EventTarget;
import javafx.scene.layout.Pane;
import java.util.*;
import javafx.scene.input.KeyCode;

public abstract class World extends Pane implements EventTarget, Styleable{
	
	private boolean isTimerRunning;
	private boolean dimensionsSet;
	private List<Actor> objects;
	
	private double width;
	private double height;
	
	public World() {
		isTimerRunning = false;
		dimensionsSet = false;
		objects = new ArrayList<Actor>();
		
		widthProperty().addListener(dimensionTracker);
		heightProperty().addListener(dimensionTracker);
	}
	
	public abstract void act(long now) ;

	public abstract void onDimensionsInitialized() ;


	public void	add(Actor actor) {
		
	}
	
	public <A extends Actor> List<A>getObjects(Class<A> cls){
		return (List<A>) objects;
		
	}
	
	public <A extends Actor> List<A>getObjectsAt(double x, double y, Class<A> cls){
		
		return (List<A>) objects;
		
	}
	public boolean	isKeyPressed(KeyCode code) {
		
	}
	
	public boolean	isStopped() {
		return !isTimerRunning;
	}
	public void	remove(Actor actor) {
		
	}
	public void	start() {
		isTimerRunning = true;
	}
	public void	stop() {
		isTimerRunning = false;
	}
	
	private class dimensionTracker implements ChangeListener<Number> {
		@Override
		public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
			
		}
    }
}
