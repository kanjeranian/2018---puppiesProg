package item;

import javafx.scene.image.Image;

public abstract class Bone extends Item{
	
	public Bone(double x, double y, double z, double damage, Image itemImage,
			boolean is_visible, boolean is_destroy, boolean goLeft) {
		
			super(x, y, z, itemImage, damage, is_visible, is_destroy, goLeft);
	}
	
	
	
	

}
