package item;

import constant.Img;

public class OrangeBall extends Ball{
	
	public OrangeBall(double x, double y, double z, 
			boolean is_visible, boolean is_destroy,
			boolean goLeft) {
		super(x, y, z, Img.orangeBall, 
				is_visible, is_destroy, goLeft);
		
	}

}
