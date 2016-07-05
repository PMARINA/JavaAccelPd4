/**
 * @author PMARINA
 * @version May 6, 2016
 */

public class Pointer {
	private double x;
	private double y;

	public Pointer(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	public double distanceTo(double x, double y) {
		double dx = this.getX() - x;
		double dy = this.getY() - y;
		return Math.pow(Math.pow(dx, 2) + Math.pow(dy, 2), 0.5);
	}

	public double[] updatePos() {
		setX(StdDraw.mouseX());
		setY(StdDraw.mouseY());
		this.setX(x);
		this.setY(y);
		double[] xy = {getX(),getY()};
		return xy;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
}
