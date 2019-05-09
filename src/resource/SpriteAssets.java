package resource;

import java.awt.image.BufferedImage;

public class SpriteAssets {
	
	private static final int PUPPY_WIDTH = 103, PUPPY_HEIGHT = 120;
	
	public static BufferedImage[] puppy1_L, puppy1_R, puppy2_L, puppy2_R, greenBone, brownBone, blueBall, orangeBall, gift, heart;
	
	public static void loadResource() {
		SpriteSheet puppy1_LSheet = new SpriteSheet(ImageLoader.loadImage("new/puppy1_L_walk.png"));
		SpriteSheet puppy1_RSheet = new SpriteSheet(ImageLoader.loadImage("new/puppy1_R_walk.png"));
		SpriteSheet puppy2_LSheet = new SpriteSheet(ImageLoader.loadImage("new/puppy2_L_walk.png"));
		SpriteSheet puppy2_RSheet = new SpriteSheet(ImageLoader.loadImage("new/puppy2_R_walk.png"));

		puppy1_L = new BufferedImage[4];
		
		puppy1_L[0] = puppy1_LSheet.crop(0, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		puppy1_L[1] = puppy1_LSheet.crop(PUPPY_WIDTH * 1, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		puppy1_L[2] = puppy1_LSheet.crop(PUPPY_WIDTH * 2, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		puppy1_L[3] = puppy1_LSheet.crop(PUPPY_WIDTH * 3, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		
		puppy1_R = new BufferedImage[4];
		
		puppy1_R[0] = puppy1_RSheet.crop(0, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		puppy1_R[1] = puppy1_RSheet.crop(PUPPY_WIDTH * 1, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		puppy1_R[2] = puppy1_RSheet.crop(PUPPY_WIDTH * 2, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		puppy1_R[3] = puppy1_RSheet.crop(PUPPY_WIDTH * 3, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		
		puppy2_L = new BufferedImage[4];
		
		puppy2_L[0] = puppy2_LSheet.crop(0, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		puppy2_L[1] = puppy2_LSheet.crop(PUPPY_WIDTH * 1, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		puppy2_L[2] = puppy2_LSheet.crop(PUPPY_WIDTH * 2, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		puppy2_L[3] = puppy2_LSheet.crop(PUPPY_WIDTH * 3, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		
		puppy2_R = new BufferedImage[4];
		
		puppy2_R[0] = puppy2_RSheet.crop(0, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		puppy2_R[1] = puppy2_RSheet.crop(PUPPY_WIDTH * 1, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		puppy2_R[2] = puppy2_RSheet.crop(PUPPY_WIDTH * 2, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
		puppy2_R[3] = puppy2_RSheet.crop(PUPPY_WIDTH * 3, 0, PUPPY_WIDTH, PUPPY_HEIGHT);
	}

}
