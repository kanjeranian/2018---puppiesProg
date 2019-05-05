package logic;

public class Rectangle {

	 private Point topLeft;
	 private Point bottomRight;
	 
	 
	 
	public Rectangle(Point topLeft, Point bottomRight) {
		super();
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}
	
	public Rectangle(Point topLeft) { //ถ้าใส่มาอันเดียวคือ block เลย size 149,34
		super();
		this.topLeft = topLeft;
		this.bottomRight = new Point(topLeft.getX()+149, topLeft.getY()+34);
	}
	
	public boolean isOverlapping(Rectangle other) {
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
	
	public void setRectangle(double x,double y,double w, double h) {
		this.getTopLeft().setX(x);
		this.getTopLeft().setY(y);
		this.getBottomRight().setX(x+w);
		this.getBottomRight().setY(y+h);
	}
	
	
}
