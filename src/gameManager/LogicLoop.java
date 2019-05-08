package gameManager;

import SharedObject.AllObj;
import character.Ghost;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class LogicLoop {
	
	private Timeline timeline;
	private GameScreen gameScreen;
	private KeyPress keyPress;
	private int ghostCount = 0;
	
	public  LogicLoop(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		keyPress = gameScreen.getKeyPress();
		timeline = new Timeline(
				new KeyFrame(Duration.seconds(1./60), e -> {
					createGhost();
					
					keyPress.setKeyStatus();
					AllObj.ALL.update();
					AllObj.ALL.draw(gameScreen.getGc());				
				}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	
	private void createGhost() {
		if(ghostCount == 0) {
			AllObj.addToGhostsList(new Ghost(1));
		} 
		ghostCount=(ghostCount==600)?0:ghostCount+1;
	}
	
	
}
