
/**
 * A cone
 * 
 * @author PMARINA
 * @version 3/21/2016
 */
public class Cone implements Shape {
	private double r;
	private double h;

	/**
	 * @param r
	 *            - the radius of the cone
	 * @param h
	 *            - the height of the cone
	 */
	public Cone(double r, double h) {
		super();
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
		return ((double) ((int) (Math.pow(10, accuracy) * Math.PI * Math.pow(r, 2) * (h / 3.0))))
				/ Math.pow(10, accuracy);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Shape#surfaceArea(int)
	 */
	@Override
	public double surfaceArea(int accuracy) {
		return ((double) (int) (Math.pow(10, accuracy)
				* (Math.PI * r * (r + Math.pow(Math.pow(h, 2) + Math.pow(r, 2), 0.5))))) / Math.pow(10, accuracy);
	}

}
