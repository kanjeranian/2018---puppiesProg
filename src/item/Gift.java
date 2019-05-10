package item;

import java.util.Random;

import SharedObject.AllObj;
import character.Puppy;
import constant.Img;
import gameManager.Score;
import logic.Hitbox;
import logic.Point;
import others.Block;

public class Gift extends Item implements Randomable{
	private static final double DAMAGE = 0;

	public Gift() {
		super(0, 0, 1, Img.gift, DAMAGE, true, false, true);
		update();
	}
	
	@Override
	public void update(){
		Point point = randomPosition();
		x = point.getX();
		y = point.getY();
		updateHitbox();
	}
	
	public void update(Puppy puppy) {
		if(getHitbox().isOverlapping(puppy.getHitbox())) {
			puppy.setItem(new Random().nextInt(5));
//			puppy.setItem(4);
			AllObj.getGiftsList().remove(this);
			Score.increasing();
		}
	}

	@Override
	public Point randomPosition() {
		boolean ok=false;
		double randomX = Math.random()*1200, randomY = Math.random()*900;
		while(!ok) {
			randomX = Math.random()*1200;
			randomY = Math.random()*900;
			if(checkPoint(randomX, randomY)) {
				ok = true;
			}
		}
		return new Point(randomX, randomY);
	}

	@Override
	public boolean checkPoint(double x,double y) {
		Hitbox box = new Hitbox(x, y, Img.WIDTH_GIFT, Img.HEIGHT_GIFT);
		for(Hitbox block: Block.getBlocks()) {
			if(block.isOverlapping(box)) return false;
		}
		return true;
	}
	
	
}
