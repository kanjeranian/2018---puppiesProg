package constant;

import javafx.scene.image.Image;

public class Img {
	//Background
	public static final double WIDTH_BG = 1200, HEIGHT_BG=900;
	public static final Image bg = new Image(ClassLoader.getSystemResource("bg.png").toString(),
			WIDTH_BG,HEIGHT_BG,true,false);
	
	//Puppies
	public static final double WIDTH_PUP = 103, HEIGHT_PUP=120;
	public static final Image puppy  = new Image(ClassLoader.getSystemResource("pom1Left.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);
	public static final Image puppy2 = new Image(ClassLoader.getSystemResource("pom2Right.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);
	public static final Image pup1L  = new Image(ClassLoader.getSystemResource("pom1Left.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);
	public static final Image pup1R  = new Image(ClassLoader.getSystemResource("pom1Right.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);
	public static final Image pup2L  = new Image(ClassLoader.getSystemResource("pom2Left.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);
	public static final Image pup2R  = new Image(ClassLoader.getSystemResource("pom2Right.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);
	public static final Image pupDeadL  = new Image(ClassLoader.getSystemResource("pomLeftDead.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);
	public static final Image pupDeadR  = new Image(ClassLoader.getSystemResource("pomRightDead.png").toString(),WIDTH_PUP,HEIGHT_PUP,true,false);

	//Ghosts
	public static final double WIDTH_GHOST = 178, HEIGHT_GHOST= 216;
	public static final Image ghost = new Image(ClassLoader.getSystemResource("ghostR.png").toString(),WIDTH_GHOST,HEIGHT_GHOST,true,false);
	public static final Image ghostL = new Image(ClassLoader.getSystemResource("ghostL.png").toString(),WIDTH_GHOST,HEIGHT_GHOST,true,false);
	public static final Image ghostR = new Image(ClassLoader.getSystemResource("ghostR.png").toString(),WIDTH_GHOST,HEIGHT_GHOST,true,false);

	//Gift
	public static final double WIDTH_GIFT = 80, HEIGHT_GIFT= 72;
	public static final Image gift = new Image(ClassLoader.getSystemResource("gift.png").toString(),WIDTH_GIFT,HEIGHT_GIFT,true,false);
	
	//Heart
	public static final double WIDTH_HEART = 88, HEIGHT_HEART= 42;
	public static final Image heart = new Image(ClassLoader.getSystemResource("heart.png").toString(),WIDTH_HEART,HEIGHT_HEART,true,false);
	
	//Item
	public static final double WIDTH_BONE = 45, HEIGHT_BONE= 32;
	public static final Image greenBone = new Image(ClassLoader.getSystemResource("greenBone.png").toString(),WIDTH_BONE,HEIGHT_BONE,true,false);
	public static final Image brownBone = new Image(ClassLoader.getSystemResource("brownBone.png").toString(),WIDTH_BONE,HEIGHT_BONE,true,false);
	public static final double WIDTH_BALL = 45, HEIGHT_BALL= 32;
	public static final Image blueBall = new Image(ClassLoader.getSystemResource("blueBall.png").toString(),WIDTH_BALL,HEIGHT_BALL,true,false);
	public static final Image orangeBall = new Image(ClassLoader.getSystemResource("orangeBall.png").toString(),WIDTH_BALL,HEIGHT_BALL,true,false);

	
	
	public Img(){}
	
}



