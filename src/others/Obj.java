package others;

import SharedObject.Renderable;
import character.Character;
import character.Hp;

public abstract class Obj implements Renderable{

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
	
	public double distanceTo(Obj other) {
		return Math.sqrt((x-other.x)*(x-other.x)+(y-other.y)*(y-other.y));
	}
	
}
