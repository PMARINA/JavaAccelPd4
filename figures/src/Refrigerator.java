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
 * Note: This is the refrigerator object in which the humans store the items. It
 * is required for the program to run...
 * 
 * @author PMARINA
 * @version Feb 17, 2016
 */
public class Refrigerator {
	private String[] contents;
	private double maxTemp;
	private double minTemp;
	private double temp;
	private double setTemp;
	private double tempChange = 0;
	private boolean fridgeOpen = false;
	private boolean lightOn = false;
	private int capacity;
	private String brand;
	private String[] errorArray = { "Specified temperature out of range", "Not enough space in specified Fridge",
			"Fridge Not Open", "Item not found in specified Fridge" }; // A list
																		// of
																		// errors
																		// possible

	/**
	 * Constructor of the fridge.
	 * 
	 * @param capacity
	 *            - the capacity of the fridge
	 * @param setTemp
	 *            - the set temperature of the fridge
	 * @param minTemp
	 *            - the minimum temperature of the fridge
	 * @param maxTemp
	 *            - the maximum temperature of the fridge
	 * @param brand
	 *            - the brand name of the fridge
	 * @throws Throwable
	 *             - the fridge's specified temperature cannot be attained
	 *             without external support
	 */
	public Refrigerator(int capacity, double setTemp, double minTemp, double maxTemp, String brand) throws Throwable {
		contents = new String[capacity]; // Initialize the contents array
		this.capacity = capacity; // Set the capacity of the fridge accordingly
		this.maxTemp = maxTemp; // Set the max temp
		this.minTemp = minTemp;// Set the min temp
		this.brand = brand;// Set the brand of the fridge
		if (setTemp < maxTemp && setTemp > minTemp) { // If the set temp is
														// attainable, then set
														// it accordingly
			this.setTemp = setTemp;
			this.temp = setTemp;
		} else
			throw new Throwable(errorArray[0]);
		this.close(); // Allow the fridge to cool
	}

	/**
	 * Opens the fridge - note, add and remove functions cannot be used without
	 * opening the fridge
	 */
	public void open() {
		fridgeOpen = true;
		lightOn = true;
		tempChange = 3;// heating rate/tick
	}

	/**
	 * Closes the fridge - note, temperature will continue to increase unless
	 * the fridge is closed
	 */
	public void close() {
		fridgeOpen = false;
		lightOn = false;
		tempChange = -1;// cooling rate/tick
	}

	/**
	 * Changes the temperature of the fridge from the set temperature when the
	 * fridge was originally created, or from the last set temperature
	 * 
	 * @param newTemp
	 *            - the new temperature setting of the fridge
	 * @throws Throwable
	 *             - the set temperature cannot be attained without external
	 *             support
	 */
	public void setTemperature(double newTemp) throws Throwable {
		if (newTemp > maxTemp || newTemp < minTemp) // If the temp is
													// attainable, then set it
			throw new Throwable(errorArray[0]);
		else
			setTemp = newTemp;
	}

	/**
	 * currently not functional. Would allow the temperature to change according
	 * to whether or not the fridge was open or closed
	 */
	public void tick() {
		if (temp > setTemp && tempChange < 0)
			temp += tempChange;
		else if (tempChange > 0)
			temp += tempChange;
	}

	/**
	 * Allows the user to add an item into the fridge, unless there is not
	 * enough space in the fridge
	 * 
	 * @param item
	 *            - the item being added
	 * @throws Throwable
	 *             - no more space left in fridge
	 */
	public void add(String item) throws Throwable {
		if (fridgeOpen) { // if the fridge is open
			boolean putin = false;
			for (int i = 0; i < capacity; i++) { // check for empty spots
				if (contents[i] == (null) && !putin) {
					contents[i] = item;// when one is found, put the item there
					putin = true;
				}
			}
			if (!putin)
				throw new Throwable(errorArray[1]);
		} else
			throw new Throwable(errorArray[2]);
	}

	/**
	 * Allows the client to remove items from the fridge, unless the item does
	 * not exist in the fridge.
	 * 
	 * @param item
	 *            - the item being removed from the fridge
	 * @throws Throwable
	 *             - the item in question cannot be found
	 */
	public void remove(String item) throws Throwable {
		boolean removed = false;
		if (fridgeOpen) { // if the fridge is open
			for (int i = capacity - 1; i >= 0; i++) { // Because whatever is put
														// in the fridge last
														// will be seen first...
				if (contents[i].equals(item) && !removed) { // if the contents
															// have not already
															// been moved and if
															// the item can be
															// found, then
															// remove it and
															// stop looking for
															// the item
					contents[i] = null;
					removed = true;
					return;
				}
			}
			throw new Throwable(errorArray[3]);
		}
	}

	/**
	 * Allows external methods to get the name of the fridge
	 * 
	 * @return the brand name of the fridge
	 */
	public String getName() {
		return brand;
	}
}