package character;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import SharedObject.AllObj;
import SharedObject.AllObjList;
import SharedObject.Renderable;
import constant.Img;
import item.BlueBall;
import item.BrownBone;
import item.Gift;
import item.GreenBone;
import item.Heart;
import item.Item;
import item.OrangeBall;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Point;
import logic.Hitbox;
import others.Block;
import others.Obj;
import resource.Animation;
import resource.SpriteAssets;

public class Puppy extends Character implements Renderable{

	protected static final double WIDTH = Img.puppy.getWidth();
	protected static final double HEIGHT = Img.puppy.getHeight();
	protected static final double GRAVITY = 3;
	protected static final ArrayList<Hitbox> blocks = Block.getBlocks();

	protected double speedX = 0;
	protected double speedY = 0;

	protected Image dogIMG; // เอาไว้เลือกว่าจะใช้ left หรือ right

	protected Hitbox hitbox = new Hitbox();
	protected Hitbox hitboxHead = new Hitbox();
	protected Hitbox hitboxFeet = new Hitbox();
	protected Hitbox hitboxLeft = new Hitbox();
	protected Hitbox hitboxRight = new Hitbox();

	protected boolean isJumping, isGoLeft, isCollide, deadLeft, attackPress, attackTrigger;
	protected boolean firstDead = true;

	protected Item item = new BlueBall(x / 2, y / 2, z + 0.1, true, false, isGoLeft);
//	protected ArrayList<Item> releaseItem = new ArrayList<>();
	
	private Animation animLeft;
	private Animation animRight;


	public Puppy(double x, double y, double z, Image dogImage, int dogNum) {
		super(x,y,z);
		dogIMG = dogImage;
		hp = new Hp(x - 4, y - 36, z + 0.5); 
		updateAllHitbox(x, y);
		if(dogNum == 1) {
			animLeft = new Animation(500, SpriteAssets.puppy1_L);
			animRight = new Animation(500, SpriteAssets.puppy1_R);
		}
		else {
			animLeft = new Animation(500, SpriteAssets.puppy2_L);
			animRight = new Animation(500, SpriteAssets.puppy2_R);
		}
	}
	

	public void attack() {
		if (!attackPress) {
			if (item == null)
				return;
			Item i = null;
			if (item instanceof BlueBall) 	{i = new BlueBall	(x + WIDTH / 2, y + HEIGHT / 2, z + 0.1, true, false, isGoLeft);}
			if (item instanceof OrangeBall) {i = new OrangeBall	(x + WIDTH / 2, y + HEIGHT / 2, z + 0.1, true, false, isGoLeft);}
			if (item instanceof BrownBone) 	{i = new BrownBone	(x + WIDTH / 2, y + HEIGHT / 2, z + 0.1, true, false, isGoLeft);}
			if (item instanceof GreenBone) 	{i = new GreenBone	(x + WIDTH / 2, y + HEIGHT / 2, z + 0.1, true, false, isGoLeft);}
			if (item instanceof Heart) 		{i = new Heart		(x + WIDTH / 2, y + HEIGHT / 2, z + 0.1, true, false, isGoLeft, this);}
			AllObj.addToItemsList(i);
		}
		attackPress = true;
	}

	@Override
	public void takeDamageBy(Obj obj) {
		if(obj instanceof Ghost && ((Ghost)obj).getHitbox().isOverlapping(hitbox)) { 
			hp.decrease(((Ghost)obj).DAMAGE);
		}
		else if(obj instanceof Heart && 
				((Item)obj).getHitbox().isOverlapping(hitbox) &&
				((Heart)obj).getPuppy()!=this) { 
			Item item = (Item) obj;
			hp.decrease(((Heart)obj).DAMAGE);}
			AllObjList.getItemsList().remove(item);
	}

	public void jump() {
		if (!isJumping) {
			accelerate(0, -20); // กระโดด acc ต้องชนะ gravity
			isJumping = true;
		}
	}

	public void goLeft() {
		for (Hitbox r : blocks) {
			if (hitboxLeft.isOverlapping(r))
				return;
		}
		x -= 2.5;
		isGoLeft = true;
	}

	public void goRight() {
		for (Hitbox r : blocks) {
			if (hitboxRight.isOverlapping(r))
				return;
		}
		x += 2.5;
		isGoLeft = false;
	}

	public void onCollideTop() {
		speedY = speedY > 0 ? speedY : 0;
		speedX = 0;
//		System.out.println("onTop");

	}

