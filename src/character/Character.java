package character;

import javafx.scene.canvas.GraphicsContext;
import others.Obj;
import sharedObject.Renderable;

public abstract class Character extends Obj implements Renderable {

	protected Hp hp;

	public Character(double x, double y, double z) {
		super(x, y, z);
	}
	
	public abstract void takeDamageBy(Obj obj);

	


}
