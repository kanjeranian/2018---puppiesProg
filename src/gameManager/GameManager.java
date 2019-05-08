package gameManager;

public class GameManager {
	
	private LogicLoop logicLoop;
	
	public GameManager(GameScreen gameScreen) {
		logicLoop = new LogicLoop(gameScreen);
	}
	
	
}
