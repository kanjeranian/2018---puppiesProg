package character;

import java.util.ArrayList;

import SharedObject.IRenderable;
import constant.Img;
import item.BlueBall;
import item.Item;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Point;
import logic.Hitbox;
import others.Block;

public class Puppy implements IRenderable, Fightable {

	protected static final double WIDTH = Img.puppy.getWidth();
	protected static final double HEIGHT = Img.puppy.getHeight();
	protected static final double GRAVITY = 3;
	protected static final ArrayList<Hitbox> blocks = Block.getBlocks();

	protected double x, y, z;
	protected double speedX = 0;
	protected double speedY = 0;

	protected boolean is_visible, is_destroyed;

	protected Image DOG_IMAGE_LEFT;
	protected Image DOG_IMAGE_RIGHT;
	protected Image dogIMG; // เอาไว้เลือกว่าจะใช้ left หรือ right

	protected Hitbox hitbox = new Hitbox();
	protected Hitbox hitboxHead = new Hitbox();
	protected Hitbox hitboxFeet = new Hitbox();
	protected Hitbox hitboxLeft = new Hitbox();
	protected Hitbox hitboxRight = new Hitbox();

	protected boolean isJumping, isGoLeft, isCollide, deadLeft, attackPress, attackTrigger;
	protected boolean firstDead = true;

	protected Hp hp;
	protected Item item = new BlueBall(x / 2, y / 2, z + 0.1, true, false, isGoLeft);
	protected ArrayList<Item> releaseItem = new ArrayList<>();

	public Puppy(double x, double y, int z,Image dogImageL, Image dogImageR, Image dogImage) {
		this.x = x;
		this.y = y;
		this.z = z;
		DOG_IMAGE_LEFT = dogImageL;
		DOG_IMAGE_RIGHT = dogImageR;
		dogIMG = dogImage;
		

		hp = new Hp(x - 4, y - 36, z + 0.5);

		updateAllHitbox(x, y);
	}
	

	public Hitbox getHitbox() {
		return hitbox;
	}

	public Hitbox getHitboxHead() {
		return hitboxHead;
	}

	public Hitbox getHitboxFeet() {
		return hitboxFeet;
	}

	public void updateAllHitbox(double x, double y) {
		hitbox.setRectangle(x, y, WIDTH, HEIGHT);
		hitboxHead.setRectangle(x, y, WIDTH, HEIGHT / 2);
		hitboxFeet.setRectangle(x, y + HEIGHT / 2, WIDTH, HEIGHT / 2);
		hitboxLeft.setRectangle(x, y, 10, HEIGHT - 20);
		hitboxRight.setRectangle(x + WIDTH - 10, y, 10, HEIGHT - 20);
	}

	public void checkForUpdate(boolean goUp, boolean goLeft, boolean goRight) {
		if (goUp)
			jump();
		if (goLeft)
			goLeft();
		if (goRight)
			goRight();

		for (Hitbox r : blocks) {
			if (hitbox.isOverlapping(r)) {
				if (hitboxHead.isOverlapping(r))
					onCollideTop();
				if (hitboxFeet.isOverlapping(r))
					onCollideDown();
			}
		}
	}

	public void update(boolean goUp, boolean goLeft, boolean goRight, boolean attacking) {
		if (hp.getHp() > 0) {
			checkForUpdate(goUp, goLeft, goRight);
			if (attacking) {
				attack();
			} else {
				attackPress = false;
			}
			move();
			accelerate(0, GRAVITY);

			updateAllHitbox(x, y);
			hp.setPoint(x + 3, y - 36);
			for (Item i : releaseItem) {
				i.update();
			}
			return;
		}
		if (firstDead) {
			deadLeft = goLeft;
			firstDead = false;
		}
		dogIMG = deadLeft ? Img.pupDeadL : Img.pupDeadR;
	}

	public void attack() {
		if (!attackPress) {
			if (item == null)
				return;
			Item i = null;
			if (item instanceof BlueBall)
				i = new BlueBall(x + WIDTH / 2, y + HEIGHT / 2, z + 0.1, true, false, isGoLeft);
			releaseItem.add((Item) i);
		}
		attackPress = true;
	}

	public boolean wasHauntedBy(Ghost ghost) {
		if (hitbox.isOverlapping(ghost.getHitbox())) {
			return true;
		}
		return false;
	}

	public void jump() {
		if (!isJumping) {
			accelerate(0, -20); // กระโดด acc ต้องชนะ gravity
			isJumping = true;
		}
	}

	public void goLeft() {
		dogIMG = DOG_IMAGE_LEFT;
		for (Hitbox r : blocks) {
			if (hitboxLeft.isOverlapping(r))
				return;
		}
		x -= 2.5;
		isGoLeft = true;
	}

	public void goRight() {
		dogIMG = DOG_IMAGE_RIGHT;
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

	}

	public void onCollideDown() {
		speedY = speedY < 0 ? speedY : 0;
		isJumping = false;

	}

	public void onCollideSide() {
		speedX = 0;
	}

	public void setDogIMG(boolean goLeft) {
		if (goLeft) {
			dogIMG = DOG_IMAGE_LEFT;
			System.out.println("left");
			return;
		}
		System.out.println("Right");
		dogIMG = DOG_IMAGE_RIGHT;
	}

	public boolean getIscollide() {
		return isCollide;
	}

	@Override
	public double getZ() {
		return z;
	}

	@Override
	public void draw(GraphicsContext gc) { // same as render
		gc.drawImage(dogIMG, x, y);
		hp.draw(gc, (IRenderable) this);
		for (Item i : releaseItem) {
			i.draw(gc);
		}
	}

	@Override
	public boolean isDestroyed() {
		return is_destroyed;
	}

	@Override
	public boolean isVisible() {
		return is_visible;
	}

	@Override
	public void destroy(Fightable target) {
		// ยิงอาวุธ

	}

	@Override
	public void wasDestroyed() {
		// TODO Auto-generated method stub
//		hp.decrease(0.08);
		hp.decrease(5);
	}

	// function from physics objects
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

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}
