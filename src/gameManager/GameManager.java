package gameManager;

import logic.LogicLoop;

public class GameManager {
	
	private LogicLoop logicLoop;
	
	public GameManager(GameScreen gameScreen) {
		logicLoop = new LogicLoop(gameScreen);
	}
	
	
}
