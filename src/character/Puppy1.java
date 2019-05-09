package character;

import constant.Img;
import javafx.scene.image.Image;

public class Puppy1 extends Puppy {
	
	private static final Image DOG_IMAGE_LEFT = Img.pup1L;
	private static final Image DOG_IMAGE_RIGHT = Img.pup1R;

	public Puppy1(double x, double y, int z) {
		super(x, y, z, DOG_IMAGE_LEFT, 1);
	}
	


}
