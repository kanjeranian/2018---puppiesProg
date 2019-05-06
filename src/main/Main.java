package main;

import java.util.ArrayList;
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
import others.GameScreen;

public class Main extends Application {
    private GameScreen gameScreen;

    @Override
    public void start(Stage stage) throws Exception {

    	gameScreen = new GameScreen();
        stage.setScene(gameScreen.getGameScene());
        stage.show();

        
        Timeline tl = new Timeline(
        	new KeyFrame(Duration.seconds(1./60), e ->  {
        		// game loop
        		gameScreen.update();
        		gameScreen.draw();
        	})
        );
        tl.setCycleCount(Timeline.INDEFINITE); // loop infinite time
        tl.play();
        
        Thread t = new Thread(() ->  {
        	while (true) {
        		Platform.runLater(() -> {
        			// do something
        		});        		
        	}
        });
    }

    public static void main(String[] args) { launch(args); }
}