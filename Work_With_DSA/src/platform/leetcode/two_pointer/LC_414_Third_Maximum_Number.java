package platform.leetcode.two_pointer;

import org.junit.Assert;
import org.junit.Test;

public class LC_414_Third_Maximum_Number {

	
	private static final Class<RuntimeException> expected = null;
	@Test
	public void test1() {
		int[] nums = {3,2,1};
		Assert.assertTrue(getThirdMax(nums) == 1);
	}

	@Test
	public void test2() {
		int[] nums = {3,2,1,4};
		Assert.assertTrue(getThirdMax(nums) == 2);
	}
	
	@Test
	public void test3() {
		int[] nums = {2,2,2,1};
		Assert.assertTrue(getThirdMax(nums) == 2);
	}

	@Test
	public void test4() {
		int[] nums = {1,2,-2147483648};
		System.out.println(Integer.MIN_VALUE);
		Assert.assertTrue(getThirdMax(nums) == Integer.MIN_VALUE);
	}
	
	private int getThirdMax(int[] nums) {
        //If array size is 1 then return nums[0]
        //Declare three variables max, smax, tmax
        //Get the first two values compare and assign max and smax
        //if array size is 2 then return smax
        //check the 3rd value is grater than max
        //.....if yes then tmax = smax, smax=max, max=3rvalue
        //else check 3rd value is greater than smax
        //...if yes then tmax=smax and smax = currentmax
        //else if  max==3rd || smax==rd {}
        //else tmax = currrentmax
        if(nums.length==1) return nums[0];
        int max = Integer.MIN_VALUE, smax = Integer.MIN_VALUE, tmax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        max = Math.max(nums[0],nums[1]);
        min = Math.min(nums[0], nums[1]);
        for (int i = 0; i < nums.length; i++) {
			if(nums[i] > max) {
				smax = max;
				max = nums[i];
			}else if(nums[i] > smax && nums[i] != max) {
				smax = nums[i];
			}
			min = Math.min(nums[i], min);
		}
        if(nums.length==2) return nums[1];
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                tmax = smax;
                smax = max;
                max = nums[i];
            }else if(nums[i]>=smax && nums[i] != max){
                tmax = smax;
                smax = nums[i];
            }else if (nums[i] >= tmax && nums[i] != smax && nums[i] !=max){
                tmax = nums[i];
            }
        }
        if(tmax == Integer.MIN_VALUE || smax == Integer.MIN_VALUE) return max;
        return tmax;
	}

}
