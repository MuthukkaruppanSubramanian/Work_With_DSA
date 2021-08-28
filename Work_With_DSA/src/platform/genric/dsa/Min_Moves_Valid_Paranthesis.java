package platform.genric.dsa;

import java.util.Iterator;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class Min_Moves_Valid_Paranthesis {
	@Test
	public void test1() {
		String s = "(())";
		Assert.assertTrue(minimumMovesToMakeValid(s)==0);
		Assert.assertTrue(minMovestoMakePranthesisValidUsingString(s)==0);
	}

	@Test
	public void test2() {
		String s = ")))(((";
		Assert.assertTrue(minimumMovesToMakeValid(s)==6);
		Assert.assertTrue(minMovestoMakePranthesisValidUsingString(s)==6);
	}

	@Test
	public void test3() {
		String s = "()))((";
		Assert.assertTrue(minimumMovesToMakeValid(s)==4);
		Assert.assertTrue(minMovestoMakePranthesisValidUsingString(s)==4);
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
	 * Approach 2: String
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
	
	private int minMovestoMakePranthesisValidUsingString(String s) {
		int openCount = 0, closeCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ')') {
				if(openCount > 0)	openCount--;
				else closeCount++;
			}else {
				openCount++;
			}
		}
		return openCount+closeCount;
	}
	
	private int minimumMovesToMakeValidOptimized(String s) {
        int ans = 0, bal = 0;
        for (int i = 0; i < s.length(); ++i) {
            bal += s .charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
	}
}















