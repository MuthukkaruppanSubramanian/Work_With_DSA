package sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class MinimumWindowSubstring {
	/* 
	 * 
	 * Given Input  data type:
	 *       Output data type:
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1:
	 *
	 * Pseudo code:
	 * Declare int[] array of size 52 for give t and stringMatched
	 * Add the char of string t to pattern int []
	 * Traverse the string in for loop from 0 to str length
	 * If the char matches the pattern array  by condition patterArray[right]>0
	 * then check strArray[right] <1 then add 1 to it else
	 * check strArray[right]==patternArray[right] then int dupliacteValue=strArray[right]
	 * else strArray[right]++
	 * and assign left = right when uniqueCounter == 1
	 * else then move the right forward
	 * When unique character count reaches patter size
	 * if the lastMatchLeft eql to integerMax value then assign the current left and right
	 * else check right-left < lastMatchedRight -lastMatchedLeft
	 * then swap the value.
	 * In a while loop decrement the left value with condition count < 2 
	 * if left matches the patter char then count++
	 * and left -- if count !=2
	 * if duplicateValue != "" then add it to the uniqueCounter++ and strArray
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		String word = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minimumUniqueSubStringOfTarget(word, t));
		Assert.assertTrue(minimumUniqueSubStringOfTarget(word, t).equals("BANC"));
	}

	@Test
	public void test2() {
		String word = "aa";
		String t = "aa";
		System.out.println(minimumUniqueSubStringOfTarget(word, t));
		Assert.assertTrue(minimumUniqueSubStringOfTarget(word, t).equals("aa"));
	}

	@Test
	public void test3() {
		String word = "bb";
		String t = "b";
		System.out.println(minimumUniqueSubStringOfTarget(word, t));
		Assert.assertTrue(minimumUniqueSubStringOfTarget(word, t).equals("b"));
	}

	@Test
	public void test4() {
		String word = "abc";
		String t = "a";
		System.out.println(minimumUniqueSubStringOfTarget(word, t));
		Assert.assertTrue(minimumUniqueSubStringOfTarget(word, t).equals("a"));
	}

	@Test
	public void test5() {
		String word = "abbcb";
		String t = "cb";
		System.out.println(minimumUniqueSubStringOfTarget(word, t));
		Assert.assertTrue(minimumUniqueSubStringOfTarget(word, t).equals("bc"));
	}

	@Test
	public void test6() {
		String word = "bdab";
		String t = "ab";
		System.out.println(minimumUniqueSubStringOfTarget(word, t));
		Assert.assertTrue(minimumUniqueSubStringOfTarget(word, t).equals("bc"));
	}

	public String minimumUniqueSubStringOfTarget(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return "";
		}

		// Dictionary which keeps a count of all the unique characters in t.
		Map<Character, Integer> dictT = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			int count = dictT.getOrDefault(t.charAt(i), 0);
			dictT.put(t.charAt(i), count + 1);
		}

		// Number of unique characters in t, which need to be present in the desired window.
		int required = dictT.size();

		// Left and Right pointer
		int l = 0, r = 0;

		// formed is used to keep track of how many unique characters in t
		// are present in the current window in its desired frequency.
		// e.g. if t is "AABC" then the window must have two A's, one B and one C.
		// Thus formed would be = 3 when all these conditions are met.
		int formed = 0;

		// Dictionary which keeps a count of all the unique characters in the current window.
		Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

		// ans list of the form (window length, left, right)
		int[] ans = {-1, 0, 0};

		while (r < s.length()) {
			// Add one character from the right to the window
			char c = s.charAt(r);
			int count = windowCounts.getOrDefault(c, 0);
			windowCounts.put(c, count + 1);

			// If the frequency of the current character added equals to the
			// desired count in t then increment the formed count by 1.
			if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
				formed++;
			}

			// Try and contract the window till the point where it ceases to be 'desirable'.
			while (l <= r && formed == required) {
				c = s.charAt(l);
				// Save the smallest window until now.
				if (ans[0] == -1 || r - l + 1 < ans[0]) {
					ans[0] = r - l + 1;
					ans[1] = l;
					ans[2] = r;
				}

				// The character at the position pointed by the
				// `Left` pointer is no longer a part of the window.
				windowCounts.put(c, windowCounts.get(c) - 1);
				if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
					formed--;
				}

				// Move the left pointer ahead, this would help to look for a new window.
				l++;
			}

			// Keep expanding the window once we are done contracting.
			r++;   
		}

		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	}
}
