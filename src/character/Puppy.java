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
	private Rectangle hitbox;
	private Rectangle hitboxHead;
	private Rectangle hitboxFeet;
	private double width;
	private double height;
	
	private boolean isJumping,isGoLeft;
	
	
	
	public Puppy(double posX, double posY, double width, double height) {
		super(posX, posY);
		this.width = width;
		this.height = height;
		hitbox = new Rectangle(new Point(posX, posY), new Point(posX+width, posY+height));
		hitboxHead = new Rectangle(new Point(posX, posY), new Point(posX+width, posY+height/2));
		hitboxFeet = new Rectangle(new Point(posX, posY+height/2), new Point(posX+width, posY+height));

	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	@Override 
	public void update() {
		super.update();
		hitbox.getTopLeft().setX(getPosX());
		hitbox.getTopLeft().setY(getPosY());
		hitbox.getBottomRight().setX(getPosX()+width);
		hitbox.getBottomRight().setY(getPosY()+height);
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
