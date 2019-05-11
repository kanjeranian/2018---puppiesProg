package item;

import constant.Img;
import javafx.scene.image.Image;

public class BrownBone extends Bone {
	
	public static final double DAMAGE = 10;

	public BrownBone(double x, double y, double z, boolean is_visible,
			boolean is_destroy, boolean goLeft) {
		super(x, y, z, DAMAGE, Img.brownBone, is_visible, is_destroy, goLeft);
	}

}
