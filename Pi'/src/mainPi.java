import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;


public class mainPi {
	/**
	 * @return the input provided by the user
	 */
	public static BigDecimal getInput(String prompt){
		System.out.println(prompt);
		Scanner sc = new Scanner(System.in);
		BigDecimal returnNum = new BigDecimal(sc.nextLine());
		sc.close();
		return returnNum;
	}
	public static void main(String[] args){
		BigDecimal sum = new BigDecimal("0");
		int acc = 5000;
		BigDecimal x = getInput("How many iterations?");
		boolean inverter = true;
		BigDecimal one = new BigDecimal("1.0");
		BigDecimal two = new BigDecimal("2.0");
		BigDecimal four = new BigDecimal("4.0");
		for(BigDecimal i = new BigDecimal("0.0"); i.compareTo(x)==-1; i = i.add(one)){
			if(inverter){
				sum = sum.add(one.divide((two.multiply(i)).add(one), acc, RoundingMode.HALF_UP));
				inverter = false;
			}
			else{
				sum = sum.subtract(one.divide(((two.multiply(i)).add(one)), acc, RoundingMode.HALF_UP));
				inverter = true;
			}
			System.out.println("Now " + i.divide(x, 4, RoundingMode.HALF_UP) + "% done");
		}
		System.out.println("π is approximately\n" + sum.multiply(four) + "\ngiven " + x.toString() + " iterations.");
	}
}

