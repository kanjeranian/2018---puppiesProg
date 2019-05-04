package main;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.Point;
import logic.Rectangle;
import others.Block;

/**
 * Hold down an arrow key to have your dog move around the screen.
 * Hold down the shift key to have the dog run.
 */
public class Main extends Application {
    private static final double W = 1200, H = 900;

    private static final String DOG_IMAGE = "file:res/pom1.png";
            //"http://icons.iconarchive.com/icons/martin-berube/flat-animal/96/puppy-icon.png";
    private static final String BG_IMAGE = "file:res/bg.png";

    private Image dogImage;
    private Image bgImage;
    private Node dog;
    private Node bg;

    boolean running, goNorth, goSouth, goEast, goWest,jumping;

    @Override
    public void start(Stage stage) throws Exception {
    	
        dogImage = new Image(DOG_IMAGE); //Image
        dog = new ImageView(dogImage); //node
        
        bgImage = new Image(BG_IMAGE);
        bg = new ImageView(bgImage);
        
     
        Group dogGroup = new Group(bg);
        dogGroup.getChildren().add(dog);
        
       
        movedogTo(W/2, H/2-30); //ทำให้หมาอยู่ตรงกลาง
        
        Scene scene = new Scene(dogGroup, W, H, Color.WHITE);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    {
                    	goNorth = true;
                    	jumping = true;
                    	break;
                    }
                    case DOWN:  goSouth = true; break;
                    case LEFT:  goWest  = true; break;
                    case RIGHT: goEast  = true; break;
                    case SHIFT: running = true; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    goNorth = false; break;
                    case DOWN:  goSouth = false; break;
                    case LEFT:  goWest  = false; break;
                    case RIGHT: goEast  = false; break;
                    case SHIFT: running = false; break;
                }
            }
        });

        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                if (goNorth) dy -= 1;
                if (goSouth) dy += 1;
                if (goEast)  dx += 1;
                if (goWest)  dx -= 1;
                if (running) { dx *= 13; dy *= 13; }

                movedogBy(dx, dy);
            }
        };
        
        Thread t = new Thread(() ->  {
        	// 
        	while (true) {
        		Platform.runLater(() -> {
        			// do something
        		});        		
        	}
        });
        
        timer.start();
    }

    private void movedogBy(int dx, int dy) {
    	
        if (dx == 0 && dy == 0) return;

        final double width = dog.getBoundsInLocal().getWidth()  / 2;
        final double height = dog.getBoundsInLocal().getHeight() / 2;
        

        double x = width + dog.getLayoutX() + dx;
        double y = height + dog.getLayoutY() + dy;
        
        Rectangle dogPos = new Rectangle(new Point(x-51, y-50), new Point(x+51,y+59));
        System.out.printf("%.2f %.2f\n",x,y);
        Block blocks = new Block();
        for(Rectangle b:blocks.getBlock()) {
        	if(dogPos.isOverlapping(b)) {
        		return;
        	}
        }

        movedogTo(x, y);
    }

    private void movedogTo(double x, double y) {
//    	System.out.printf("%.2f %.2f\n", x, y);
        final double cx = dog.getBoundsInLocal().getWidth()  / 2;
        final double cy = dog.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
            x + cx <= W &&
            y - cy >= 0 &&
            y + cy <= H) {
            dog.relocate(x - cx, y - cy);
        }
    }

    public static void main(String[] args) { launch(args); }
}