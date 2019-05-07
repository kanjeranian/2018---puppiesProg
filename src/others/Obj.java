package others;

import SharedObject.IRenderable;
import character.Character;
import character.Hp;

public abstract class Obj implements IRenderable{

	protected double x, y, z;
	protected boolean is_visible = true, is_destroyed = true;

	public Obj(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public boolean isDestroyed() {
		return is_destroyed;
	}

	@Override
	public double getZ() {
		return z;
	}

	@Override
	public boolean isVisible() {
		return is_visible;
	}
	
}
