package character;



import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.PhysicsObjects;
import logic.Point;
import logic.Rectangle;
import others.Block;

public class Puppy extends PhysicsObjects {
	
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
	
	
	public Puppy(double x, double y, double width, double height) {
		super(x, y);
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
	
//	@Override 
	public void update() {
		super.update(this); //update physics object
		updateAllHitbox(getX(), getY(), width, height);
	}
		
	public void jump() {
		if (!isJumping) {
			accelerate(0, -20); //กระโดด acc ต้องชนะ gravity
			isJumping=true;
		}
	}
	
	public void goLeft() {
		for (Rectangle r:blocks.getBlock()) {
			if(hitboxLeft.isOverlapping(r)) return;
		}
		setX(getX()-2);
	}
	
	public void goRight() {
		for (Rectangle r:blocks.getBlock()) {
			if(hitboxRight.isOverlapping(r)) return;
		}
		setX(getX()+2);
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

	
	public void render(GraphicsContext gc) {
		gc.drawImage(dogIMG, getX(), getY());
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
	
	
}
