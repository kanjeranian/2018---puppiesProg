package character;

import SharedObject.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.Hitbox;

public class Hp implements IRenderable {
	
	private double z;
	private double x,y;
	private static final double W = 89, H=19;
	private boolean is_visible = true, is_destroyed=false;
	
	private static final Color GHOST_BLOOD = Color.rgb(209,40,84);
	private static final Color PUPPY_BLOOD = Color.rgb(43,127,95);
	private Color blood;
	
	private double hp;
	
	
	Hp(double x,double y,double z){
		this.x=x;
		this.y=y;
		this.z=z;
		hp=90;
	}


	@Override
	public double getZ() {
		return z;
	}


	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.rgb(201, 199, 197));
		gc.fillRoundRect(x, y, W, H, 20, 20);
		gc.setFill(blood);
		gc.fillRoundRect(x, y, W*hp/100, H, 20, 20);

	}
	
	public void draw(GraphicsContext gc,IRenderable iRenderable) {
		blood = iRenderable instanceof Ghost?GHOST_BLOOD : PUPPY_BLOOD;
		draw(gc);
		
	}


	@Override
	public boolean isDestroyed() {
		return is_destroyed;
	}


	@Override
	public boolean isVisible() {
		return is_visible;
	}
	
	public void update() {
		
	}
	
	public void setPoint(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	public void decrease(double x) {
		hp-=x;
//		hp=hp<0?0:x;
	}

	
	public double getHp() {
		return hp;
	}


	public void setHp(double hp) {
		this.hp = hp;
	}
	
	
	

	
}
