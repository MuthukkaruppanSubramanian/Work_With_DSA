package platform.leetcode.two_pointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class LC_Map_Values {
	/* 
	 * 
	 * Given Input  data type: String a = abbccaadf, int[] target = [4,2,5,3,7]
	 *       Output data type: [true,true,false,true,false]
	 *       
	 * Sample Test Data 
	 *    Input : 5
	 *    output: ["1","2","Fizz","4","Buzz"]
	 *
	 *	Constrain: Hashmap and Two Pointer approach
	 *
	 * Approach 1: Two Pointer
	 *
	 * 8:50 to 8:85 - logic thinking
	 * 
	 * Time / Space Complexity: O(n) / O(n)
	 * 		
	 */
	
	@Test
	public void test1() {
		String a = "abbccaadf"; int[] target = {4,2,5,3,7};
		System.out.println(containsTargetValue(a,target));
	}


	@Test
	public void test2() {
		String a = "bbbccaadf"; int[] target = {1,2,5,3,6};
		System.out.println(containsTargetValue(a,target));
	}

	@Test
	public void test3() {

	}
	
	//8:55 - 9:07
	/*
	 * Declare a HashMap for a-z with values 1to26.
	 * Declare two pointers left = 0 and right = 1;
	 * Declare a set
	 * Traverse the string in while until right reaches the length of the string
	 * --check if (left char != right char)
	 * ------then add the value of leftchar from defaultmap
	 * ------left = right and rigth++
	 * else if leftchar and rightchar are same
	 * ------if right-left == 1
	 * --------then add the value of leftchar from defaultmap
	 * ------else  add the (value * right-left+1)
	 * ------right++;
	 * 
	 * Iterate the array and check if it contains in set then return true else false
	 */
	//9:07 to 9:15
	//9:15 to 9:30
	private boolean[] containsTargetValue(String a, int[] target) {
		Set<Integer> set = new HashSet<>();
		int left = 0, right = 1;
		boolean[] output = new boolean[target.length];
		set.add((a.charAt(0)-'a')+1);
		while(right < a.length()) {
			if(a.charAt(left)!=a.charAt(right)) {
				left = right;
				right++;
				set.add((a.charAt(left)-'a')+1);
			}else {
				int t = ((a.charAt(left)-'a')+1)*((right-left)+1);
				set.add(t);
				right++;
			}
		}
		for (int i = 0; i < target.length; i++) {
			output[i] = set.contains(target[i]);
		}
		System.out.println(Arrays.toString(output));
		return output;
	}
}
