
/**
 * A sphere object
 * 
 * @author PMARINA
 * @version 3/21/2016
 */
public class Sphere implements Shape {
	private double r;

	/**
	 * @param r
	 *            - the radius of the sphere
	 */
	public Sphere(double r) {
		this.r = r;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Shape#surfaceArea(int)
	 */
	@Override
	public double surfaceArea(int accuracy) {
		return ((double) ((int) (Math.pow(10, accuracy) * 4.0 * Math.PI * Math.pow(r, 2)))) / Math.pow(10, accuracy);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Shape#volume(int)
	 */
	@Override
	public double volume(int input) {
		return ((double) ((int) (Math.PI * (4.0 / 3.0) * Math.pow(r, 3) * Math.pow(10, input)))) / Math.pow(10, input);
	}
}
