/**
 * @author PMARINA
 * @version Apr 30, 2016
 */

public class BirdDriver {
	static String num = "0";
	public static void main(String[] args) {
		num = Integer.toString(Integer.parseInt(num) + 1);
		Bird b2 = new Bird(num);
		System.out.println(b2);
		String[]  a = new String[1];
		main(a);
	}
}
