package character;



import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.PhysicsObjects;
import logic.Point;
import logic.Rectangle;

public class Puppy extends PhysicsObjects {
	
	private static final Image DOG_IMAGE_LEFT = new Image("file:res/pom1.png");
	private static final Image DOG_IMAGE_RIGHT = new Image("file:res/pom12.png");
	private Image dogIMG = DOG_IMAGE_RIGHT;
	private Rectangle hitbox = new Rectangle(new Point(0, 0));
	private Rectangle hitboxHead = new Rectangle(new Point(0, 0));
	private Rectangle hitboxFeet = new Rectangle(new Point(0, 0));
	private double width;
	private double height;
	
	private boolean isJumping,isGoLeft;
	
	
	
	public Puppy(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
		updateAllHitbox(x, y, width, height);
		hitbox = new Rectangle(new Point(x, y), new Point(x+width, y+height));
		hitboxHead = new Rectangle(new Point(x, y), new Point(x+width, y+height/2));
		hitboxFeet = new Rectangle(new Point(x, y+height/2), new Point(x+width, y+height));

	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	public void updateAllHitbox(double x,double y,double width, double height) {
		hitbox.setRectangle(x, y, width, height);
		hitboxHead.setRectangle(x, y, width, height/2);
		hitboxFeet.setRectangle(x, y+height/2, width, height);
	}
	
	@Override 
	public void update() {
		super.update();
		updateAllHitbox(getPosX(), getPosY(), width, height);
	}
		
	public void jump() {
		if (!isJumping) {
			accelerate(0, -20); 
			isJumping=true;
		}
	}
	
	public void onCollide() {
		
		setSpeedY(0);
		isJumping=false;
	}

	
	public void render(GraphicsContext gc) {
		gc.drawImage(dogIMG, getPosX(), getPosY());
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
	
}
