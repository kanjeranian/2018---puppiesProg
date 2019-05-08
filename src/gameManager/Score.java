package gameManager;

import SharedObject.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Score implements Renderable{
	private static int score=0;
	double x = 20, y=881;
	public Score() {}
	public static void increasing() {
		score+=1;
	}
	@Override
	public void draw(GraphicsContext gc) {
		String text= "SCORE : "+score;
		gc.setFill(Color.rgb(201, 199, 197));
		gc.setFont(Font.font(25));
		gc.fillText(text, x, y);
		
	}
	@Override
	public boolean isDestroyed() {
		return false;
	}
	@Override
	public boolean isVisible() {
		return true;
	}
	
	
	
}
