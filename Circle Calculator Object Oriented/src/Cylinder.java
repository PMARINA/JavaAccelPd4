
/**
 * A generic cylinder
 * 
 * @author PMARINA
 * @version 3/21/2016
 */
public class Cylinder implements Shape {
	private double r;
	private double h;

	/**
	 * @param r
	 *            - the radius of the cylinder
	 * @param h
	 *            - the height of the cylinder
	 */
	public Cylinder(double r, double h) {
		this.r = r;
		this.h = h;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Shape#volume(int)
	 */
	@Override
	public double volume(int accuracy) {
		return ((double) ((int) (Math.PI * Math.pow(r, 2) * h * Math.pow(10, accuracy)))) / Math.pow(10, accuracy);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Shape#surfaceArea(int)
	 */
	@Override
	public double surfaceArea(int accuracy) {
		return ((double) ((int) (Math.pow(10, accuracy) * 2.0 * Math.PI * r * h + 2.0 * Math.PI * Math.pow(r, 2))))
				/ Math.pow(10, accuracy);
	}

}
