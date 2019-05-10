package main;

import gameManager.GameManager;
import gameManager.GameScreen;
import javafx.application.Application;
import javafx.stage.Stage;

import resource.SpriteAssets;

public class Main extends Application implements Runnable{
    private GameScreen gameScreen;
    private GameManager gameManager;
    
    private boolean running = false;
    private Thread thread;
    
    @Override
    public void init() {
    	gameScreen = new GameScreen();
    	gameManager = new GameManager(gameScreen);
    	SpriteAssets.loadResource();
	}
    
    private void update() {
    	
    }
    
    
    private void render() {
    	
    }
    
    @Override
	public void run() {
		init();
		
		while(running) {
			update();
			render();
		}
		stop();
	}
	
	@Override
    public void start(Stage stage) throws Exception {
		if(running)
			return;
		running = true;
    	thread = new Thread(this);
    	thread.start();
    	stage.setScene(gameScreen.getGameScene());
        stage.show();
                
    }
	
	@Override
	public void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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