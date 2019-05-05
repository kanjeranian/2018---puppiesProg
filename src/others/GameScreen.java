package others;

import character.Puppy;
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
import logic.Rectangle;

public class GameScreen extends StackPane {
	
	private static final double W = 1200, H = 900;
    private static final String DOG_IMAGE = "file:res/pom1.png";
    private static final String BG_IMAGE = "file:res/bg.png";


    private Node dog;
    private Node bg;
    private Scene scene;
    
    boolean running, goUp, goDown, goRight, goLeft;
    
    // -- my code
    private GraphicsContext gc;
    private Image bgImage = new Image(BG_IMAGE);
    private Image dogImage = new Image(DOG_IMAGE);
    private Puppy player1 = new Puppy(W/2, H/2, dogImage.getWidth(), dogImage.getHeight());
    private Block blocks = new Block();
    
    
    
    //con สร้าง canvas+ปากกา ยัดใส่ rootPane , ดูว่ากดหรือปล่อยปุ่ม
    public GameScreen() {
    	Canvas cv = new Canvas(W, H);
    	gc = cv.getGraphicsContext2D();
    	Pane root = new Pane(cv);
    	
    	scene = new Scene(root);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:  	goUp	= true;	break;
                    case DOWN:  goDown 	= true; break;
                    case LEFT:  goLeft  = true; break;
                    case RIGHT: goRight = true; break;
                    case SHIFT: running = true; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    goUp = false; break;
                    case DOWN:  goDown = false; break;
                    case LEFT:  goLeft  = false; break;
                    case RIGHT: goRight  = false; break;
                    case SHIFT: running = false; break;
                }
            }
        });

	}
    
    
	public void update() {
		if (goUp) player1.jump();
		if (goLeft) { 
			player1.goLeft();
			player1.setDogIMG(true);
		}
		if (goRight) { 
			player1.goRight();
			player1.setDogIMG(false);
		}
		
		for (Rectangle r: blocks.getBlock()) {
			if(player1.getHitbox().isOverlapping(r)) {
				if(player1.getHitboxHead().isOverlapping(r)) {
					player1.onCollideTop();
				}
				if(player1.getHitboxFeet().isOverlapping(r)) {
					player1.onCollideDown();
				}
			}	
		}
		
		player1.update();
		
	}
	    
	
	private void drawRectHitBox(Rectangle r) {
		Point tl = r.getTopLeft(), br = r.getBottomRight();
		gc.strokeRect(tl.getX(), tl.getY(), br.getX()-tl.getX(), br.getY()-tl.getY());
	}
	
	public void draw() {
		gc.clearRect(0, 0, W, H);
		gc.drawImage(bgImage, 0, 0);
		player1.render(gc);
		gc.setStroke(Color.RED);
		gc.setLineWidth(5);
//		for (Rectangle r: blocks.getBlock()) {
//			drawRectHitBox(r);
//		}
//		drawRectHitBox(player1.getHitbox());
	}
	
	public Scene getGameScene() {
		return scene;
	}

}
