package SharedObject;

import java.util.ArrayList;

import character.Ghost;
import character.Puppy1;
import character.Puppy2;
import constant.Img;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import others.Block;


public class AllObj implements Renderable{
	
	public static final AllObj ALL = new AllObj();
	private static final double W = 1200, H = 900;

	private static boolean goUp1, goRight1, goLeft1, attacking1;
	private static boolean goUp2, goRight2, goLeft2, attacking2;
	private ArrayList<Hitbox> blocks = Block.getBlocks();    
	   private Block allBlocks = Block.getBlockInstance();
	
	private static Puppy1 player1 = new Puppy1(W/2, H/2,1);
	private static Puppy2 player2 = new Puppy2(W/2, H/2,2);

	private static Ghost ghost1 = new Ghost(3);    


	private AllObj() {}
	
	public static void update() {
		player1.update(goUp1,goLeft1,goRight1,attacking1);
		player2.update(goUp2,goLeft2,goRight2,attacking2);		
		ghost1.update(player1);
		player1.takeDamageBy(ghost1);
		player2.takeDamageBy(ghost1);
	}
	
	@Override
	public double getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(Img.bg, 0, 0);	
		allBlocks.draw(gc);
		player1.draw(gc);
		player2.draw(gc);
		
		ghost1.draw(gc);
//		drawHitbox();
		
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setKeyStatus(boolean goUp1, boolean goLeft1,boolean goRight1, boolean attacking1, boolean goUp2, boolean goLeft2,boolean goRight2, boolean attacking2) {
		this.goUp1 = goUp1;
		this.goRight1 = goRight1;
		this.goLeft1 = goLeft1;
		this.attacking1 = attacking1;

		this.goUp2 = goUp2;
		this.goRight2 = goRight2;
		this.goLeft2 = goLeft2;
		this.attacking2 = attacking2;
	}

}
