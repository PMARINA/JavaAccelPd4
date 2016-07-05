import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Generating cryptograms. A cryptogram is obtained by scrambling English text
 * by replacing each letter with another letter. Write an OOD program,
 * YI_Crypto1.java to generate a random permutation of the 26 letters and use
 * this to map letters. Give example: Don’t scramble punctuation or whitespace.
 * 
 * @author PMARINA
 * @version May 9, 2016
 */

public class Main {
	/**
	 * Main processing
	 * 
	 * @param args
	 *            - Does nothing
	 */
	public static void main(String[] args){
		// lets is to be scrambled, letters is to remain unscrambled throughout
		Key mykey = new Key();
		char[] lets = mykey.getKey();
		char[] letters = mykey.getUnencryptedKey();
		// Get input (currently only a string)
		Scanner sc = new Scanner(System.in);
		List<Character> ls = new ArrayList<Character>();
		System.out.println("Please enter the line which you would like to encrypt");
		String s = sc.nextLine();
		sc.close();
		// Add every single character to ls
		for (int i = 0; i < s.length(); i++)
			ls.add(new Character(s.charAt(i)));
		// Check whether or not the character has already been encrypted, to
		// avoid encrypting the same character multiple times
		boolean[] doneChar = new boolean[ls.size()];
		for (int i = 0; i < ls.size(); i++) {
			for (int j = 0; j < lets.length; j++) {
				if (!doneChar[i]) {
					// Check whether or not the letter is corresponding with the
					// character at position i
					if (ls.get(i).compareTo(new Character(letters[j])) == 0) {
						ls.set(i, new Character(lets[j]));
						doneChar[i] = !doneChar[i];
					}
				} else {
					j = lets.length - 1; // set j to the max value to avoid
											// unecessary comparisons.
				}
			}
		}
		// Output:
		System.out.println("Your key:");
		for (int i = 0; i < lets.length; i++) {
			System.out.print(letters[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < lets.length; i++) {
			System.out.print(lets[i] + " ");
		}
		System.out.println("\nYour encrypted message:");
		while (ls.size() > 0)
			System.out.print(ls.remove(0));
	}

	/**
	 * Uses method used in AP subset
	 * 
	 * @param lets
	 *            - the char array to be shuffled
	 */
	
}
