/**
 * Implement a class Product. A product has a name and a price, for example, new
 * Product("Toaster", 29.95). Supply methods getName(), getPrice(), and
 * setPrice(). Write a program that makes two products, prints the name and
 * price, reduces their prices by $5.00, and then prints them again.
 * 
 * @author PMARINA
 * @version Feb 23, 2016
 */
public class Product {
	private String name;
	private double price;

	/**
	 * The sole constructor of product
	 * 
	 * @param name
	 *            - The name of the product
	 * @param price
	 *            - The price of the product
	 */
	public Product(String name, double price) {
		this.name = name; // set the name
		this.price = price; // and the price
	}

	/**
	 * A method to reduce the price of the product
	 * 
	 * @param reduction
	 *            - the price reduction
	 * @throws Throwable
	 *             - in the event of the reduction being negative
	 */
	public void reducePrice(double reduction) throws Throwable {
		if (reduction >= 0)// if the price reduction is positive
			this.price -= reduction; // then reduce the price accordingly.
		else
			throw new Throwable("Negative Price Reduction Specified"); // Otherwise,
																		// throw
																		// an
																		// error.
	}

	/**
	 * A method to increase the price of the product
	 * 
	 * @param addition
	 *            - the increase to the price
	 * @throws Throwable
	 *             - in the event that the price addition is negative
	 */
	public void increasePrice(double addition) throws Throwable {
		if (addition >= 0)// if the addition is positive, add the price addition
							// to the price
			this.price += addition;
		else
			throw new Throwable("Negative Price Reduction Specified");// Otherwise
																		// throw
																		// an
																		// error
	}

	/**
	 * An accessor for the product name
	 * 
	 * @return the name of the product
	 */
	public String getName() {
		return name;// return the name
	}

	/**
	 * @param name
	 *            - the new name of the product
	 */
	public void setName(String name) {
		this.name = name;// reset the name
	}

	/**
	 * An accessor of the price
	 * 
	 * @return - the price of the product
	 */
	public double getPrice() {
		return price; // return the price
	}

	/**
	 * @param price
	 *            - the new price of the product
	 */
	public void setPrice(double price) {
		this.price = price; // reset the price
	}
}
