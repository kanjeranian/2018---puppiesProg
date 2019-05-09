package character;

import constant.Img;
import javafx.scene.image.Image;

public class Puppy2 extends Puppy {
	
	private static final Image DOG_IMAGE_LEFT = Img.pup2L;
	private static final Image DOG_IMAGE_RIGHT = Img.pup2R;

	public Puppy2(double x, double y, int z) {
		super(x, y, z, DOG_IMAGE_RIGHT, 2);
	}
	


}
