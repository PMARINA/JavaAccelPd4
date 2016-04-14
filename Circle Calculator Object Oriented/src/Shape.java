
/**
 * A general interface for a 3d cylindrical shape
 * 
 * @author PMARINA
 * @version 3/21/2016
 */
public interface Shape {
	/**
	 * @param accuracy
	 *            - the precision of the decimal being returned.
	 * @return - the volume of the shape
	 */
	public double volume(int accuracy);

	/**
	 * @param accuracy
	 *            - the precision of the decimal being returned.
	 * @return - the surface Area of the shape
	 */
	public double surfaceArea(int accuracy);
}
