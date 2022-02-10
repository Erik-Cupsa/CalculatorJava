/**
 * Character and Strings Lessons
 * @author erikc
 *
 */

public class CharacterAndStrings { 
	
	/**
	 * toHexDigit
	 * 
	 * Creates a character corresponding to a hexadecimal digit, or returns '?'
	 * 
	 * @param int n Digit to be converted to a hexadecimal character 
	 * @return char Integer as a hexadecimal character 
	 */
	public char toHexDigit(int n) { 
		if(n>= 0 && n<= 9) {
			return (char) ('0' + n); 
		}
		else if (n>= 10 && n<= 15) { 
			return (char) ('A' + n); 
		}
		else { 
			return '?';
		}
	}
	
	/**
	 * toUpperCase
	 * 
	 * Creates an upper case copy of a string
	 * 
	 * @param String str String to be converted to uppercase
	 * @return String result String in uppercase format
	 */
	public String toUpperCase(String str) { 
		String result = "";
		for(int i=0; i< str.length(); i++) {
			char ch = str.charAt(i);
			ch = Character.toUpperCase(ch); 
			result += ch; 
		}
		return result; 
	}
	
	/**
	 * indexOf
	 * 
	 * Finds the index position of an integer
	 * 
	 * @param char ch Character to be found in string
	 * @return int n Index position 
	 */
	public int indexOf(char ch) { 
		for (int i=0; i < str.length(); i++) {
			if (ch == str.charAt(i)) return i;
		}
		return -1; 
	}
	
	/**
	 * reverseString
	 * 
	 * Reverses a string
	 * 
	 * @param String str String to be reversed
	 * @return String rev String reversed
	 */
	
	public String reverseString(String str) {
		String rev = "";
		for (int i = 0; i<str.length(); i++) {
			rev = str.charAt(i) + rev; 
		}
		return rev; 
	}
	private String str; //private instance variables
}
