package character;



import SharedObject.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.PhysicsObjects;
import logic.Point;
import logic.Rectangle;
import others.Block;

public class Puppy extends PhysicsObjects implements IRenderable {
	
	private double z;
	private boolean is_visible, is_destroyed;
	
	private static final Image DOG_IMAGE_LEFT = new Image("file:res/pom1.png");
	private static final Image DOG_IMAGE_RIGHT = new Image("file:res/pom12.png");
	private Image dogIMG = DOG_IMAGE_RIGHT; //เอาไว้เลือกว่าจะใช้ left หรือ right
	
	private Rectangle hitbox = new Rectangle(new Point(0, 0));
	private Rectangle hitboxHead = new Rectangle(new Point(0, 0));
	private Rectangle hitboxFeet = new Rectangle(new Point(0, 0));
	private Rectangle hitboxLeft = new Rectangle(new Point(0, 0));
	private Rectangle hitboxRight = new Rectangle(new Point(0, 0));
	
	private double width;
	private double height;
	
	private Block blocks = new Block();
	
	private boolean isJumping,isGoLeft,isCollide;
	
	private Hp hp;
	
	
	public Puppy(double x, double y, double width, double height,int z) {
		super(x, y);
		this.z=z;
		hp = new Hp(x-4,y-36,z+0.5);
		
		this.width = width;
		this.height = height;
		
		updateAllHitbox(x, y, width, height);
		hitbox = new Rectangle(new Point(x, y), new Point(x+width, y+height));
		hitboxHead = new Rectangle(new Point(x, y), new Point(x+width, y+height/5*4));
		hitboxFeet = new Rectangle(new Point(x, y+height/5*4), new Point(x+width, y+height));
		hitboxLeft = new Rectangle(new Point(x, y), new Point(x+10, y+height-20));
		hitboxRight = new Rectangle(new Point(x+width-10, y), new Point(x+width, y+height-20));
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	public Rectangle getHitboxHead() {
		return hitboxHead;
	}


	public Rectangle getHitboxFeet() {
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

		for (Rectangle r: blocks.getBlock()) {
			if(hitbox.isOverlapping(r)) {
				if(hitboxHead.isOverlapping(r)) onCollideTop();
				if(hitboxFeet.isOverlapping(r)) onCollideDown();	
			}	
		}	
	}
	
	public void update(boolean goUp,boolean goLeft, boolean goRight) {
		checkForUpdate(goUp,goLeft,goRight);
		super.update(this); //update physics object
		updateAllHitbox(getX(), getY(), width, height);
		hp.setPoint(getX()+3,getY()-36);
//		if(goLeft) hp.setPoint(getX()+8,getY()-36);
//		else {
//			hp.setPoint(getX()+13,getY()-36);
//		}
	}
		
	public void jump() {
		if (!isJumping) {
			accelerate(0, -20); //กระโดด acc ต้องชนะ gravity
			isJumping=true;
		}
	}
	
	public void goLeft() {
		dogIMG = DOG_IMAGE_LEFT;
		for (Rectangle r:blocks.getBlock()) {
			if(hitboxLeft.isOverlapping(r)) return;
		}
		setX(getX()-2.5);
		isGoLeft=true;
	}
	
	public void goRight() {
		dogIMG = DOG_IMAGE_RIGHT;
		for (Rectangle r:blocks.getBlock()) {
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
	

	
	
}
