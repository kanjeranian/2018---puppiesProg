package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Point;
import logic.Hitbox;
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
	
	private Hitbox hitbox = new Hitbox();
	
	private double width=W;
	private double height=H;
	private double speed;
	
	private Hp hp;
	private boolean isLeft;

	public double getHpValue() {
		return hp.getHp();
	}
	
	public Hp getHp() {
		return hp;
	}
	
	
	public Ghost(int z) {
		this.z = z;
		speed = 0.5;
		
		hp = new Hp(x+28,y-39,z+0.5);
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}

	public void update(Puppy puppy) {
		moveToPup(puppy);		
		if(isLeft==true) {
			hp.setPoint(x+28, y-39);
			return;
		}
		hp.setPoint(x+57, y-39);
		hitbox.setRectangle(x, y, width, height);
	}

	
	public void moveToPup(Puppy puppy) {
		if(puppy.getX()>x) { 
			x+=speed;
			ghostIMG = GHOST_IMAGE_Right;
			isLeft=false;
		}
		if(puppy.getX()<x) { 
			x-=speed;
			ghostIMG = GHOST_IMAGE_LEFT;
			isLeft=true;
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
		hp.draw(gc,(IRenderable)this);
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
