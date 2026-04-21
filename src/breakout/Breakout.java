/**
 * Elaine Chen 
 * P1 APCS
 * Date: Apr 20, 2026

 * Is this lab working: 
 * If not, explain: 
 * If resubmitting, explain what was wrong and what you fixed. 
 */
package breakout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 */
public class Breakout extends Application{
	public static void main (String[] args) {
		launch();
	}
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("Breakout");
		
		BorderPane bored = new BorderPane();
		
		BallWorld world = new BallWorld();
		bored.setCenter(world);
		world.start();
		
		
		Scene mainScene = new Scene(bored);
		stage.setScene(mainScene);		
		stage.show();
		
	}

}
