package main;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
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
import logic.Point;
import logic.Rectangle;
import others.Block;
import others.GameScreen;

/**
 * Hold down an arrow key to have your dog move around the screen.
 * Hold down the shift key to have the dog run.
 */
public class Main extends Application {
    private static final double W = 1200, H = 900;
    
    private GameScreen gameScreen;

    boolean running, goNorth, goSouth, goEast, goWest,jumping;

    @Override
    public void start(Stage stage) throws Exception {

    	gameScreen = new GameScreen();
        stage.setScene(gameScreen.getGameScreenScene());
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                if (gameScreen.isGoNorth()) dy -= 1;
                if (gameScreen.isGoSouth()) dy += 1;
                if (gameScreen.isGoEast())  dx += 1;
                if (gameScreen.isGoWest())  dx -= 1;
                if (gameScreen.isRunning()) { dx *= 13; dy *= 13; }
//                if (gameScreen.isJumping())  dx -= 1;
                

                gameScreen.movedogBy(dx, dy);
            }
        };
        
        Thread t = new Thread(() ->  {
        	while (true) {
        		Platform.runLater(() -> {
        			// do something
        		});        		
        	}
        });
        
        timer.start();
    }

    public static void main(String[] args) { launch(args); }
}