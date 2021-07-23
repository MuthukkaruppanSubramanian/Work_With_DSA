package sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class MinimumWindowSubstring2 {
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
		String word = "bbaa";
		String t = "aba";
		System.out.println(minimumUniqueSubStringOfTarget(word, t));
		Assert.assertTrue(minimumUniqueSubStringOfTarget(word, t).equals("baa"));
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
		Assert.assertTrue(minimumUniqueSubStringOfTarget(word, t).equals("ab"));
	}
	
	public String minimumUniqueSubStringOfTarget(String s, String t) {
		int left = 0, right = 0, uniqueCounter = 0;
		int lastMatchLeft = Integer.MAX_VALUE, lastMatchRight = 0;
		int[] pattern = new int[128];
		int[] charMatched = new int[128];
		char duplicateVal = ' ';
		
		if(t.length() > s.length()) return "";
		if(s.length() <= 2 && t.length()<=1) {
			if(s.charAt(0) == t.charAt(0)) return s.charAt(0)+"";
			else if(s.length() >= 2 && s.charAt(1) == t.charAt(0)) return s.charAt(1)+"";
			else return "";	
		}
		
		//Add patter to array
		for (int i = 0; i < t.length(); i++) {
			pattern[t.charAt(i)]++; 
		}
		
		//Find the last subString that matches t
		for (right = 0; right < s.length(); right++) {
			if(pattern[s.charAt(right)] > 0 && uniqueCounter !=t.length()) {
				if(charMatched[s.charAt(right)] <= 0) {
					charMatched[s.charAt(right)]++;
					uniqueCounter++;
					if(uniqueCounter==1) left = right;
				}
				else if(charMatched[s.charAt(right)] == pattern[s.charAt(right)]) duplicateVal = s.charAt(right);
				else {
					charMatched[s.charAt(right)]++;
					uniqueCounter++;
				}
			}
			int count = 0;
			if(uniqueCounter == t.length()) {
				if(lastMatchLeft == Integer.MAX_VALUE) {
					lastMatchLeft = left;
					lastMatchRight = right;
				}else if((right-left) < (lastMatchRight - lastMatchLeft)) {
					lastMatchLeft = left;
					lastMatchRight = right;
				}
				if(t.length()==1) {
					charMatched[s.charAt(left)]--; 
					uniqueCounter--;
				}
				while(uniqueCounter == t.length()) {
					if(charMatched[s.charAt(left)] > 0) {
							charMatched[s.charAt(left)]--; 
							uniqueCounter--;
					}
					left++;
				}
				if(pattern[s.charAt(left)] == 0) left++;
				if(duplicateVal != ' ') {
					charMatched[duplicateVal]++;
					uniqueCounter++;
					duplicateVal = ' ';
					right--;
				}
			}
		}
		if(lastMatchRight==s.length()-1) {
			return s.substring(lastMatchLeft, lastMatchRight)+s.charAt(lastMatchRight);
		}else return s.substring(lastMatchLeft, lastMatchRight+1);
	}
}
