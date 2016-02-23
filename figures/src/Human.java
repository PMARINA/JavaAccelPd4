import java.util.ArrayList;

/**
 * Write a class Human with the following specifications:
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
 * Note: This is the actual Human class.
 * 
 * @author PMARINA
 * @version Feb 17, 2016
 */
public class Human {
	private String name;
	private String member;
	private String whatAmIDoing = "Nothing";
	private ArrayList<String> actions = new ArrayList<String>();
	private double age;
	private ArrayList<String> pockets = new ArrayList<String>();

	/**
	 * @param gName
	 *            - the name given to the human object
	 * @param gMember
	 *            - the member of the family of the human object
	 */
	public Human(String gName, String gMember) {
		name = gName;
		member = gMember;
	}

	/**
	 * @param fridge
	 *            - the refrigerator object
	 */
	public void openFridge(Refrigerator fridge) {
		actions.add(name + "is opening " + fridge.getName());
		fridge.open();
	}

	/**
	 * @param fridge
	 *            - the refrigerator object
	 */
	public void closeFridge(Refrigerator fridge) {
		actions.add(name + " is closing " + fridge.getName());
		fridge.close();
	}

	/**
	 * Allow the human to remove items from the fridge
	 * 
	 * @param fridge
	 *            - the refrigerator object
	 * @param item
	 *            - the item being removed
	 */
	public void removeFromFridge(Refrigerator fridge, String item) {
		fridge.open();
		boolean caught = false;
		try {
			fridge.remove(item);
		} catch (Throwable thrown) {
			actions.add(name + " tried to remove " + item + " from " + fridge.getName());
			System.out.println(name + " failed to remove " + item + " from " + fridge.getName() + " due to error: "
					+ thrown.getMessage());
			caught = true;
		}
		if (!caught)
			actions.add(name + " is removing " + item + " from " + fridge.getName() + ". ");
		fridge.close();
	}

	/**
	 * Allow the human to add items to the fridge, and log the action
	 * 
	 * @param fridge
	 *            - the refrigerator object
	 * @param item
	 *            - the item being added
	 */
	public void addToFridge(Refrigerator fridge, String item) {
		fridge.open();
		actions.add(name + " is adding " + item + " to " + fridge.getName());
		try {
			fridge.add(item);
		} catch (Throwable thrown) {
			System.out.println(name + " failed to add " + item + " to " + fridge.getName() + " due to error: "
					+ thrown.getMessage());
		}
		fridge.close();
	}

	/**
	 * Allow the human to change the fridge's temperature
	 * 
	 * @param fridge
	 *            - the refrigerator object
	 * @param newTemp
	 *            - the new temperature setting for the refrigerator
	 */
	public void setFridgeTemperature(Refrigerator fridge, double newTemp) {
		actions.add("Changing " + fridge.getName() + "'s temperature to: " + newTemp);
		try {
			fridge.setTemperature(newTemp); // looking to see whether or not the
											// temperature is attainable...
		} catch (Throwable thrown) {
			System.out.println(name + " failed to change temperature of fridge: " + fridge.getName() + " due to error: "
					+ thrown.getMessage());
		}
	}

	/**
	 * @return the name of the human
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            - the new name of the human
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the member status
	 */
	public String getMember() {
		return member;
	}

	/**
	 * @param member
	 *            - the new member status
	 */
	public void setMember(String member) {
		this.member = member;
	}

	/**
	 * @return age of the human
	 */
	public double getAge() {
		return age;
	}

	/**
	 * Allows the user to set the age of the person, manually
	 * 
	 * @param age
	 *            - the new age of the person
	 * @throws Throwable
	 *             - negative age being specified
	 */
	public void setAge(double age) throws Throwable {
		if (age > 0)
			this.age = age;
		else
			throw new Throwable("Negative Age Specified");
	}

	/**
	 * Returns what the person was last doing, after updating the private field.
	 * 
	 * @return the last thing the person was known to be doing
	 */
	public String getWhatAmIDoing() {
		whatAmIDoing = actions.get(actions.size() - 1);
		return whatAmIDoing;
	}

	public void give(String item, Human person) {
		boolean done = this.pockets.remove(item);
		if (done){
			actions.add(this.name + " is giving " + item + " to " + person.name);
			person.pockets.add(item);
		}
		else
			actions.add(this.name + " tried to give " + item + " to " + person.name + ", but failed.");
	}

	public void take(String item, Human person) {
		boolean done = this.pockets.add(item);
		if(done){
			actions.add(this.name + " is taking " + item + " from " + person.name);
			person.pockets.add(item);
		}
		else actions.add(this.name + " tried to give " + item + " to " + person.name + ", but failed");
	}
	public void requestFromFridge(String item, Human person, Refrigerator fridge) {
		person.removeFromFridge(fridge, item);
		person.give(item, person);
		person.actions.add(person.name + " gave " + item + " to " + this.name);
		this.actions.add(this.name + " requested " + item + " from " + person.name);
	}
}
