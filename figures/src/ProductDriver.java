import java.util.ArrayList;

/**
 * Implement a class Product. A product has a name and a price, for example, new
 * Product("Toaster", 29.95). Supply methods getName(), getPrice(), and
 * setPrice(). Write a program that makes two products, prints the name and
 * price, reduces their prices by $5.00, and then prints them again.
 * 
 * @author PMARINA
 * @version Feb 23, 2016
 */
public class ProductDriver {
	/**
	 * Implement a class Product. A product has a name and a price, for example,
	 * new Product("Toaster", 29.95). Supply methods getName(), getPrice(), and
	 * setPrice(). Write a program that makes two products, prints the name and
	 * price, reduces their prices by $5.00, and then prints them again.
	 * 
	 * @param args
	 *            - serves no use
	 */
	public static void main(String[] args) {
		ArrayList<Product> a = new ArrayList<Product>();
		Product toaster = new Product("Toaster", 29.95);
		a.add(toaster);
		Product bread = new Product("Bread", 12.35);
		a.add(bread);
		for (Product item : a) {
			System.out.println(item.getName() + " costs $" + item.getPrice() + ".");
			try {
				item.reducePrice(5);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		System.out.println("---After Price Change---");
		for (Product item : a) {
			System.out.println(item.getName() + " costs $" + item.getPrice() + ".");
		}
	}
}
