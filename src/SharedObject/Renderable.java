package SharedObject;

import javafx.scene.canvas.GraphicsContext;

public interface Renderable {
	public double getZ();
	public void draw(GraphicsContext gc);
	public boolean isDestroyed();
	public boolean isVisible();
	
}
