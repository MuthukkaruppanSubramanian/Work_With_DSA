import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
 * 
 *
 * Sample Test Data 
 *    Input : 
 *    output: 
 *
 * Approach 1: 
 * 
 * Approach 2: 
 *
 * Pseudo code - Approach 1:
 *
 * Time / Space Complexity:
 * 		
 */

public class Largest_String_Hacker_Rank {
	@Test
	public void example1() {
		int[] array  = {};
	}

	@Test
	public void example2() {
		String s = "azzzzz";
		getLargestString(s,2);
	}

	public static String getLargestString(String s, int k) {
		// Write your code here

		StringBuffer output = new StringBuffer();
		char[] s1 = s.toCharArray();
		Arrays.sort(s1); //zzzazz
		for (int i = 0; i < s1.length/2; i++) {
			char tmp = s1[i];
			s1[i] = s1[s1.length-1-i];
			s1[s1.length-1-i] = tmp;
		}

		List<Integer> remove = new ArrayList<Integer>();

		int left = 0, right = 1, counter = 0;
		while(right < s.length()){
			if(s.charAt(left) == s.charAt(right)){
				counter++;
				if(counter <= k){
					if((right+1 < s.length()) && (s.charAt(right) != s.charAt(right+1))) {
						char tmp = s1[right];
						s1[right] = s1[right+1];
						s1[right+1] = tmp;
					}else {
						remove.add(left);
						counter =0;
					}
				}
			} else{
				counter = 0;
			}
			left = right;
			right++;
		}


		for (int i = 0; i < s1.length; i++) {
			output.append(s1[i]);
		};


		return output.toString();
	}

}
