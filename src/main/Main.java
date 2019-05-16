package main;

import gameManager.GameManager;
import gameManager.GameScreen;
import javafx.application.Application;
import javafx.stage.Stage;

import resource.SpriteAssets;
import screens.GameOverScreen;
import screens.MainMenuScreen;

public class Main extends Application {//implements Runnable{
    private static GameScreen gameScreen;
    private static GameManager gameManager;
    private static MainMenuScreen mainMenu;
    private static GameOverScreen gameOverScreen;
    
    
    
    
    private static Stage stage;
//    private boolean running = false;
//    private Thread thread;
   
    public void start(Stage stage) {
    	SpriteAssets.loadResource();
    	Main.stage = stage;
    	gameScreen = new GameScreen();
    	gameManager = new GameManager(gameScreen);
    	mainMenu = new MainMenuScreen();
    	gameOverScreen = new GameOverScreen();
    	
    	stage.setScene(mainMenu);
    	
//    	stage.setScene(gameScreen.getGameScene());
    	
    	
    	stage.show();
    }

	public static GameScreen getGameScreen() {
		return gameScreen;
	}

	public static void setStage(GameScreen gameScreen) {
		Main.gameScreen = gameScreen;
		stage.setScene(gameScreen.getScene());
	}

	public static GameManager getGameManager() {
		return gameManager;
	}

	public static void setGameManager(GameManager gameManager) {
		Main.gameManager = gameManager;
	}

	public static Stage getStage() {
		return stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static GameOverScreen getGameOverScreen() {
		return gameOverScreen;
	}
	
	public static MainMenuScreen getMainMenuScreen() {
		return mainMenu;
	}
    
    
}
//@Override
//public void init() {
//	SpriteAssets.loadResource();
//	gameScreen = new GameScreen();
//	gameManager = new GameManager(gameScreen);
//}
//    private void update() {
//    }
//   
//    private void render() {
//    	
//    }
    
//    @Override
//	public void run() {
//		init();
//		
//		while(running) {
//			update();
//			render();
//		}
//		stop();
//	}
//	
//	@Override
//    public void start(Stage stage) throws Exception {
//		if(running)
//			return;
//		running = true;
//    	thread = new Thread(this);
//    	thread.start();
//    	stage.setScene(gameScreen.getGameScene());
//        stage.show();
//                
//    }
//	
//	@Override
//	public void stop() {
//		if(!running)
//			return;
//		running = false;
//		try {
//			thread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//    public static void main(String[] args) { launch(args); }
//
//
//}