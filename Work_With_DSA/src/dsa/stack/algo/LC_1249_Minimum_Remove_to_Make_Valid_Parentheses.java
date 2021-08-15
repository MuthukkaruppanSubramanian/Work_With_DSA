package dsa.stack.algo;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
 * 
 *
 * Sample Test Data 
 *    Input : 
 *    output: 
 *
 * Approach 1: 
 * 
 * Approach 2: 
 *
 * Pseudo code - Approach 1:
 *
 * Time / Space Complexity:
 * 		
 */
public class LC_1249_Minimum_Remove_to_Make_Valid_Parentheses {
	@Test
	public void test1() {
		String word = "lee(t(c)o)de)";
		Assert.assertTrue(rmvPranthesisToMakeValid(word).equals("lee(t(c)o)de"));
	}

	@Test
	public void test2() {
		String word = "a)b(c)d";
		Assert.assertTrue(rmvPranthesisToMakeValid(word).equals("ab(c)d"));
	}

	@Test
	public void test3() {
		String word = "(a(b(c)d)";
		Assert.assertTrue(rmvPranthesisToMakeValid(word).equals("a(b(c)d)"));
	}
	
	@Test
	public void test4() {
		String word = "))((";
		Assert.assertTrue(rmvPranthesisToMakeValid(word).equals(""));
	}
	
	@Test
	public void test5() {
		String word = "abc";
		Assert.assertTrue(rmvPranthesisToMakeValid(word).equals("abc"));
	}
	@Test
	public void test6() {
		String word = "())()(((";
		Assert.assertTrue(rmvPranthesisToMakeValid(word).equals("()()"));
	}


	/*
	 * Declare a stack
	 * Traverse the string in a for loop
	 * Check if the char is '('
	 * -----then push the index to stack
	 * else if char is ')'
	 * ------if(stack is not empty) pop the element
	 * 		 else int elementToBeRemoved = i and break;
	 * After for loop if stack is not empty
	 * ------int elementToBeRemoved = stack.peek;
	 * In the given string remove the element and check is valid
	 * 
	 * Time / Space Complexity: O(n) / O(n)
	 */
	
	public boolean isValid(StringBuilder paranthesis) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < paranthesis.length(); i++) {
			if(paranthesis.charAt(i) == '(') {
				stack.push('(');
			}else if(paranthesis.charAt(i) == ')') {
				if(!stack.isEmpty()) {
					stack.pop();
				}else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	private String rmvPranthesisToMakeValid(String word) {
		Stack<Integer> stack = new Stack<>();
		//if(!word.contains("(") && word.contains(")")) return word;
		for (int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == '(') {
				stack.push(i);
			}else if(word.charAt(i) == ')') {
				if(!stack.isEmpty()) {
					stack.pop();
				}else {
					StringBuilder s = new StringBuilder(word).deleteCharAt(i);
					boolean result = isValid(s);
					if(result) return s.toString();
					else return rmvPranthesisToMakeValid(s.toString());
				}
			}
		}
		if(!stack.isEmpty()) {
			StringBuilder s = new StringBuilder(word).deleteCharAt(stack.peek());
			boolean result = isValid(s);
			if(result) return s.toString();
			else return rmvPranthesisToMakeValid(s.toString());
		}
		return word;
	}
	
	private String minRemoveToMakeValid(String word) {
		Stack<Integer> stack = new Stack<>();
		//if(!word.contains("(") && word.contains(")")) return word;
		for (int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == '(') {
				stack.push(i);
			}else if(word.charAt(i) == ')') {
				if(!stack.isEmpty()) {
					stack.pop();
				}else {
					StringBuilder s = new StringBuilder(word).deleteCharAt(i);
					return rmvPranthesisToMakeValid(s.toString());
				}
			}
		}
		if(!stack.isEmpty()) {
			StringBuilder s = new StringBuilder(word).deleteCharAt(stack.peek());
			return rmvPranthesisToMakeValid(s.toString());
		}
		return word;
	}
}
