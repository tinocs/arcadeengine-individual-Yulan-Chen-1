/**
 * Elaine Chen 
 * P1 APCS
 * Date: Apr 21, 2026

 * Is this lab working: 
 * If not, explain: 
 * If resubmitting, explain what was wrong and what you fixed. 
 */
package breakout;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * 
 */
public class Score extends Text{
	int value;
	
	public Score() {
		super("aaaaaaaaaaaaaaaaa");
		value = 0;
		//setFont(new Font(30));
		updateDisplay();
	}
	
	public void updateDisplay() {
		setText(""+value);
	}
	
	public int getScore() {
		return value;
	}
	public void setScore(int score) {
		value = score;
		updateDisplay();
	}
}

