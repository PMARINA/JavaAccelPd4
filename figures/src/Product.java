/**
 * [PROMPT]
 * 
 * @author PMARINA
 * @version Feb 23, 2016
 */
public class Product {
	private String name;
	private double price;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public void reducePrice(double reduction){
		if(reduction>=0)this.price-=reduction;
		else throw new Throwable("Negative Price Reduction Specified");
	}
	
	public void increasePrice(double addition){
		this.price += addition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
