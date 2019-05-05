package character;

import SharedObject.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.Rectangle;

public class Hp implements IRenderable {
	
	private double z;
	private double x,y;
	private static final double W = 89, H=19;
	private boolean is_visible, is_destroyed;
	
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
		gc.setFill(Color.rgb(43,127,95));
		gc.fillRoundRect(x, y, W*hp/100, H, 20, 20);

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

}
