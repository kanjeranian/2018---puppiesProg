package logic;

import character.Puppy;
import others.Block;
import java.lang.Math;

public class PhysicsObjects {
//    public static final double FRICTION = 0.99;
	public static final double GRAVITY = 3;
	private static final Block blocks = new Block(); 
	private double x;
	private double y;
	private double speedX = 0;
	private double speedY = 0;

	public PhysicsObjects(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void accelerate(double accelerationX, double accelerationY) {
		speedX += accelerationX;
		speedY += accelerationY;
	}
	
	

	public void move(Puppy puppy) {
//		double signx = Math.signum(speedX);
//		for (double i=0; Math.abs(i) < speedX; i += signx) {
//			if ()
//		}
		x += speedX;
        if(speedY>0) {
        	for (int i = 0; i < Math.abs(speedY); i++) {
        		y += 1;
        		puppy.updateAllHitbox(x, y, puppy.getWidth(), puppy.getHeight());
        		for (Rectangle r : blocks.getBlock()) {
        			if (puppy.getHitboxFeet().isOverlapping(r)) {
        				return;
        			}
        		}
        		
        	}
        }else {
        	y += speedY;
        }
	}

	public void update(Puppy puppy) {
		move(puppy);
//        speedX *= FRICTION;
//        speedY *= FRICTION;
		accelerate(0, GRAVITY); // gravity accelerates the object downwards each tick
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public double getSpeedY() {
		return speedY;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double posX) {
		this.x = posX;
	}

	public void setY(double posY) {
		this.y = posY;
	}

}
