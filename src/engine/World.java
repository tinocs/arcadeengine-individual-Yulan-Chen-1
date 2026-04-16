/**
 * Elaine Chen 
 * P1 APCS
 * Date: Apr 9, 2026

 * Is this lab working: 
 * If not, explain: 
 * If resubmitting, explain what was wrong and what you fixed. 
 */
package engine;

import javafx.animation.AnimationTimer;
import javafx.css.Styleable;
import javafx.event.EventTarget;
import javafx.scene.layout.Pane;
import java.util.*;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;

public abstract class World extends Pane implements EventTarget, Styleable{
	
	private boolean isTimerRunning;
	
	private Set<KeyCode> keysPressed;
	
	private boolean isWidthSet;
	private boolean isHeightSet;
	private boolean dimensionInit;
	AnimationTimer timer;
	
	public World() {
		
		isTimerRunning = false;
		isWidthSet = false;
		isHeightSet = false;
		dimensionInit = false;
		
		
		keysPressed = new HashSet<KeyCode>();
		
		this.widthProperty().addListener((observable, oldValue,newValue) -> {
			if (newValue.doubleValue()>0) isWidthSet = true;
			if (isWidthSet && isHeightSet && !dimensionInit) {
				onDimensionsInitialized();
				dimensionInit = true;
			}
		});
		
		this.heightProperty().addListener((observable, oldValue,newValue) -> {
			if (newValue.doubleValue()>0) isHeightSet = true;
			if (isWidthSet && isHeightSet && !dimensionInit) {
				onDimensionsInitialized();
				dimensionInit = true;
			}
		});
		
		this.sceneProperty().addListener((observable, oldValue,newValue)->{
			if (newValue!=null) requestFocus();
		});
		
		setOnKeyPressed(event ->{
			keysPressed.add(event.getCode());
		});
		
		setOnKeyReleased(event ->{
			keysPressed.remove(event.getCode());
		});
		
		timer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				act(arg0);
				for (Actor a:getObjects(Actor.class)) if (a.getWorld()!=null) a.act(arg0);
			}
		};
	}
	
	public abstract void act(long now) ;

	public abstract void onDimensionsInitialized() ;

	public void	add(Actor actor) {
		getChildren().addAll(actor);
		actor.addedToWorld();
	}
	
	public <A extends Actor> List<A>getObjects(Class<A> cls){
		List<A> ans = new ArrayList<A>();
		for (Node n:getChildren()) {
			if (cls.isInstance(n)) {
				ans.add(cls.cast(n));
			}
		}
		return ans;
	}
	
	public<A extends Actor> List<A>getObjectsAt(double x, double y, Class<A> cls){
		
		List<A> ans = new ArrayList<A>();
		for (Node n:getChildren()) {
			if (cls.isInstance(n) && n.getBoundsInParent().contains(x,y)) {
				ans.add(cls.cast(n));
			}
		}
		return ans;
		
	}
	public boolean	isKeyPressed(KeyCode code) {
		return keysPressed.contains(code);
	}
	
	public boolean	isStopped() {
		return !isTimerRunning;
	}
	public void	remove(Actor actor) {
		getChildren().remove(actor);
	}
	public void	start() {
		isTimerRunning = true;
		timer.start();
	}
	public void	stop() {
		isTimerRunning = false;
		timer.stop();
	}
	
}