	public void onCollideDown() {
		speedY = speedY < 0 ? speedY : 0;
		isJumping = false;
//		System.out.println("onDown");

	}

	public void onCollideSide() {
//		x+=0;
		speedY = speedY > 0 ? speedY : 0;
//		speedX = 0;
	}

//	public void setDogIMG(boolean goLeft) {
//		if (goLeft) {
//			dogIMG = DOG_IMAGE_LEFT;
//			System.out.println("left");
//			return;
//		}
//		System.out.println("Right");
//		dogIMG = DOG_IMAGE_RIGHT;
//	}

	public boolean getIscollide() {
		return isCollide;
	}

	@Override
	public void draw(GraphicsContext gc) { // same as render
		gc.drawImage(getCurrentAnimationFrame(), x, y);
		hp.draw(gc, (Renderable) this);
	}

	private Image getCurrentAnimationFrame() {
		if(!firstDead) {
			if(isGoLeft) {
				return Img.pupDeadL;
			}
			else {
				return Img.pupDeadR;
			}
		}
		if(isGoLeft) {
			return animLeft.getCurrentFrame();
		}
		else {
			return animRight.getCurrentFrame();
		}
	}

	public void accelerate(double accelerationX, double accelerationY) {
		speedX += accelerationX;
		speedY += accelerationY;
	}

	public void move() {
		x += speedX;
		if (speedY > 0) {
			for (int i = 0; i < Math.abs(speedY); i++) {
				y += 1;
				updateAllHitbox(x, y);
				for (Hitbox r : blocks) {
					if (hitboxFeet.isOverlapping(r)) {
						return;
					}
				}

			}
		} else {
			y += speedY;
		}
	}

	//hitBox, all Update, getters
	public double getX() 					{ 	return x;				}
	public double getY() 					{ 	return y;				}
	public Hitbox getHitbox() 				{ 	return hitbox; 	 		}
	public Hitbox getHitboxHead() 			{ 	return hitboxHead; 		}
	public Hitbox getHitboxFeet() 			{ 	return hitboxFeet; 		}
	
	public void updateAllHitbox(double x, double y) {
		hitbox.setRectangle(x, y, WIDTH, HEIGHT);
		hitboxHead.setRectangle(x, y, WIDTH, HEIGHT / 2);
		hitboxFeet.setRectangle(x, y + HEIGHT / 2, WIDTH, HEIGHT / 2);
		hitboxLeft.setRectangle(x, y+10, 10, HEIGHT - 20);
		hitboxRight.setRectangle(x + WIDTH - 10, y+10, 10, HEIGHT - 20);
	}
	public void checkForUpdate(boolean goUp, boolean goLeft, boolean goRight) {
		if (goUp)	 jump();
		if (goLeft)	 goLeft();
		if (goRight) goRight();
		
		for (Hitbox r : blocks) {
			if (hitbox.isOverlapping(r)) {
				if (hitboxHead.isOverlapping(r)) onCollideTop();
				if (hitboxFeet.isOverlapping(r)) onCollideDown();
			}
		}
	}
	public void update(boolean goUp, boolean goLeft, boolean goRight, boolean attacking) {
		if (hp.getHp() > 0) {
			firstDead = true;
			checkForUpdate(goUp, goLeft, goRight);
			if (attacking) { attack(); } else { attackPress = false; }
			move();
			accelerate(0, GRAVITY);
			updateAllHitbox(x, y);
			hp.setPoint(x + 3, y - 36);
//			dogIMG = goLeft? 
			return;
		}
		
		if (firstDead) {
			deadLeft = goLeft;
			firstDead = false;
		}
		dogIMG = deadLeft ? Img.pupDeadL : Img.pupDeadR;
	}
	
	public boolean isDead() {
		return hp.getHp()<0.2;
	}
	
	public void setItem(int a) {
		switch (a) {
		case 0: item = new BlueBall		(x/2, y/2, z+0.1, true, false, isGoLeft); break;
		case 1: item = new OrangeBall	(x/2, y/2, z+0.1, true, false, isGoLeft); break;
		case 2: item = new GreenBone	(x/2, y/2, z+0.1, true, false, isGoLeft); break;
		case 3: item = new BrownBone	(x/2, y/2, z+0.1, true, false, isGoLeft); break;
		case 4: item = new Heart		(x/2, y/2, z+0.1, true, false, isGoLeft, this); break;
		default:
			break;
		}
	}


}
