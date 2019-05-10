package item;

import character.Puppy;
import constant.Img;
import javafx.scene.image.Image;

public class Heart extends Item{
	
	public static final double DAMAGE = -1;
	private Puppy puppy;


	public Heart(double x, double y, double z, 
			boolean is_visible, boolean is_destroy,
			boolean goLeft,Puppy puppy) {
		super(x, y, z, Img.heart, DAMAGE, is_visible, is_destroy, goLeft);
		this.puppy = puppy;
	}
	
	public Puppy getPuppy() {
		return puppy;
	}

}
