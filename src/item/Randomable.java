package item;

import javafx.scene.canvas.GraphicsContext;
import logic.Point;

public interface Randomable {
		public Point randomPosition();
		public boolean checkPoint(double x, double y);
}
