package item;

import javafx.scene.image.Image;

public abstract class Ball extends Item{
	
	private static final double DAMAGE = 1.5;
	
	public Ball(double x, double y, double z, Image itemImage,
			boolean is_visible, boolean is_destroy, boolean goLeft) {
		
			super(x, y, z, itemImage, DAMAGE, is_visible, is_destroy, goLeft);
	}
	
	
	
	

}
