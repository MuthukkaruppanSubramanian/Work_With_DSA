import org.junit.*;
import java.util.*;

public class Apple_Remove_K_Adjacent_Duplicates {
	
//	Question 4:
//		You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together. We repeatedly make k duplicate removals on s until we no longer can.
//		Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
//		 
//		Example 1:
//		Input: s = "abcd", k = 2
//		Output: "abcd"
//		Explanation: There's nothing to delete.
//		Example 2:
//		Input: s = "deeedbbcccbdaa", k = 3
//		Output: "aa"
//		Explanation: 
//		First delete "eee" and "ccc", get "ddbbbdaa"
//		Then delete "bbb", get "dddaa"
//		Finally delete "ddd", get "aa"
//		Example 3:
//		Input: s = "pbbcggttciiippooaais", k = 2
//		Output: "ps"
	
	/*
	 * 
	 *
	 * Sample Test Data 
	 *    Input : s = "abcd", k = 2
	 *    output: "abcd"
	 *
	 * Approach 1: Stack
	 * 
	 *
	 * Time / Space Complexity:O(n) / O(n)
	 * 
	 */
	
	@Test
	public void test1() {
		String s = "deeedbbcccbdaa";
		int k = 3;
		Assert.assertTrue(removeAdjacentDuplicate(s,k).equals("aa"));
	}

	@Test
	public void test2() {
		String s = "pbbcggttciiippooaais";
		int k = 2;
		Assert.assertTrue(removeAdjacentDuplicate(s,k).equals("ps"));
	}

	@Test
	public void test3() {
		String s = "abcd";
		int k = 2;
		Assert.assertTrue(removeAdjacentDuplicate(s,k).equals("abcd"));
	}

	/*"deeedbbcccbdaa", k = 3
	 * 8:18
	 * Pseudo Code
	 * Declare two stack for storing char and other for char count
	 * if string is empty return list of empty string
	 * push the first char to charStacka and 1 to charCount stack
	 * traverse the string in for loop until its length
	 * if char.peek != current char
	 * -----charcount.push(1)
	 * else
	 * -----charcount.push(charcCount.peek()+1)
	 * stack.push char
	 * if(charcount.peek == k)
	 * ---iterate in a for loop for k times
	 * ---charStack .pop
	 * ---charCount .pop
	 * 
	 * Iterate over stack and push the char to string buffer to form a string 
	 * 
	 */
	
	private String removeAdjacentDuplicate(String s, int k) {
		Stack<Character> charStack = new Stack<>();
		Stack<Integer> charCountStack = new Stack<>();
		if(s.isEmpty()) return "";
		for(int i = 0; i<s.length(); i++) { //"pbbcggttciiippooaais"
			if(!charStack.isEmpty() && charStack.peek() == s.charAt(i)) charCountStack.push(charCountStack.peek()+1);
			else charCountStack.push(1);
			charStack.push(s.charAt(i));
			if(charCountStack.peek() == k) {
				for(int j = 0; j < k; j++) {
					charStack.pop();
					charCountStack.pop();
				}
			}
		}
		StringBuilder output = new StringBuilder();
		for(Character letter : charStack) {
			output.append(letter);
		}
		System.out.println(charStack);
		System.out.println(output);
		return output.toString();
	}
}









