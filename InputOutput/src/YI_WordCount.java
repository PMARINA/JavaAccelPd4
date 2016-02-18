
import java.util.ArrayList;
/**
 * @author PMARINA
 * @version 2/2/2016
 * Assignment: Word and line count. Modify WordCount.java so that reads in text from standard input and prints out the number of characters, words, and lines in the text.
 */
public class YI_WordCount {
	private static ArrayList<String> input = new ArrayList<String>();
	private static int lines = 0;
	/**
	  Blah Blah Blah
	 * @params param1 does this
	 * @returns returns stuff
	 * @throws noInputError no input given by the user
	 */
	public static void main(String[] args) {
		System.out.println("In order use wordCount, first enter the text, using enter to separate lines. At the end, press enter one last time, and then finally insert the end-of-input character");
		int space = 0;
		int letters = 0;
		int words= 0;
		int miscChars = 0;
		while(!StdIn.isEmpty())getInputByLine();
		for(int i = 0; i< input.size(); i++){
			String lineOfInput = input.get(i);
			for(int j = 0; j<lineOfInput.length();j++){
				char charInLineOfInput = lineOfInput.charAt(j);
				if(charInLineOfInput ==  ' ')space++;
				else if ((charInLineOfInput >= 'a' && charInLineOfInput <='z') || (charInLineOfInput >= 'A' && charInLineOfInput<='Z')) letters++;
				else miscChars++;
				
			}
		}
		words = space + 1*lines;
		System.out.println("The total number of lines is: " + lines);
		System.out.println("The total number of words is: " + words);
		System.out.println("The total number of characters (no spaces and misc characters) is: " + letters);
		System.out.println("The total number of characters (all characters) is: " + (letters + miscChars + space));
		
		
	}
	private static void getInputByLine(){
		String thisCharacter = StdIn.readLine();
		String thisChar = new String(thisCharacter);
		input.add(thisChar);
		lines++;
	}
}
