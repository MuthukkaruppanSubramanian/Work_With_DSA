package platform.genric.dsa;

import java.util.Iterator;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class Min_Moves_Valid_Paranthesis {
	@Test
	public void test1() {
		String s = "(()))";
		Assert.assertTrue(minimumMovesToMakeValid(s)==1);
	}

	@Test
	public void test2() {
		String s = ")))(((";
		Assert.assertTrue(minimumMovesToMakeValid(s)==6);
	}

	@Test
	public void test3() {
		String s = ")))";
		Assert.assertTrue(minimumMovesToMakeValid(s)==3);
	}

	/*
	 * 
	 *
	 * Sample Test Data 
	 *    Input : String s = ")))";
	 *    output: 3
	 *
	 * Approach 1: Stack
	 * 
	 * Approach 2: 
	 *
	 * Pseudo code - Approach 1:
	 * 
	 * Declare a stack
	 * Traverse the string in while
	 * if the char is equal to '(' push to stack
	 * if char is equal to ')'
	 * ------if stack is not empty and peek == ')'
	 * ----------stack.pop;
	 * ------else increase counter++;
	 * counter += stack.size();
	 * return counter;
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	private int minimumMovesToMakeValid(String s) {
		int counter = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			}else {
				if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
				else counter++;
			}
		}
		return counter+stack.size();
	}
}
