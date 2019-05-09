package item;

import constant.Img;
import javafx.scene.image.Image;

public class Heart extends Item{
	
	public static final double DAMAGE = -5;

	public Heart(double x, double y, double z, 
			boolean is_visible, boolean is_destroy,
			boolean goLeft) {
		super(x, y, z, Img.heart, DAMAGE, is_visible, is_destroy, goLeft);
	}

}
