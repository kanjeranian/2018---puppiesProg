package character;

import javafx.scene.image.Image;
import logic.Point;
import logic.Rectangle;

public class Ghost {
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
	
	public void update() {
		moveToPup();
	}
	
	public void moveToPup() {
		
	}

}
