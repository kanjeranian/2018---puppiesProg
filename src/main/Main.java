package main;

import java.util.ArrayList;

import gameManager.GameManager;
import gameManager.GameScreen;
import gameManager.KeyPress;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.Point;
import logic.Hitbox;
import others.Block;

public class Main extends Application {
    private GameScreen gameScreen;
    private GameManager gameManager;

    @Override
    public void start(Stage stage) throws Exception {

    	gameScreen = new GameScreen();
    	gameManager = new GameManager(gameScreen);

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