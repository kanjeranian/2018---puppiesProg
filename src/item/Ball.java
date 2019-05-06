package item;

public abstract class Ball extends Item {
	
	private static final double WIDTH = 44.12;
	private static final double HEIGHT = 43.99;
	private static final double POWER = 3;
	
	public Ball(double x, double y, double z, 
			String imgAddress,
			boolean is_visible, boolean is_destroy, boolean goLeft) {
		
		super(x, y, z, WIDTH, HEIGHT, imgAddress, POWER, is_visible, is_destroy, goLeft);
	}
	
	
	
	

}
