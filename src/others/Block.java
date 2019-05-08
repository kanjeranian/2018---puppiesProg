package others;

import java.util.ArrayList;

import SharedObject.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.Point;
import logic.Hitbox;

public class Block implements Renderable{
	
	private double z;
	private boolean is_visible, is_destroyed;

	private static final Block instance = new Block();
	private static final double WIDTH = 149,HEIGHT=34;
	private ArrayList<Hitbox> blocks = new ArrayList<>(); 
	
	private Block() {
		// 11 อันนี้คือตำแหน่งเริ่มต้นของ แต่ละ platform สามารถขยับได้
		addBlock(827,139);
	   	addBlock(508,206);
	   	addBlock(0,240);
	   	addBlock(1017,308);
	   	addBlock(269,367);
	   	addBlock(769,478);
	   	addBlock(59,537);
	   	addBlock(1051,622);
	   	addBlock(515,605);
	   	addBlock(278,710);
	   	addBlock(800,743);
	   	blocks.add(new Hitbox(new Point(0,-100), new Point(1200,0))); //top
	   	blocks.add(new Hitbox(new Point(-100,-100), new Point(0,900))); //left
	   	blocks.add(new Hitbox(new Point(1200,0), new Point(1300,900))); //right
	   	blocks.add(new Hitbox(new Point(0,841), new Point(1200,900))); //อันนี้คือพื้น
    	
	}
	
	private void addBlock(double x,double y) {
		blocks.add(new Hitbox(x, y, WIDTH, HEIGHT));
	}
	
	public static Block getBlockInstance() {
		return instance;
	}
	
	public static ArrayList<Hitbox> getBlocks() {
		return  instance.blocks;
	}


	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.rgb(43,51,51));
		for(int i=0; i<instance.blocks.size()-1;i++) {
			gc.fillRect(instance.blocks.get(i).getX(), instance.blocks.get(i).getY(),
					WIDTH, HEIGHT);
		}
	}

	@Override
	public boolean isDestroyed() {
		return is_destroyed;
	}

	@Override
	public boolean isVisible() {
		return is_visible;
	}
	
	

}
