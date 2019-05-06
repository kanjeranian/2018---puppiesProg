package item;

import SharedObject.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Hitbox;

public abstract class Item implements IRenderable {
	private double x,y,z,width,height;
	private Hitbox hitbox=new Hitbox();
	private Image itemIMG;
	private double power; //พลังในการทำลาย
	private boolean is_visible, is_destroyed,goLeft;
	
	public Item(double x,double y,double z,
			double width,double height,
			String imgAddress,
			double power,
			boolean is_visible,boolean is_destroy,boolean goLeft) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.width=width;
		this.height=height;
		this.hitbox = new Hitbox(x,y,width,height);
		itemIMG = new Image(imgAddress);
		this.is_visible = is_visible;
		this.is_destroyed = is_destroy;
		this.goLeft = goLeft;
	}

	@Override
	public double getZ() {
		return z;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(itemIMG,x,y);
	}

	@Override
	public boolean isDestroyed() {
		return is_destroyed;
	}

	@Override
	public boolean isVisible() {
		return is_visible;
	}
	
	
	

}
