package logic;

import gameManager.GameScreen;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class LogicLoop {
	
	private Timeline timeline;
	private GameScreen gameScreen;
	
	public  LogicLoop(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		timeline = new Timeline(
				new KeyFrame(Duration.seconds(1./60), e -> {
					gameScreen.update();
					gameScreen.draw();					
				}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	
	
}
