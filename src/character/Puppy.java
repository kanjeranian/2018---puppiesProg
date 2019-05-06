package character;



import java.util.ArrayList;

import SharedObject.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.PhysicsObjects;
import logic.Point;
import logic.Hitbox;
import others.Block;

public class Puppy extends PhysicsObjects implements IRenderable,Fightable {
	
	private double z;
	private boolean is_visible, is_destroyed;
	
	private static final Image DOG_IMAGE_LEFT = new Image("file:res/pom1.png");
	private static final Image DOG_IMAGE_RIGHT = new Image("file:res/pom12.png");
	private static final Image DOG_IMAGE_LEFT_DEAD = new Image("file:res/pomLeftDead.png");
	private static final Image DOG_IMAGE_RIGHT_DEAD = new Image("file:res/pomRightDead.png");

	private Image dogIMG = DOG_IMAGE_RIGHT; //เอาไว้เลือกว่าจะใช้ left หรือ right
	
	private Hitbox hitbox = new Hitbox();
	private Hitbox hitboxHead = new Hitbox();
	private Hitbox hitboxFeet = new Hitbox();
	private Hitbox hitboxLeft = new Hitbox();
	private Hitbox hitboxRight = new Hitbox();
	
	private double width;
	private double height;
	
    private ArrayList<Hitbox> blocks = Block.getBlocks();    
	
    private boolean isJumping,isGoLeft,isCollide,deadLeft;
	private boolean firstDead = true;
	
	private Hp hp;
	
	
	public Puppy(double x, double y, double width, double height,int z) {
		super(x, y);
		this.z=z;
		hp = new Hp(x-4,y-36,z+0.5);
		
		this.width = width;
		this.height = height;
		
		updateAllHitbox(x, y, width, height);
		hitbox = new Hitbox(new Point(x, y), new Point(x+width, y+height));
		hitboxHead = new Hitbox(new Point(x, y), new Point(x+width, y+height/5*4));
		hitboxFeet = new Hitbox(new Point(x, y+height/5*4), new Point(x+width, y+height));
		hitboxLeft = new Hitbox(new Point(x, y), new Point(x+10, y+height-20));
		hitboxRight = new Hitbox(new Point(x+width-10, y), new Point(x+width, y+height-20));
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public Hitbox getHitboxHead() {
		return hitboxHead;
	}


	public Hitbox getHitboxFeet() {
		return hitboxFeet;
	}

	public void updateAllHitbox(double x,double y,double width, double height) {
		hitbox.setRectangle(x, y, width, height);
		hitboxHead.setRectangle(x, y, width, height/2);
		hitboxFeet.setRectangle(x, y+height/2, width, height/2);
		hitboxLeft.setRectangle(x, y, 10, height-20);
		hitboxRight.setRectangle(x+width-10, y, 10, height-20);
	}
	
	public void checkForUpdate(boolean goUp,boolean goLeft, boolean goRight) {
		if(goUp) 	jump();
		if(goLeft) 	goLeft();
		if(goRight) goRight();

		for (Hitbox r: blocks) {
			if(hitbox.isOverlapping(r)) {
				if(hitboxHead.isOverlapping(r)) onCollideTop();
				if(hitboxFeet.isOverlapping(r)) onCollideDown();	
			}	
		}	
	}
	
	public void update(boolean goUp,boolean goLeft, boolean goRight) {
		if(hp.getHp()>0) {
			checkForUpdate(goUp,goLeft,goRight); 
			super.update(this); //update physics object
			updateAllHitbox(getX(), getY(), width, height);
			hp.setPoint(getX()+3,getY()-36);	
			return;
		}
		if(firstDead) { 
			deadLeft=goLeft;
			firstDead = false;
		}
		dogIMG = deadLeft? DOG_IMAGE_LEFT_DEAD:DOG_IMAGE_RIGHT_DEAD;
	}
	
	public boolean wasHauntedBy(Ghost ghost) {
		if(hitbox.isOverlapping(ghost.getHitbox())){
			return true;
		}
		return false;
	}
	
	
		
	public void jump() {
		if (!isJumping) {
			accelerate(0, -20); //กระโดด acc ต้องชนะ gravity
			isJumping=true;
		}
	}
	
	public void goLeft() {
		dogIMG = DOG_IMAGE_LEFT;
		for (Hitbox r:blocks) {
			if(hitboxLeft.isOverlapping(r)) return;
		}
		setX(getX()-2.5);
		isGoLeft=true;
	}
	
	public void goRight() {
		dogIMG = DOG_IMAGE_RIGHT;
		for (Hitbox r:blocks) {
			if(hitboxRight.isOverlapping(r)) return;
		}
		setX(getX()+2.5);
		isGoLeft=false;
	}
	
	public void onCollideTop() {
		setSpeedY(getSpeedY()>0?getSpeedY():0);
		setSpeedX(0);
		
	}
	
	public void onCollideDown() {
		setSpeedY(getSpeedY()<0?getSpeedY():0);
		isJumping=false;

	}
	
	public void onCollideSide() {
		setSpeedX(0);
	}

	
	public void setDogIMG(boolean goLeft) {
		if(goLeft) { 
			dogIMG = DOG_IMAGE_LEFT;
			System.out.println("left");
			return;
		}
		System.out.println("Right");
		dogIMG = DOG_IMAGE_RIGHT;
	}

	public boolean getIscollide() {
		return isCollide;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public double getZ() {
		return z;
	}

	@Override
	public void draw(GraphicsContext gc) { //same as render
		gc.drawImage(dogIMG, getX(), getY());
		hp.draw(gc,(IRenderable) this);
	}

	@Override
	public boolean isDestroyed() {
		return is_destroyed;
	}

	@Override
	public boolean isVisible() {
		return is_visible;
	}

	@Override
	public void destroy(Fightable target) {
		// ยิงอาวุธ 
		
	}

	@Override
	public void wasDestroyed() {
		// TODO Auto-generated method stub
		hp.decrease(0.08);
	}
	

	
	
}
