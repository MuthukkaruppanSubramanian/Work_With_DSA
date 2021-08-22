import java.util.*;
import org.junit.*;

public class Apple_Continuous_Subarray_Divisible_by_K {
	
	/*
	 * Sample Test Data 
	 *    Input : 
	 *    output: 
	 *
	 * Approach 1: 
	 * 
	 * Approach 2: 
	 * 
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		int[] nums = {23,2,4,6,6};
		int k = 6;
		Assert.assertTrue(isDivisibleByK(nums,k));
	}

	@Test
	public void test2() {
		int[] nums = {21,6,12,8,4};
		int k = 4;
		Assert.assertTrue(isDivisibleByK(nums,k));
	}

	@Test
	public void test3() {
		int[] nums = {23,2,6,4,7};
		int k = 13;
		Assert.assertFalse(isDivisibleByK(nums,k));
	}


	/*
	 * Pseudo code
	 * Declare a hash map
	 * Declare sum = 0, rem = 0
	 * Traverse the array in for loop until its length
	 * sum += array[i]
	 * if(sum==0) return true;
	 * get the modulus of rem by k if it is greater than 0 then rem = sum%k
	 * else rem = sum%k+k
	 * if map contains rem
	 * ------if(i-map.get(rem) > 1) return true
	 * return false
	 */

	private boolean isDivisibleByK(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0, rem = 0;
		for (int i = 0; i < nums.length; i++) {
			
			sum += nums[i];
			if(sum ==0) return true;
			//for negative number sum%k will be less than 0, then we have to add k else sum%k
			rem = ((sum%k) < 0) ? (sum%k)+k : sum%k;
			
			//check rem exists in map else add it
			if(map.containsKey(rem)) {
				if(i-map.get(rem) > 1) return true;
			} else map.put(rem, i);
			sum = rem;
		}
		return false;
	}
	
}
