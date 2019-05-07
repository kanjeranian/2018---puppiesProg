package item;

import SharedObject.IRenderable;
import character.Ghost;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Hitbox;
import others.Obj;

public abstract class Item extends Obj implements IRenderable {
	private Hitbox hitbox;
	private Image itemIMG;
	private double damage; //พลังในการทำลาย
	private boolean goLeft;
	
	public Item(double x,double y,double z, Image itemImage,
			double damage,boolean is_visible,boolean is_destroy,boolean goLeft) {
		super(x, y, z);
		this.itemIMG = itemImage;
		this.hitbox = new Hitbox(x,y,itemImage.getWidth(),itemImage.getHeight());
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
	
	public void update() { //ถ้าขยันก็มาเปลี่ยนให้ยิงเพิ่อนได้
		x=goLeft?x-3:x+3;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public double getDamage() {
		return damage;
	}
		
	
	
	
	

}
