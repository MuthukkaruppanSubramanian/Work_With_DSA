package dsa.stack.algo;
import java.util.*;
import org.junit.*;

public class LongestvalidParenthesis {
	/* Longest Valid parenthesis in given string 
	 * 
	 * Given Input  data type: "}{{}}{"
	 *       Output data type: 4
	 *       
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1: using Stack
	 *
	 * 
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		String s = "}{{}}{";
		Assert.assertTrue(getLongestvalidParenthesis(s)==4);
	}


	@Test
	public void test2() {
		String s = "{}}{{{}}}";
		Assert.assertTrue(getLongestvalidParenthesis(s)==6);
	}

	@Test
	public void test3() {
		String s = "{}{{{}}";
		Assert.assertTrue(getLongestvalidParenthesis(s)==4);
	}
	
	/*
	 * Pseudo Code:
	 * 
	 */
	
	private int getLongestvalidParenthesis(String s) {
		HashMap<Character,Character> map = new HashMap<>();
		map.put('}', '{');
		Stack<Character> stack = new Stack<>();
		int currentMax = 0;
		int longestMax = 0;
		for (int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				if(!stack.isEmpty() && stack.peek().equals(map.get(s.charAt(i)))) {
					stack.pop();
					currentMax +=2;
				}else {
					longestMax = Math.max(longestMax, currentMax);
					currentMax = 0;
				}
			}else stack.push(s.charAt(i));
		}
		longestMax = Math.max(longestMax, currentMax);
		return longestMax;
	}
}






















