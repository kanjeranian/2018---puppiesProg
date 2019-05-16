package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Point;
import others.Obj;
import sharedObject.AllObj;
import sharedObject.AllObjList;
import sharedObject.Renderable;
import logic.Hitbox;
import java.util.Random;

import item.Ball;
import item.BlueBall;
import item.BrownBone;
import item.Heart;
import item.Item;
import item.OrangeBall;

public class Ghost extends Character implements Renderable {
	
	private boolean is_visible, is_destroyed;
	private static final double W = 178, H=216;
	private static final double MAX_SPEED = 5;
	private static final double MIN_SPEED = 0.2;
	
	
	public static final double DAMAGE = 0.5;
	private static final Image GHOST_IMAGE_LEFT = new Image("file:res/ghostL.png");
	private static final Image GHOST_IMAGE_Right = new Image("file:res/ghostR.png");
	private Image ghostIMG = GHOST_IMAGE_LEFT;
	
	private Hitbox hitbox = new Hitbox();
	
	private double width=W;
	private double height=H;
	private double speed;

	private boolean isLeft;
	
	
	public Ghost(int z) {
		super(0, 0, z);
		x=Math.random()*1200;
		y=Math.random()*900;
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

//	@Override
//	public void takeDamageBy(Obj obj) {
//		if(obj instanceof Item && ((Item)obj).getHitbox().isOverlapping(hitbox)) { 
//			
//			
//			if(!(obj instanceof Heart)) {
//				Item item = (Item) obj;
//				hp.decrease(item.getDamage());
//				AllObjList.getItemsList().remove(item);
//			}else {
//				//จัดการกับ hp ของผีเวลาโดนหัวใจ
//			}
//		}
//	}
	
	@Override
	public void takeDamageBy(Obj obj) {
		if(obj instanceof Item && ((Item)obj).getHitbox().isOverlapping(hitbox)) { 
			if(!(obj instanceof Heart)) {
				Item item = (Item) obj;
				if(item instanceof Ball) {
					if(item instanceof BlueBall) changeSpeed(((BlueBall)item).CHANGE_SPEED);
					else if(item instanceof OrangeBall) changeSpeed(((OrangeBall)item).CHANGE_SPEED);
				}
				hp.decrease(item.getDamage());
				AllObjList.getItemsList().remove(item);
			}else {}
		}
	}

	public double getHpValue() {
		return hp.getHp();
	}

	public Object getHp() {
		return hp;
	}
	
	public void changeSpeed(double x) {
		speed=speed+x;
		speed=speed<MIN_SPEED?MIN_SPEED:speed;
		speed=speed>MAX_SPEED?MAX_SPEED:speed;
	}

}
