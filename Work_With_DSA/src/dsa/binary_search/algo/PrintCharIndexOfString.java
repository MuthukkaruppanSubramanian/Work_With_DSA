package dsa.binary_search.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class PrintCharIndexOfString {
	/* 
	 * 
	 * Given Input  data type:
	 *       Output data type:
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1:
	 *
	 * Pseudo code:
	 * 
	 * 
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		String word = "aaabbbdddcc";
		Assert.assertTrue(printCharWithOccurrence(word).equals("a3b3c2d3"));
	}

	@Test
	public void test2() {
		String word = "";
		Assert.assertTrue(printCharWithOccurrence(word).equals(""));
	}


	public String printCharWithOccurrence(String str) {
		HashMap<Character, Integer> charOccur = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			charOccur.put(str.charAt(i), charOccur.getOrDefault(str.charAt(i), 0)+1);
		}
		String output = "";
		for (Map.Entry<Character,Integer> map : charOccur.entrySet()) {
			output +=map.getKey().toString()+map.getValue().toString();
		}
		System.out.println(output);
		return output;
	}
}
