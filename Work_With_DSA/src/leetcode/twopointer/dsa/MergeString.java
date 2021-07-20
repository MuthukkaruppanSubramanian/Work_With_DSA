package leetcode.twopointer.dsa;

import org.junit.Test;

public class MergeString {

	/*	You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

	Return the merged string.



	Example 1:

	Input: word1 = "abc", word2 = "pqr"
	Output: "apbqcr"
	Explanation: The merged string will be merged as so:
	word1:  a   b   c
	word2:    p   q   r
	merged: a p b q c r

	 */


	/*
	 * Given Input  data type:
	 *       Output data type:
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1: 
	 * Declare left and right start at 0 and output empty string
	 * Traverse the string in while loop with right < str.length | left < str.lenght
	 * add left char to string then right if any point reaches last skip adding
	 * return string
	 * Pseudo code:
	 *
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		String word1 = "abc", word2 = "pqr";
		System.out.println(mergeString(word1, word2));
	}

	@Test
	public void test2() {
		String word1 = "ab", word2 = "pqrd";
		System.out.println(mergeString(word1, word2));
	}

	@Test
	public void test3() {

	}

	public String mergeString(String word1, String word2) {
		String str = "";
		int left = 0, right = 0;
		while(left < word1.length() || right < word2.length()) {
			if(left < word1.length()) str = str+word1.charAt(left++);
			if(right < word2.length()) str = str+word2.charAt(right++);
		}
		return str;
	}
}
