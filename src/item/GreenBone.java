package item;

import constant.Img;
import javafx.scene.image.Image;

public class GreenBone extends Bone {
	
	private static final double DAMAGE = 5;

	public GreenBone(double x, double y, double z, boolean is_visible,
			boolean is_destroy, boolean goLeft) {
		super(x, y, z, DAMAGE, Img.greenBone, is_visible, is_destroy, goLeft);
	}

}
