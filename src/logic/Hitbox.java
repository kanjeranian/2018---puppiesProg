package logic;

public class Hitbox {

	 private Point topLeft;
	 private Point bottomRight;
	 
	public Hitbox() {
		topLeft = new Point(0, 0);
		bottomRight = new Point(0, 0);
	}
	 
	public Hitbox(Point topLeft, Point bottomRight) {
		super();
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}
	
	public Hitbox(double x, double y, double width, double height) {
		this.topLeft = new Point(x, y);
		this.bottomRight = new Point(x+width, y+height);
	}
	
//	public Hitbox(Point topLeft) { //ถ้าใส่มาอันเดียวคือ block เลย size 149,34
//		super();
//		this.topLeft = topLeft;
//		this.bottomRight = new Point(topLeft.getX()+149, topLeft.getY()+34);
//	}
	
	public boolean isOverlapping(Hitbox other) {
		if (getTopLeft().getY() > other.getBottomRight().getY()
			|| getBottomRight().getY() < other.getTopLeft().getY()) return false; //overlap
		
		if (getTopLeft().getX() > other.getBottomRight().getX()
			|| getBottomRight().getX() < other.getTopLeft().getX()) return false;
		
		return true;
		
	}
	
	public Point getTopLeft() {
		return topLeft;
	}
	public void setTopLeft(Point topLeft) {
		this.topLeft = topLeft;
	}
	public Point getBottomRight() {
		return bottomRight;
	}
	public void setBottomRight(Point bottomRight) {
		this.bottomRight = bottomRight;
	}
	
	public void setRectangle(double x,double y,double width, double height) {
		this.getTopLeft().setX(x);
		this.getTopLeft().setY(y);
		this.getBottomRight().setX(x+width);
		this.getBottomRight().setY(y+height);
	}
	
	public double getX() {
		return topLeft.getX();
	}
	
	public double getY() {
		return topLeft.getY();
	}
	
	
}
