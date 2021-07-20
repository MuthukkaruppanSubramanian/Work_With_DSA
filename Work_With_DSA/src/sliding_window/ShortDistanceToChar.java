package sliding_window;

import java.util.Arrays;

import org.junit.Test;

public class ShortDistanceToChar {
	/*
	 * Given a string s and a character c that occurs in s, return an array of
	 * integers answer where answer.length == s.length and answer[i] is the distance
	 * from index i to the closest occurrence of character c in s.
	 * 
	 * The distance between two indices i and j is abs(i - j), where abs is the
	 * absolute value function.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s = "loegvlleetcode", 
	 * c = "e" Output: [3,2,1,0,1,0,0,1,2,2,1,0]
	 * Explanation: 
	 * The character 'e' appears at indices 3, 5, 6, and 11
	 * (0-indexed). 
	 * The closest occurrence of 'e' for index 0 is at index 3, so the
	 * distance is abs(0 - 3) = 3. 
	 * The closest occurrence of 'e' for index 1 is at
	 * index 3, so the distance is abs(1 - 3) = 3. 
	 * For index 4, there is a tie between the 'e' at index 3 and the 
	 * 'e' at index 5, but the distance is still
	 * the same: abs(4 - 3) == abs(4 - 5) = 1. 
	 * The closest occurrence of 'e' for index 8 is at index 6, 
	 * so the distance is abs(8 - 6) = 2.
	 * 
	 * Pseudo Code
	 * 
	 * a.With give len of str create a new char array
	 * b.int lastMatchValueIndex
	 * c.traverse the str with two nested for loop
	 * f.traverse the inner loop until the give target matches
	 * g.if char is eql to target
	 * h.if lastMatchValueIndex is null then assign j value
	 * i.else if lastMatchValueIndex < j on new array on i index add j-1 value
	 * j.else if lastMatchValueIndex <= j then take the current matching
	 * k.find the min of j-lastmatch j-currentmatch and add it to the newarray at i index
	 * l.return new array
	 */
	
	@Test
	public void test1() {
		String str = "loveleetcode";
		char k = 'e';
		shortDistanceToCharBruteForce(str,k);
	}
	
	@Test
	public void test2() {
		String str = "aaab";
		char k = 'b';
		shortDistanceToCharBruteForce(str,k);
	}
	
	@Test
	public void test3() {
		String str = "aaba";
		char k = 'b';
		shortDistanceToCharBruteForce(str,k);
	}
	
	@Test
	public void test4() {
		String str = "aabaaab";
		char k = 'b';
		shortDistanceToCharBruteForce(str,k);
	}
	
	@Test
	public void test5() {
		String str = "aaaaab";
		char k = 'b';
		shortDistanceToCharBruteForce(str,k);
	}

	private int[] shortDistanceToCharBruteForce(String s, char c) {
		int lastMatchIndex = 0;
		int[] indexArray = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j)==c && j >= lastMatchIndex) {
					if(i==0) lastMatchIndex = j;
					if(lastMatchIndex < j) {
						indexArray[i] = Math.min(Math.abs(i-lastMatchIndex),Math.abs(i-j));
						lastMatchIndex = Math.abs(i-lastMatchIndex)> Math.abs(i-j)? j : lastMatchIndex;
						break;
					}else if(lastMatchIndex >= i) {
						indexArray[i] = Math.abs(j-i);
						lastMatchIndex = j;
						break;
					}
				}else if(j== s.length()-1) indexArray[i] = Math.abs(i-lastMatchIndex);
			}
		}
		System.out.println(Arrays.toString(indexArray));
		return indexArray;
	}
	
	
}
