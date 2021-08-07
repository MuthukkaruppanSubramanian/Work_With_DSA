import java.util.*;
import org.junit.*;

public class Lc_1358_Number_of_Substrings_Containing_All_Three_Characters {
	
	/*
	 * Given a string s consisting only of characters a, b and c.
	 * 
	 * Return the number of substrings containing at least one occurrence of all
	 * these characters a, b and c.
	 * 
	 * Example 1:
	 * 
	 * Input: s = "abcabc" Output: 10 Explanation: The substrings containing at
	 * least one occurrence of the characters a, b and c are "abc", "abca", "abcab",
	 * "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). Example 2:
	 * 
	 * Input: s = "aaacb" Output: 3 Explanation: The substrings containing at least
	 * one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
	 * Example 3:
	 * 
	 * Input: s = "abc" Output: 1
	 */
	
	/* 
	 * 
	 * Given Input  data type: s = "abcabc"
	 *       Output data type: 10
	 *
	 * Approach 1: Brute Force
	 *
	 * 
	 * Time / Space Complexity: O(n^2) / O(n)
	 * 		
	 */

	@Test
	public void test1() {
		String s = "abcabc";
		//Assert.assertTrue(getNoOfSubString(s)==10);
		//Assert.assertTrue(getNoOfSubStringSlidingWindow(s)==10);
		Assert.assertTrue(getNoOfSubStringSlidingWindowOptz(s)==10);
	}

	@Test
	public void test2() {
		String s = "aaacb";
		//Assert.assertTrue(getNoOfSubString(s)==3);
		//Assert.assertTrue(getNoOfSubStringSlidingWindow(s)==3);
		Assert.assertTrue(getNoOfSubStringSlidingWindowOptz(s)==3);
	}

	@Test
	public void test3() {
		String s = "abc";
		//Assert.assertTrue(getNoOfSubString(s)==1);
		//Assert.assertTrue(getNoOfSubStringSlidingWindow(s)==1);
		Assert.assertTrue(getNoOfSubStringSlidingWindowOptz(s)==1);
	}
	
	/*
	 * Pseudo Code: 
	 * Declare two hash set, one for patter match and other for current substring
	 * Traverse the string in nested for loop, the outerloop starts at 0
	 * ---Traverse the inner for loop from ith index to last index
	 * -----add the char to currentset
	 * -----check if current set equal to pattern set then increment the count
	 * ---reset the currentset to empty.
	 * return the count;
	 */
	
	private int getNoOfSubString(String s) {
		Set<Character> patternSet = new HashSet<>();
		Set<Character> currentSet = new HashSet<>();
		patternSet.add('a');
		patternSet.add('b');
		patternSet.add('c');
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				currentSet.add(s.charAt(j));
				if(currentSet.equals(patternSet)) count++;
			}
			currentSet.removeAll(currentSet);
		}
		return count;
	}
	
	private int getNoOfSubStringSlidingWindow(String s) {
		Set<Character> patternSet = new HashSet<>();
		HashMap<Character,Integer> currentmap = new HashMap<>();
		patternSet.add('a');
		patternSet.add('b');
		patternSet.add('c');
		int count = 0;
		int left = 0, right = 0;
		while(left <= s.length()-3) {
			currentmap.put(s.charAt(right), currentmap.getOrDefault(s.charAt(right++), 0)+1);
			if(currentmap.keySet().equals(patternSet)) count++;
			if(right == s.length()) {
				right--;
				currentmap.put(s.charAt(left), currentmap.getOrDefault(s.charAt(left), 0)-1);
				if(currentmap.get(s.charAt(left))==0) currentmap.remove(s.charAt(left));
				left++;
				while(right>=left+2) {
					currentmap.put(s.charAt(right), currentmap.getOrDefault(s.charAt(right), 0)-1);
					if(currentmap.get(s.charAt(right))==0) currentmap.remove(s.charAt(right));
					right--;
				}
				right++;
			}
		}
		return count;
	}
	
	private int checkSubString(int position, String s, HashMap<Character, Integer> currentmap) {
		int subStringCount = 0;
		while(position < s.length()) {
			if(currentmap.get(s.charAt(position++)) > 0) subStringCount++;
		}
		return subStringCount;
	}

	private int getNoOfSubStringSlidingWindowOptz(String s) {
		Set<Character> patternSet = new HashSet<>();
		HashMap<Character,Integer> currentmap = new HashMap<>();
		patternSet.add('a');
		patternSet.add('b');
		patternSet.add('c');
		int count = 0;
		int left = 0, right = 0;
		while(left <= s.length()-3) {
			currentmap.put(s.charAt(right), currentmap.getOrDefault(s.charAt(right++), 0)+1);
			if(currentmap.keySet().equals(patternSet)) {
				count++;
				int remainingCount = checkSubString(right,s, currentmap);
				if(remainingCount == 0) break;
				else count +=remainingCount;
				while(currentmap.size()==patternSet.size()) {
					currentmap.put(s.charAt(left), currentmap.getOrDefault(s.charAt(left), 0)-1);
					if(currentmap.get(s.charAt(left))==0) currentmap.remove(s.charAt(left));
					left++;
				}
			}
		}
		return count;
	}
}






















