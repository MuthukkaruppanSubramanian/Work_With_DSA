package dsa.two_pointer.sdte3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.junit.Assert;
import org.junit.Test;

public class LC_1748_Sum_Of_Unique_Elements {
	/*
 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - String Array
	 * What is the expected output? - int
	 * Do I have constraints to solve the problem? - No
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 * 
	 *
	 * 3) Do I know how to solver it?
	 *	Yes - great, Is there any alternate solution?
	 *	No - Can I break down the problem to sub problems?
	 *
	 * 4) Ask for the hint (If you don't know how to solve it)
	 *
	 *
	 * 5) Do I know alternate solution to solve this problem? - yes
	 *	Yes - What are those? Yes
	 *	No � That is still fine, proceed to solve by what you know !!
	 *  Simple Technique - > Brute Force !!
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 *  Approach 1: Hashing
	 *  
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 *
	 */

	//@Test
	public void test1() {
		int[] nums = {1,2,3,2};
		Assert.assertTrue(sumOfUnique(nums)==4);
	}

	@Test
	public void test2() {
		int[] nums = {1,1,1,1,1};
		Assert.assertTrue(sumOfUnique(nums)==0);
	}
	
	/*
	 * Pseudo Code:
	 * 
	 * Algorithm: Hashing
	 * 
	 * 1. Create a map with key and value as integer and sum = 0.
	 * 2. Iterate the nums in a for loop
	 * 3. ---add the element as key and its occurance as value
	 * 4. Iterate the Map
	 * 5. ---if the value is equal to 1
	 * 6. ------then add it to sum
	 * 10. return sum
	 * 
	 * Time Complexity: O(1)
	 * Space Complexity: O(n)
	 */
	
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> numbers = new HashMap<>(); int sum = 0;
        for(int i=0; i<nums.length;i++)numbers.put(nums[i],numbers.getOrDefault(nums[i],0)+1);
        for(Map.Entry<Integer, Integer> map : numbers.entrySet()) if(map.getValue() == 1) sum +=map.getKey();
        return sum;
    }

	/*
	 * Pseudo Code:
	 * 
	 * Algorithm: Hashing
	 * 
	 * 1. Create a map with key and value as integer and sum = 0.
	 * 2. Iterate the nums in a for loop
	 * 3. ---Create boolean var number exists and set is value based on numbers.containsKey(nums[i])
	 * 4. ---if numberExists and the count of that number is != 0
	 * 5. ------then reassign the count of that nums[i] to 0
	 * 6. ------then subtract the nums[i] from the sum.
	 * 7. ---else if number not exists
	 * 8. -------then store the nums[i] and count as 1 in map
	 * 9. -------then add it to sum
	 * 10. return sum
	 * 
	 * Time Complexity: O(1)
	 * Space Complexity: O(n)
	 */
	
    public int sumOfUnique1(int[] nums) {
        Map<Integer, Integer> numbers = new HashMap<>();
        int sum = 0;
        for(int i=0; i<nums.length;i++){
            boolean numberExists = numbers.containsKey(nums[i]);
            if(numberExists && numbers.get(nums[i]) != 0){
                numbers.put(nums[i],0);
                sum -= nums[i];
            }else if(!numberExists){
                numbers.put(nums[i],1);
                sum += nums[i];
            }
        }
        
        return sum;
    }
	
}

