package dsa.sliding_window.algo;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class FindAllUniqueSubString {
	/*
	 * "abbcafbc" - get the shortest unique substring
	 * 
	 * Given Input  data type: String "abbcafbc"
	 *       Output data type: String "bcaf"
	 * Sample Test Data 
	 *    Input :"addfes"
	 *    output: "dfes"
	 *
	 * Approach 1: Sliding Window
	 *
	 * Pseudo code:
	 * Declare left and right starts at 0 and Set and int array of size 128
	 * Get all the unique char using set in a for loop
	 * Use other for loop to traverse through the array
	 * add the element to array if already contains increase the count
	 * if that char count is  > 1 then using left pointer decrement
	 * continue the loop till array size match right-left+1
	 * then return the subString using left and right pointers 
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		String word = "abbcafcb";
		Assert.assertTrue(getAllUniqueSubstring(word).equals("bcaf"));
	}
	
	@Test
	public void test2() {
		String word = "bcaf";
		Assert.assertTrue(getAllUniqueSubstring(word).equals("bcaf"));
	}
	
	@Test
	public void test3() {
		String word = "bbbbb";
		Assert.assertTrue(getAllUniqueSubstring(word).equals("b"));
	}
	
	private String getAllUniqueSubstring(String str) {
		int left = 0, right = 0;
		int[] charArray = new int[128];
		Set<Character> uniqueChar = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			uniqueChar.add(str.charAt(i));			
		}
		for(right = 0; right < str.length(); right++) {
			charArray[str.charAt(right)]++;
			while(charArray[str.charAt(right)] > 1) {
				charArray[str.charAt(left++)]--;
			}
			if(right-left+1 == uniqueChar.size()) return str.substring(left, right+1);
		}
		return str;
	}
}
