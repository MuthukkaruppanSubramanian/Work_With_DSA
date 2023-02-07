package dsa.contest.algo;
import org.junit.*;
import java.util.*;

public class Longest_SubString_of_Uniq_Chars {
	
	/* 2:35
	 * Longest Substring without repeating character
	 * Given a string s, find the length of the longest substring 
	 * without repeating characters.
	 *
	 * Sample Test Data 
	 *    Input : Type String => "abcabcbb"
	 *    output: Type int => 2 
	 *
	 * Approach 1: Two Pointer / Sliding Window
	 * 
	 *
	 * Time / Space Complexity: O(n) / O(1)
	 * 		
	 */
	
	@Test
	public void test1() {
		String s = "abcadcbb";
		Assert.assertTrue(getLongestUniqCharsCount2(s) == 4);
	}

	@Test
	public void test2() {
		String s = "bbbbb";
		Assert.assertTrue(getLongestUniqCharsCount2(s) == 1);
	}

	@Test
	public void test3() {
		String s = "pwwkew";
		Assert.assertTrue(getLongestUniqCharsCount2(s) == 3);
	}
	
	@Test
	public void test4() {
		String s = "abababc";
		Assert.assertTrue(getLongestUniqCharsCount2(s) == 3);
	}
	
	/*
	 * Pseudo Code
	 * Declare a hashmap with key as char and value as occurs
	 * start left and right as 0
	 * Traverse the string in a for loop with right = 0 till array length
	 * ----if char count > 0 then
	 * -------subtract the value of char in map
	 * -------do left++
	 * ----else
	 * -------add the char to map
	 * ----get the difference of right-left+1 and existing max
	 * return maxLen
	 * 8:50
	 */
	
	private int getLongestUniqCharsCount(String s) {
		HashMap<Character, Integer> charOccurs = new HashMap<>();
		int left = 0, right = 0, maxLen = 0;
		for(right = 0; right <s.length(); right++) {
			charOccurs.put(s.charAt(right), charOccurs.getOrDefault(s.charAt(right), 0)+1);
			if(charOccurs.get(s.charAt(right)) > 1) {
				while(left != right) {
					charOccurs.put(s.charAt(left), charOccurs.getOrDefault(s.charAt(left++), 0)-1);
				}
			}
			maxLen = Math.max(maxLen, (right-left)+1);
		}
		return maxLen;
	}
	
	
	private int getLongestUniqCharsCount2(String s) {
		HashMap<Character, Integer> charOccurs = new HashMap<>();
		int left = 0, right = 0, maxLen = 0;
		for(right = 0; right <s.length(); right++) {
			charOccurs.put(s.charAt(right), charOccurs.getOrDefault(s.charAt(right), 0)+1);
			if(charOccurs.get(s.charAt(right)) > 1) {
				while(charOccurs.get(s.charAt(right)) > 1) {
					charOccurs.put(s.charAt(left), charOccurs.getOrDefault(s.charAt(left++), 0)-1);
				}
			}
			maxLen = Math.max(maxLen, (right-left)+1);
		}
		return maxLen;
	}
}











