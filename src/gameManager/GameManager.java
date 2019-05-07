package gameManager;

import logic.LogicLoop;
import others.GameScreen;

public class GameManager {
	
	private LogicLoop logicLoop;
	
	public GameManager(GameScreen gameScreen) {
		logicLoop = new LogicLoop(gameScreen);
	}
	
	
}
