/**
 * @author PMARINA
 * @version Jun 12, 2016
 */

public class Key {
	private char[] lets = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			't', 'u', 'v', 'w', 'x', 'y', 'z' };
	private char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	
	Key(){
		scramble(lets);
	}
	
	
	public char[] getKey() {
		return lets;
	} 
	public char[] getUnencryptedKey(){
		return letters;
	}
	private static void scramble(char[] lets) {
		for (int i = lets.length - 1; i >= 0; i--) {
			char temp = lets[i];
			int pos = (int) (Math.random() * lets.length);
			lets[i] = lets[pos];
			lets[pos] = temp;
		}
	}
}
