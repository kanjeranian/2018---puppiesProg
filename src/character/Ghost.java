package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Point;
import others.Obj;
import logic.Hitbox;
import java.util.Random;

import SharedObject.AllObj;
import SharedObject.AllObjList;
import SharedObject.Renderable;
import constant.Img;
import item.BlueBall;
import item.Item;

public class Ghost extends Character implements Renderable {
	
	private boolean is_visible, is_destroyed;
	private static final double W = 178, H=216;
	
	public static final double DAMAGE = 0.5;
	private static final Image GHOST_IMAGE_LEFT = Img.ghostL;
	private static final Image GHOST_IMAGE_Right = Img.ghostR;
	private Image ghostIMG = GHOST_IMAGE_LEFT;
	
	private Hitbox hitbox = new Hitbox(0,0,W,H);
	
	private double width=W;
	private double height=H;
	private double speed;
	private boolean isLeft;
	
	
	public Ghost(int z) {
		super(0, 0, z);
		speed = 0.5;
		x=randomX();
		y=randomY();
		hitbox.setRectangle(x, y, width, height);
		hp = new Hp(x+28,y-39,z+0.5);

	}
	
	public static double randomX() {
		return Math.random()*1200;
	}
	
	public static double randomY() {
		return Math.random()*900;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}

	public void update(Puppy puppy) {
		moveToPup(puppy);		
		if(isLeft==true) {
			hp.setPoint(x+28, y-39);
			hitbox.setRectangle(x, y, width, height);
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
	public void draw(GraphicsContext gc) {
		gc.drawImage(ghostIMG, x, y);		
		hp.draw(gc,(Renderable)this);
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

	@Override
	public void takeDamageBy(Obj obj) {
		if(obj instanceof Item && ((Item)obj).getHitbox().isOverlapping(hitbox)) { 
			Item item = (Item) obj;
			hp.decrease(item.getDamage());
			AllObjList.getItemsList().remove(item);
			
		}
	}

	public double getHpValue() {
		return hp.getHp();
	}

	public Object getHp() {
		return hp;
	}

}
