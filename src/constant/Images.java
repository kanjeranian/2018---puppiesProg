package constant;

import javafx.scene.image.Image;

public class Images {
	//Puppies
	public static final double WIDTH_PUP = 103, HEIGHT_PUP=120;
	public static final Image pup1L = new Image(ClassLoader.getSystemResource("pup1Left.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);
	public static final Image pup1R = new Image(ClassLoader.getSystemResource("pup1Right.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);
	public static final Image pup2L = new Image(ClassLoader.getSystemResource("pup2Left.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);
	public static final Image pup2R = new Image(ClassLoader.getSystemResource("pup2Right.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);
	
	//Ghosts
	public static final double WIDTH_GHOST = 178, HEIGHT_GHOST= 216;
	public static final Image ghostL = new Image(ClassLoader.getSystemResource("ghostL.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);
	public static final Image ghostR = new Image(ClassLoader.getSystemResource("ghostR.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);

	
	
}

























//new Image(ClassLoader.getSystemResource("Images/Logo.png").toString(),50,50,true,false);
