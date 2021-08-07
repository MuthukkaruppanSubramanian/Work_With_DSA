import java.util.*;
import org.junit.*;

public class StartingIndexOfAnagram {
	/* Get the starting index of anagram
	 * 
	 * Given Input  data type: s1 = "abcdbac" S2 = "abc"
	 *       Output data type: Int[] = {0,4}
	 *       
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1:
	 *
	 * 
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		String s1 = "abcdfgcba", s2 = "abc";
		String text = s1.replaceFirst(s2, "");
		System.out.println(text);
		Assert.assertTrue(Arrays.equals(getAnagramStartindex(s1,s2), new int[] {0,6}));
	}

	@Test
	public void test2() {
		String s1 = "aabcdfgacba", s2 = "aabc";
		Assert.assertTrue(Arrays.equals(getAnagramStartindex(s1,s2), new int[] {0,7}));
	}

	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code:
	 * Declare left = 0, right = 1 and int[] output = new int[s1.length[]-s2.length]
	 * Creates a patternHashMap with s2 characters and its occurrence
	 * Create a characterHashMap and add the 1st char of s1 to it.
	 * traverse the s1 in for loop break when right reach the s1.length-s2.length
	 * characterHashMap.put current s1.charAt(right) and its occurrence
	 * while(right-left+1 == s2.length)
	 * ----then if charHashMap.equals.patternHashMap then output[index++] = left
	 * ----if(charHashMap.get(char at left)==1) charHashMap.remove(char at left)
	 * ----else charHashMap.get(char at left)--;
	 * ----left++;
	 * 
	 * return output
	 */
	
	private int[] getAnagramStartindex(String s1, String s2) {
		int left = 0, right, index = 0;
		int[] output = new int[s1.length()-s2.length()];
		HashMap <Character, Integer> patternMap = new HashMap<>(26);
		HashMap <Character, Integer> currentMap = new HashMap<>(26);
		for(int i=0; i<s2.length(); i++) {
			patternMap.put(s2.charAt(i), patternMap.getOrDefault(s2.charAt(i), 0)+1);
		}
		currentMap.put(s1.charAt(0), currentMap.getOrDefault(s1.charAt(0), 0)+1);
		for(right = 1; right < s1.length(); right++) {
			currentMap.put(s1.charAt(right), currentMap.getOrDefault(s1.charAt(right), 0)+1);
			if(right-left+1 == s2.length()) {
				if(currentMap.equals(patternMap)) {
					output[index++] = left;
				}
				if(currentMap.get(s1.charAt(left))==1) {
					currentMap.remove(s1.charAt(left));
				}else currentMap.put(s1.charAt(left),currentMap.getOrDefault(s1.charAt(left), 0)-1);
				left++;
			}
		}
		System.out.println(Arrays.toString(output));
		return Arrays.copyOfRange(output, 0, index);
	}
}






















