package gameManager;

import java.util.ArrayList;

import character.AllGhost;
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
    
    boolean goUp1, goDown1, goRight1, goLeft1, attacking1;
    boolean goUp2, goDown2, goRight2, goLeft2, attacking2;
   
    private ArrayList<Hitbox> blocks = Block.getBlocks();    
    private Block allBlocks = Block.getBlockInstance();
    
    private Puppy1 player1 = new Puppy1(W/2, H/2,1);
    private Puppy2 player2 = new Puppy2(W/2, H/2,2);

    private Ghost ghost1 = new Ghost(3);    
   
    
    
    
    
    
    //con สร้าง canvas+ปากกา ยัดใส่ rootPane , ดูว่ากดหรือปล่อยปุ่ม
   
    
    
    
    
    
    
    public GameScreen() {
    	AllGhost.addGhost(ghost1);
    	
    	Canvas cv = new Canvas(W, H);
    	gc = cv.getGraphicsContext2D();
    	Pane root = new Pane(cv);
    	
    	scene = new Scene(root);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:  	goUp1		= true;	break;
                    case DOWN:  goDown1 	= true; break;
                    case LEFT:  goLeft1  	= true; break;
                    case RIGHT: goRight1   	= true; break;
                    case ENTER: attacking1 	= true; break;
                    
                    case W:  	goUp2		= true;	break;
                    case S:  	goDown2 	= true; break;
                    case A:  	goLeft2  	= true; break;
                    case D: 	goRight2   	= true; break;
                    case SPACE: attacking2 	= true; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    goUp1 		= false; break;
                    case DOWN:  goDown1 	= false; break;
                    case LEFT:  goLeft1  	= false; break;
                    case RIGHT: goRight1  	= false; break;
                    case ENTER: attacking1 	= false; break;
                    
                    case W:  	goUp2		= false; break;
                    case S:  	goDown2 	= false; break;
                    case A:  	goLeft2  	= false; break;
                    case D: 	goRight2   	= false; break;
                    case SPACE: attacking2 	= false; break;
                }
            }
        });

	}
    
    
	public void update() {
		player1.update(goUp1,goLeft1,goRight1,attacking1);
		player2.update(goUp2,goLeft2,goRight2,attacking2);
		
		ghost1.update(player1);
		if(player1.wasHauntedBy(ghost1)) {
			player1.wasDestroyed();
		}
	}
	    
	public void draw() {
		gc.drawImage(Img.bg, 0, 0);	
		allBlocks.draw(gc);
		player1.draw(gc);
		player2.draw(gc);
		ghost1.draw(gc);
		drawHitbox();

	}
	
	public void drawHitbox() {
		gc.setStroke(Color.RED);
		gc.setLineWidth(5);
		for (Hitbox r: blocks) {
			drawRectHitBox(r);
		}
		drawRectHitBox(player1.getHitbox());
		drawRectHitBox(ghost1.getHitbox());
	}
	private void drawRectHitBox(Hitbox r) {
		Point tl = r.getTopLeft(), br = r.getBottomRight();
		gc.strokeRect(tl.getX(), tl.getY(), br.getX()-tl.getX(), br.getY()-tl.getY());
	}
	
	
	public Scene getGameScene() {
		return scene;
	}

}
