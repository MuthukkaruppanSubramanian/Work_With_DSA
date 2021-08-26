import java.util.ArrayList;

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

/**
 * @author 60026865
 *
 */
public class Max_For_Jump_Brute_Force {
	@Test
	public void example1() {
		int[] nums = {6,13,10,8,11,7,3,5,2};
		System.out.println(maxFrogJumps(nums));
	}
	
	@Test
	public void example2() {
		int[] nums = {6,4,5,4,3,2,1};
		System.out.println(maxFrogJumps(nums));
	}
	
	@Test
	public void example3() {
		int[] nums = {5,7,11,9,10,7,6,3,5,2,1};
		System.out.println(maxFrogJumps(nums));
	}
	
	@Test
	public void example4() {
		int[] nums = {5,7,16,9,10,15,14,13,12,7,6,3,5,2,1};
		System.out.println(maxFrogJumps(nums));
	}
	
	public static int maxFrogJumps(int[] nums){
		ArrayList<Integer> sub = new ArrayList<>();
		sub.add(nums[0]); //6,13,10,8,11,7,3,5,4,2

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (num < sub.get(sub.size() - 1)) { // 5 < 3
				sub.add(num); // 13, 10 , 8, 7, 3
			} else {
				// Find the first element in sub that is greater than or equal to num
				int j = 0; //
				while (num < sub.get(j)) { // 13 10 8 7 3     - 5
					j += 1;
				}
				if(j == sub.size()-1) // 4 == 4
					sub.set(j, num); // 4, 5
			}
		}

		return sub.size()-1;
	}
}
