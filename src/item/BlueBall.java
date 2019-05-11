package item;

import constant.Img;

public class BlueBall extends Ball{
	
	public static final double CHANGE_SPEED = -0.1;
	
	public BlueBall(double x, double y, double z, 
			boolean is_visible, boolean is_destroy,
			boolean goLeft) {
		super(x, y, z, Img.blueBall, 
				is_visible, is_destroy, goLeft);
		
	}

}
