package character;

import SharedObject.IRenderable;
import entity.CollidableEntity;
import javafx.scene.canvas.GraphicsContext;
import others.Obj;

public abstract class Character extends Obj implements IRenderable {

	protected Hp hp;

	public Character(double x, double y, double z) {
		super(x, y, z);
	}
	
	public abstract void takeDamageBy(Obj obj);

	


}
