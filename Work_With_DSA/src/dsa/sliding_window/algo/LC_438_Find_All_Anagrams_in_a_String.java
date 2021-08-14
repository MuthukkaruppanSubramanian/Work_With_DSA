package dsa.sliding_window.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LC_438_Find_All_Anagrams_in_a_String {

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
	
	@Test
	public void test1() {
		String str = "cbaebabacd";
		String p = "abc";
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(6);
		Assert.assertTrue(findAllAnagramUsingAscii(str, p).equals(list));
	}
	
	@Test
	public void test2() {
		String str = "abab";
		String p = "ab";
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		Assert.assertTrue(findAllAnagramUsingAscii(str, p).equals(list));
	}
	
	@Test
	public void test3() {
		String str = "seddsakhjksdaiouiuadskjjasddfdas";
		String p = "dsa";
		findAllAnagramUsingAscii(str, p);
	}
	
	@Test
	public void test4() {
		String str = "sedtdsakhjkstdaiouiuadtskjjastddfdast";
		String p = "dsat";
		findAllAnagramUsingAscii(str, p);
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
	
	/*
	 * Declare a patternHashmap and push the p
	 * Declare currenthashmap
	 * Decalre array list to push the index
	 * Declare left and right pointer
	 * traverse the string in while loop and add till the right =< str.length-p.length
	 * push the char to hash map
	 * if right-left+1 >= p.length
	 * then check pattermap.equals currenthashmap
	 * ----then add the left value to list
	 * else currentMap.get(left) > 1 then decrement the value
	 * else remove the left from current map and do right++
	 * return the list
	 */
	
	private List<Integer> findAllAnagram(String str, String s){
		if(s.length() > str.length()) return new ArrayList<>();
		HashMap<Character,Integer> pMap = new HashMap<>();
		HashMap<Character,Integer> cMap = new HashMap<>();
		ArrayList<Integer> output = new ArrayList<>();
		int left = 0, right = 0;
		for (int i = 0; i < s.length(); i++) {
			pMap.put(s.charAt(i), pMap.getOrDefault(s.charAt(i), 0)+1);
		}
		while(left <= str.length()-s.length()) {
			cMap.put(str.charAt(right), cMap.getOrDefault(str.charAt(right), 0)+1);
			if(right-left+1 == s.length()) {
				if(cMap.equals(pMap)) output.add(left);
				if (cMap.get(str.charAt(left)) > 1) {
					cMap.put(str.charAt(left), cMap.get(str.charAt(left))-1);
				}else {
					cMap.remove(str.charAt(left));
				}
				left++;
			}
			right++;
		}
		return output;
	}
	
	private List<Integer> findAllAnagramUsingAscii(String str, String s){
		if(s.length() > str.length()) return new ArrayList<>();
		int[] pMap = new int[128];
		int[] cMap = new int[128];
		String anagram = null;
		ArrayList<Integer> output = new ArrayList<>();
		int left = 0, right = 0;
		for (int i = 0; i < s.length(); i++) {
			pMap[s.charAt(i)]++;
		}
		while(left <= str.length()-s.length()) {
			cMap[str.charAt(right)]++;
			if(right-left+1 == s.length()) {
				if(Arrays.equals(cMap, pMap)) {
					output.add(left);
					if(right < str.length()-1)
						anagram = str.substring(left,right+1);
					else
						anagram = str.substring(left);
				}
				cMap[str.charAt(left)]--;
				left++;
			}
			right++;
		}
		System.out.println(anagram);//lastAnagramnnnn
		return output;
	}
}

















