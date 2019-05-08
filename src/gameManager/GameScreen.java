package gameManager;

import java.util.ArrayList;

import SharedObject.AllObj;
import character.Ghost;
import character.Puppy;
import character.Puppy1;
import character.Puppy2;
import constant.Img;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import logic.Point;
import others.Block;
import logic.Hitbox;

public class GameScreen extends StackPane {
	
	private static final double W = 1200, H = 900;
    private Scene scene;
    private GraphicsContext gc;
    private KeyPress keyPress;

    public GameScreen() {    	
    	Canvas cv = new Canvas(W, H);
    	gc = cv.getGraphicsContext2D();
    	Pane root = new Pane(cv);
    	scene = new Scene(root);
    	keyPress = new KeyPress(scene);
	}
	
	public Scene getGameScene() {
		return scene;
	}
	
	public KeyPress getKeyPress() {
		return keyPress;
	}
	
	public GraphicsContext getGc() {
		return gc;
	}

}
