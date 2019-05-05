package SharedObject;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable {
	public double getZ();
	public void draw(GraphicsContext gc);
	public boolean isDestroyed();
	public boolean isVisible();
	
}
