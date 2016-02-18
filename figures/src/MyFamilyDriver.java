/**
 * Write a class Person (-- this is actually Human.java because Person.java is a
 * drawing class) with the following specifications:
 * 
 * 1. Constructor: it takes a name as a string and a second string argument that
 * describes what member of the family it is.
 * 
 * 2. Mutator Method: setAge(int anAge). It prompts the user for age and updates
 * the class instance field.
 * 
 * 3. Mutator Method: setWhatIamDoing(String doing). It prompts the user and
 * updates the class instance field currentActivity. Keep the number of
 * activities low so it doesn't become too lengthly.
 * 
 * 4. Accessor Method: getWhatIamDoing(). It displays the currentActivity.
 * 
 * 
 * Tester class: MyFamilyDriver.java
 * 
 * 
 * Create or “instantiate” 4 persons, a mother, a father, a son or a daughter
 * and a friend. Simulate the following set of events: The mother keeps milk in
 * the refrigerator. The father keeps juice in the refrigerator. The son keeps a
 * can of soda in the refrigerator. The friend is thirsty and wants to drink
 * something.
 * 
 * You can add more methods and instance fields to the Person ADT so you can
 * make the simulation work nicely.
 * 
 * Some java language help: String a = "abc"; String b = "abcdefg";
 * System.out.println(b.contains(a)); // true
 * 
 * Note: This class is a driver for class Human, not person
 * 
 * @author PMARINA
 * @version Feb 17, 2016
 */
public class MyFamilyDriver {
	/**
	 * @param args
	 *            has no use
	 */
	public static void main(String[] args) {
		try {
			Human a = new Human("Dzyana Z", "Mother");
			a.setAge(54);
			Human b = new Human("Danillo Seskar", "Father");
			b.setAge(56);
			Human c = new Human("Amy W", "Daughter");
			c.setAge(19);
			Human d = new Human("Charles L", "Friend");
			d.setAge(18);
			Refrigerator oldTrash = new Refrigerator(3, 35, 23, 58, "LG");
			a.addToFridge(oldTrash, "milk");
			System.out.println(a.getWhatAmIDoing());
			b.addToFridge(oldTrash, "juice");
			System.out.println(b.getWhatAmIDoing());
			c.addToFridge(oldTrash, "soda");
			System.out.println(c.getWhatAmIDoing());
			d.removeFromFridge(oldTrash, "soda");
			System.out.println(d.getWhatAmIDoing());
		} catch (Throwable a) {
			a.printStackTrace();
		}

	}
}
