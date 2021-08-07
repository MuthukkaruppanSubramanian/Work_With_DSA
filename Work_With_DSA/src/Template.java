import java.util.*;
import org.junit.*;

public class Template {
	/* 
	 * 
	 * Given Input  data type:
	 *       Output data type:
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
		String s = "aaabds";
		Assert.assertTrue(getLongestSubStringLen(s)==4);
	}

	@Test
	public void test2() {
		String s = "aaaaa";
		Assert.assertTrue(getLongestSubStringLen(s)==1);
	}

	@Test
	public void test3() {
		String s = "abcad";
		Assert.assertTrue(getLongestSubStringLen(s)==0);
	}
	
	@Test
	public void test4() {
		String s = "abab";
		Assert.assertTrue(getLongestSubStringLen(s)==2);
	}
	
	/*
	 * Pseudo Code: 
	 * Declare a maxValue and ascii array of size 128, left and right
	 * 
	 * 
	 * else
	 * 	--decreatment until the current char value becomes 0 
	 *   --then increase the char value as 1
	 *  --left++ get the max value by comparing the existing maxValue and
	 *     right-left+1 
	 * then return the maxValue.
	 */

	private int getLongestSubStringLen(String s) {
		int maxValue = Integer.MIN_VALUE, left = 0, right = 0;
		int[] asciiArray = new int[128];
		if(s.isEmpty()) return 0;
		//iterate the string in while loop until it reaches the end of the string Check
		while(right < s.length()) {
			
			//if the current char value is 0 then increment it and move the right++ 
			if(asciiArray[s.charAt(right)] == 0) {
				asciiArray[s.charAt(right++)]++;
			}else {
				
				//decrement until the current char value becomes 0
				while(asciiArray[s.charAt(right)]!=0) {
					asciiArray[s.charAt(right)]--;
				}
				left++;
			}
			maxValue = Math.max(maxValue, right-left);
		}
		return maxValue;
	}
}






















