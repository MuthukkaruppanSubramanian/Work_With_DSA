package two_pointer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesInArray {
	
    /*
    * a.For the give array have two pointers and  int k as output
    * b. K+2 if nums[left!=nums[right]]
    * c. traves the array in while loop with condition left <=right
    * d. if left != left-1 k++
    * e. if right != right+1 k++
    * f. return k
    *
    *
    *
    */
	
	@Test
	public void test1() {
		int[] nums = {1,1,2};
		Assert.assertEquals(2,removeDuplicateReturnTotalCountInOpp(nums));
		removeDuplicateInOpp(nums);
	}
	
	@Test
	public void test2() {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		Assert.assertEquals(5,removeDuplicateReturnTotalCountInOpp(nums));
		removeDuplicateInOpp(nums);
	}
    
	@Test
	public void test3() {
		int[] nums = {0,0,1,1,1,2,3,3,3,3};
		Assert.assertEquals(4,removeDuplicateReturnTotalCountInOpp(nums));
		removeDuplicateInOpp(nums);
	}
	
	public int[] removeDuplicateInOpp(int[] nums) {
		int[] uniqueArray = new int[nums.length];
	    int left = 0, right = 1, counter = 0, lastValue = Integer.MIN_VALUE;
	    while(right < nums.length) {
	    	if((nums[left] == nums[right]) && (lastValue != nums[left])) {
	    		uniqueArray[counter++] = nums[left];
	    		lastValue = nums[left];
	    	}else if((nums[left] != nums[right]) && (lastValue == nums[left])) {
	    		uniqueArray[counter++] = nums[right];
	    		lastValue = nums[right];
	    	}
	    	left +=2; right +=2;
	    	
	    }
	    System.out.println("Unqiue value:"+Arrays.toString(uniqueArray));
	    return uniqueArray;
	}
	
	public int removeDuplicateReturnTotalCountInOpp(int[] nums) {
	    int left = 0, right = nums.length-1, k= 0, counter = 0;
	    if(nums[left++]!= nums[right--]) k = 2;
	    while(left <= right){
	        if(nums[left]!=nums[left-1]) k++;
	        if(left==right) break;
	        if(nums[right] !=nums[right+1]) k++;
	        left++;
	        right--;
	    }
	    System.out.println("Unqiue value:"+k);
	    return k;
	}
	
	

}
