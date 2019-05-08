package item;

import constant.Img;

public class Gift extends Item{
	private static final double DAMAGE = 0;

	public Gift(double x, double y, double z, 
			boolean is_visible, boolean is_destroy,
			boolean goLeft) {
		super(x, y, z, Img.gift, DAMAGE, is_visible, is_destroy, goLeft);
	}
	
	@Override
	public void update(){
		
	}
}
