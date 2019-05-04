package others;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import logic.Point;
import logic.Rectangle;

public class GameScreen extends StackPane {
	
	private static final double W = 1200, H = 900;
    private static final String DOG_IMAGE = "file:res/pom1.png";
            //"http://icons.iconarchive.com/icons/martin-berube/flat-animal/96/puppy-icon.png";
    private static final String BG_IMAGE = "file:res/bg.png";

    private Image dogImage;
    private Image bgImage;
    private Node dog;
    private Node bg;
    private Scene scene;
    
    boolean running, goNorth, goSouth, goEast, goWest,jumping;
    
    public GameScreen() {
        dogImage = new Image(DOG_IMAGE); //Image
        dog = new ImageView(dogImage); //node
        
        bgImage = new Image(BG_IMAGE);
        bg = new ImageView(bgImage);
        
        Group dogGroup = new Group(bg);
        dogGroup.getChildren().add(dog);
        
        movedogTo(W/2, H/2); //ทำให้หมาอยู่ตรงกลาง (ตำแหน่งน้องหมายึดจาก center ของน้องหมาเลย)
        scene = new Scene(dogGroup, W, H, Color.WHITE);
        
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

	}
    
public void movedogBy(int dx, int dy) {
    	
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
    	System.out.printf("%.2f %.2f\n", x, y);
        final double cx = dog.getBoundsInLocal().getWidth()  / 2;
        final double cy = dog.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
            x + cx <= W &&
            y - cy >= 0 &&
            y + cy <= H) {
            dog.relocate(x - cx, y - cy);
        }
    }

	public Scene getGameScreenScene() {
		return scene;
	}

	public boolean isGoNorth() {
		return goNorth;
	}

	public boolean isGoSouth() {
		return goSouth;
	}

	public boolean isGoEast() {
		return goEast;
	}

	public boolean isGoWest() {
		return goWest;
	}

	public boolean isJumping() {
		return jumping;
	}
    
	public boolean isRunning() {
		return running;
	}
    
    
    

}
