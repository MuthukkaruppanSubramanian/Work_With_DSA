package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class FindAnagram {

	/*
	 * Find All Anagrams in a String
	 * 
	 * Given two strings s and p, return an array of all the start indices of p's
	 * anagrams in s. You may return the answer in any order.
	 * 
	 * Example 1:
	 * 
	 * Input: s = "cbaebabacd", p = "abc" Output: [0,6] Explanation: The substring
	 * with start index = 0 is "cba", which is an anagram of "abc". The substring
	 * with start index = 6 is "bac", which is an anagram of "abc".
	 * 
	 * Approach:1 - Brute Force
	 * Pseudo Code:
	 *  a. create a new o/p array, index = 0 and temp var to store substring. 
	 *  b.create a function to check whether give string matched pattern
	 *  c.Using two for loop compare the string and return result in boolean
	 *  d. Traverse the given string in for loop till the string length
	 *  e. take the first 3 char using substring and call the isAnagram function if it return true then add it to the new array
	 *  f. if adding to set return true then delete the last added element and return false
	 *  g. copy the array with index value as last index and return the o/p array
	 *  
	 *  Time Complexity: O(n^3)
	 *  Space Complexity: O(n)  
	 *  
	 *  Pseudo Code: To find Anagram using Two Pointer
	 *  a.start two pointer at 0 index on both str
	 *  b.if char matches move the left forward and right back to 0
	 *  c.when right move to last index of pattern and doesnt match 
	 *    then break the loop and return false
	 */
	
	//@Test
	public void test1() {
		String str = "cbaebabacd";
		String p = "abc";
		findAnagram(str, p);
	}
	
	//@Test
	public void test2() {
		String str = "cbabacbacd";
		String p = "ab";
		findAnagram(str, p);
	}
	
	@Test
	public void test3() {
		String str = "seddsakhjksdaiouiuadskjjasddfdas";
		String p = "dsa";
		findAnagram(str, p);
	}
	
	@Test
	public void test4() {
		String str = "sedtdsakhjkstdaiouiuadtskjjastddfdast";
		String p = "dsat";
		findAnagram(str, p);
	}
	
	public boolean isAnagram(String str, String pattern) {
		boolean anagram = false;
		for (int i = 0; i < pattern.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				anagram = (pattern.charAt(i) == str.charAt(j));
				if(anagram) break;
			}
			if(!anagram) return false;
		}
		return true;
	}
	
	public String[] findAnagram(String str, String p) {
		int index = 0;
		String temp;
		String[] anagramArray = new String[str.length()-p.length()+1];
		for (int i = 0; i < str.length()-p.length()+1; i++) {
			if(i+p.length() > str.length()) {
				temp = str.substring(i, i+p.length()-1)+str.charAt(i-2);
			}else temp = str.substring(i, i+p.length());
			if(isAnagram(temp, p)) anagramArray[index++] = temp;
		}
		anagramArray = Arrays.copyOf(anagramArray, index);
		System.out.println(Arrays.toString(anagramArray));
		return anagramArray;
	}
}
