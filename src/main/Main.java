package main;

import gameManager.GameManager;
import gameManager.GameScreen;
import javafx.application.Application;
import javafx.stage.Stage;

import resource.SpriteAssets;

public class Main extends Application {
    private GameScreen gameScreen;
    private GameManager gameManager;

    @Override
    public void start(Stage stage) throws Exception {

    	gameScreen = new GameScreen();
    	gameManager = new GameManager(gameScreen);

    	SpriteAssets.loadResource();
    	stage.setScene(gameScreen.getGameScene());
        stage.show();
                
    }

    public static void main(String[] args) { launch(args); }

}




























//        Thread t = new Thread(() ->  {
//        	while (true) {
//        		Platform.runLater(() -> {
//        			// do something
//        		});        		
//        	}
//        });