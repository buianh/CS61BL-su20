/** A class that represents a path via pursuit curves. */
public class Path {

    private Point curr = new Point();
	private Point next = new Point();
	
	public Path(double x, double y) {
    // more code goes here!
		this.next.setX(x);
		this.next.setY(y);
		this.curr.setX(0);
		this.curr.setY(0);
	}

	public double getCurrX() {
		return this.curr.getX();
	}
	
	public double getCurrY() {
		return this.curr.getY();
	}
	public double getNextX() {
		return this.next.getX();
	}
	
	public double getNextY() {
		return this.next.getY();
	}
	
	public Point getCurrentPoint() {
		return this.curr;
	}
	
	public void setCurrentPoint(Point point){
		this.curr.setX(point.getX());
		this.curr.setY(point.getY());
	}
	
	public void iterate(double dx, double dy) {
		this.curr = this.next;
		this.next = new Point(dx+this.curr.getX(), dy+this.curr.getY());
		
	}
}

