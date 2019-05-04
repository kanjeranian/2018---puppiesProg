package others;

import java.util.ArrayList;

import logic.Point;
import logic.Rectangle;

public class Block {
	private ArrayList<Rectangle> block = new ArrayList<>(); 
	
	public Block() {
		block.add(new Rectangle(new Point(827,139)));
    	block.add(new Rectangle(new Point(508,206)));
    	block.add(new Rectangle(new Point(0,240)));
    	block.add(new Rectangle(new Point(1017,308)));
    	block.add(new Rectangle(new Point(269,367)));
    	block.add(new Rectangle(new Point(769,478)));
    	block.add(new Rectangle(new Point(59,537)));
    	block.add(new Rectangle(new Point(1051,622)));
    	block.add(new Rectangle(new Point(515,605)));
    	block.add(new Rectangle(new Point(278,710)));
    	block.add(new Rectangle(new Point(800,743)));
    	block.add(new Rectangle(new Point(0,841), new Point(1200,900)));
	}

	public ArrayList<Rectangle> getBlock() {
		return block;
	}

}
