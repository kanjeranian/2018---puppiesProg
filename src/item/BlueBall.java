package item;

public class BlueBall extends Ball{
	
	private static final String BLUE_BALL_IMG = "file:res/blueBall.png";

	public BlueBall(double x, double y, double z, 
			boolean is_visible, boolean is_destroy,
			boolean goLeft) {
		super(x, y, z, BLUE_BALL_IMG, 
				is_visible, is_destroy, goLeft);
		// TODO Auto-generated constructor stub
	}

}
