package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Point;
import logic.Rectangle;
import java.util.Random;

import SharedObject.IRenderable;

public class Ghost implements IRenderable {
	
	private double z;
	private double x,y;
	private boolean is_visible, is_destroyed;
	private static final double W = 178, H=216;
	
	private static final Image GHOST_IMAGE_LEFT = new Image("file:res/ghostL.png");
	private static final Image GHOST_IMAGE_Right = new Image("file:res/ghostR.png");
	private Image ghostIMG = GHOST_IMAGE_LEFT;
	
	private Rectangle hitbox = new Rectangle(new Point(0, 0));
	private Rectangle hitboxHead = new Rectangle(new Point(0, 0));
	private Rectangle hitboxFeet = new Rectangle(new Point(0, 0));
	private Rectangle hitboxLeft = new Rectangle(new Point(0, 0));
	private Rectangle hitboxRight = new Rectangle(new Point(0, 0));
	
	private double width=W;
	private double height=H;
	private double speed;

	
	public Ghost(int z) {
		this.z = z;
		speed = 0.5;
	}
	
	public void update(Puppy puppy) {
		moveToPup(puppy);
	}
	
	public void moveToPup(Puppy puppy) {
		if(puppy.getX()>x) { 
			x+=speed;
			ghostIMG = GHOST_IMAGE_Right;
		}
		if(puppy.getX()<x) { 
			x-=speed;
			ghostIMG = GHOST_IMAGE_LEFT;
		}
		if(puppy.getY()>y) y+=speed;
		if(puppy.getY()<y) y-=speed;
	}

	@Override
	public double getZ() {
		return z;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(ghostIMG, x, y);		
	}

	@Override
	public boolean isDestroyed() {
		return is_destroyed;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return is_visible;
	}

}
