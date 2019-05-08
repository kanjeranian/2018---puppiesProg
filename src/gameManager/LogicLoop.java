package gameManager;

import SharedObject.AllObj;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class LogicLoop {
	
	private Timeline timeline;
	private GameScreen gameScreen;
	private KeyPress keyPress;
	
	public  LogicLoop(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		keyPress = gameScreen.getKeyPress();
		timeline = new Timeline(
				new KeyFrame(Duration.seconds(1./60), e -> {
//					gameScreen.update();
					keyPress.setKeyStatus();
					AllObj.ALL.update();
					gameScreen.draw();					
				}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	
	
}
