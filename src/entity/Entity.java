package entity;

public abstract class Entity {
	
	protected double x, y;
	protected int z;
	protected boolean visible, spawned;
	
	protected Entity() {
		visible = true;
		spawned = true;
	}

	public double getZ() {
		return z;
	}

	public boolean isVisible() {
		return visible;
	}

	public boolean isSpawned() {
		return spawned;
	}

	

}
