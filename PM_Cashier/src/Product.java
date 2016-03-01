/**
 * [PROMPT]
 * @author PMARINA
 * @version Feb 24, 2016
 */
public class Product {
	private String name;
	private double cost; 
		public Product(String name, double cost){
			this.name = name;
			this.cost = cost;
		}
		public String getName() {
			return name;
		}
		public double getCost() {
			return cost;
		}
		public void setCost(String pwd, double cost) throws Throwable {
			if(pwd.equals("askmrselia"))
				this.cost = cost;
			else throw new Throwable("Incorrect Password");
		}
}
