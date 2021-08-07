package platform.genric.dsa;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FindTotalMinDifferenceOfAdjacentSum {
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
	 * 
	 * 
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(-5,3,2,-7,-1));		Assert.assertTrue(minDiff(nums)==12);
	}

	@Test
	public void test2() {
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(-5,3,2,-7,-1));
		Assert.assertTrue(minDiff(nums)==10);
	}


    //sort array and difference
    public static int minDiff(List<Integer> arr) {
    // Write your code here
        int sum = 0;
        Collections.sort(arr);
        for (int i = 0; i < arr.size()-1; i++) {
            sum += Math.abs(arr.get(i+1) - arr.get(i));
            System.out.println(sum);
        }
        return sum;
    }
}
