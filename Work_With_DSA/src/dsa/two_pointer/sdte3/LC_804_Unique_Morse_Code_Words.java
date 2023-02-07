package dsa.two_pointer.sdte3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.junit.Assert;
import org.junit.Test;

public class LC_804_Unique_Morse_Code_Words {
	/*
		International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
		
		'a' maps to ".-",
		'b' maps to "-...",
		'c' maps to "-.-.", and so on.
		For convenience, the full table for the 26 letters of the English alphabet is given below:
		
		[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
		Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
		
		For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
		Return the number of different transformations among all words we have.
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - String Array
	 * What is the expected output? - int
	 * Do I have constraints to solve the problem? - No
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 * 
	 *
	 * 3) Do I know how to solver it?
	 *	Yes - great, Is there any alternate solution?
	 *	No - Can I break down the problem to sub problems?
	 *
	 * 4) Ask for the hint (If you don't know how to solve it)
	 *
	 *
	 * 5) Do I know alternate solution to solve this problem? - yes
	 *	Yes - What are those? Yes
	 *	No � That is still fine, proceed to solve by what you know !!
	 *  Simple Technique - > Brute Force !!
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 *  Approach 1: Hashing
	 *  
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 *
	 */

	@Test
	public void test1() {
		String[] words = {"gin","zen","gig","msg"};
		Assert.assertTrue(uniqueMorseRepresentations(words)==2);
	}

	@Test
	public void test2() {
		String[] words = {"gin","zen","msg"};
		Assert.assertTrue(uniqueMorseRepresentations1(words)==2);
	}

	/*
	 * Pseudo Code:
	 * 
	 * Algorithm: Hashing
	 * 
	 * 1. Create a Map with given code array;
	 * 2. Declare a HasSet of String
	 * 3. Iterate the words string array
	 * 5. ---for each word build the equivalent morse code by getting the corresponding code from map and concat in a string builder
	 * 6. ---add then string in to hash set
	 * 7. return the size of hash set;
	 * 
	 * Time Complexity: O(1)
	 * Space Complexity: O(n) - In Place memory
	 */
	public Map<Character,String> morseCode = new HashMap<>();

    public int uniqueMorseRepresentations(String[] words) {
    	build_morse_code_map();
    	HashSet<String> codes = new HashSet<>();
    	for(String word : words) codes.add(getMorseCode(word));
    	return codes.size();
    }
    
    private void build_morse_code_map() {
    	morseCode.put('a',".-");
    	morseCode.put('b',"-...");
    	morseCode.put('c',"-.-.");
    	morseCode.put('d',"-..");
    	morseCode.put('e',".");
    	morseCode.put('f',"..-.");
    	morseCode.put('g',"--.");
    	morseCode.put('h',"....");
    	morseCode.put('i',"..");
    	morseCode.put('j',".---");
    	morseCode.put('k',"-.-");
    	morseCode.put('l',".-..");
    	morseCode.put('m',"--");
    	morseCode.put('n',"-.");
    	morseCode.put('o',"---");
    	morseCode.put('p',".--.");
    	morseCode.put('q',"--.-");
    	morseCode.put('r',".-.");
    	morseCode.put('s',"...");
    	morseCode.put('t',"-");
    	morseCode.put('u',"..-");
    	morseCode.put('v',"...-");
    	morseCode.put('w',".--");
    	morseCode.put('x',"-..-");
    	morseCode.put('y',"-.--");
    	morseCode.put('z',"--..");
	}

	public String getMorseCode(String word) {
    	StringBuilder code = new StringBuilder();
    	for(int i = 0; i<word.length(); i++) code.append(morseCode.get(word.charAt(i)));
    	return code.toString();
    }
	
	
	// Without HashMap using ASCII array
	
	public String[] morseCode1 = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
								"---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations1(String[] words) {
    	HashSet<String> codes = new HashSet<>();
    	for(String word : words) codes.add(getMorseCode1(word));
    	return codes.size();
    }

	public String getMorseCode1(String word){
    	StringBuilder code = new StringBuilder();
    	for(int i = 0; i<word.length(); i++) code.append(morseCode1[word.charAt(i)-'a']);
    	return code.toString();
    }
	
}

