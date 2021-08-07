package dsa.sliding_window.algo;
import java.util.*;
import org.junit.*;

public class MaxSubStringLenOfkDistinctCha {
	/* Given a String find the max substring with k distinct char
	 * 
	 * Given Input  data type: String AAAHHIBC
	 *       Output data type: String AAAHHIBC
	 *       
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1:Sliding Window
	 *
	 * 
	 * Time / Space Complexity: O(n) / O(n)
	 * 		
	 */

	@Test
	public void test1() {
		String s = "AAAHHIBC";
		int k = 2;
		Assert.assertTrue(findMaxSubString(s,k).equals("AAAHH"));
	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code:
	 * 
	 */

	private Object findMaxSubString(String s, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		int left = 0, right;
		for(right=1; right<s.length()-1;right++) {
			
		}
		return null;
	}

}






















