package dsa.stack.algo;

import java.util.Stack;

import org.junit.Test;

public class Stacj_remove_adj_duplicates {
	/*
	 * 	 * Given Input  data type:String and String[]
	 *       Output data type:Boolean
	 * Sample Test Data 
	 *    Input : s = "abbcc"
	 *    output: a
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
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		String s = "abba";
		System.out.println(removeTheAdjcentChar(s));

	}

	@Test
	public void test2() {
		String s = "abbab";
		System.out.println(removeTheAdjcentChar(s));
	}

	@Test
	public void test3() {

	}

	public String removeTheAdjcentChar(String s) {
		Stack<Character> stack = new Stack<Character>();
		stack.push(s.charAt(0));
		for(int i = 1; i < s.length(); i++) {
			if(!stack.isEmpty() && stack.peek()==s.charAt(i)) stack.pop();
			else stack.push(s.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		sb.insert(0, 0)
		return stack.toString();
		
		
	}
}
