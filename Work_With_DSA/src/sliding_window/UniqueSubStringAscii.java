package sliding_window;

import org.junit.Test;

public class UniqueSubStringAscii {
	/*
		Given a string s, find the length of the longest substring without repeating characters.
		 
		Example 1:
		Input: s = "abcabcbb"
		Output: 3
		Explanation: The answer is "abc", with the length of 3.
		Example 2:
		Input: s = "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
		Example 3:
		Input: s = "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3.
		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 *
	 * Approach 1: 
	 * 
	 * Pseudo code:
	 * Declare a int[] with size of 128, left and right = 0, uniqueCount=0 , max=0.
	 * Traverse the array till right < input.len
	 * If char value is == 0 then uniqueCount++ and increase the charvalue++
	 * if uniqueCount > 1 and charValue > 0 
	 * Decrement the charValue and increment left
	 * find the max by right-left
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	//@Test
	public void test1() {
		String str = "abcabcbb";
		System.out.println(findUniqueSubString(str));
	}
	
	//@Test
	public void test2() {
		String str = "bbbbb";
		System.out.println(findUniqueSubString(str));
	}
	
	//@Test
	public void test3() {
		String str = "pwwkew";
		System.out.println(findUniqueSubString(str));
	}
	
	@Test
	public void test4() {
		String str = "pkerw";
		System.out.println(findUniqueSubString(str));
	}
	
	private int findUniqueSubString(String str) {
		int max =0, left =0, right=0;
		int[] asciiArray = new int [128];
		for(right=0; right < str.length();right++) {
			asciiArray[str.charAt(right)]++;
			while(asciiArray[str.charAt(right)] > 1) {
				asciiArray[str.charAt(left++)]--;
			}
			max = Math.max(max, right-left+1);
		}
		return max;
	}
	
}
