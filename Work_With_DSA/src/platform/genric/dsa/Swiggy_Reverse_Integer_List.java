import org.junit.*;
import java.util.*;

public class Swiggy_Reverse_Integer_List {
	
	/* List of integer given as input -> reverse the list and send
	 * 
	 * Sample Test Data 
	 *    Input : [1,2,5,6]
	 *    output: [6,5,2,1]
	 *
	 * Approach 1: Two pointer
	 * 
	 *
	 * Time / Space Complexity: O(n) /O(n)
	 * 		
	 */
	
	@Test
	public void test1() {
		List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,5,6));
		Assert.assertEquals(reverTheList(nums), new ArrayList<>(Arrays.asList(6,5,2,1)));
	}

	@Test
	public void test2() {
		List<Integer> nums = new ArrayList<>(Arrays.asList());
		Assert.assertEquals(reverTheList(nums), new ArrayList<>(Arrays.asList()));
	}

	@Test
	public void test3() {
		List<Integer> nums = new ArrayList<>(Arrays.asList(1,0,0,1));
		Assert.assertEquals(reverTheList(nums), new ArrayList<>(Arrays.asList(1,0,0,1)));
	}

	/* 11:21 - 11:30
	 * Pseudo Code
	 * Declare two pointer left = 0 and right = array.length-1
	 * traverse the list in while loop until left <= right
	 * create a temp variable and swap the values
	 * return list
	 */
	
	/**
	 * @param nums
	 * @return
	 */
	private List<Integer> reverTheList(List<Integer> nums) {
		int left = 0, right = nums.size()-1;
		while(left <= right) {
			int tmp = nums.get(right);
			nums.set(right--, nums.get(left));
			nums.set(left++, tmp);
		}
		return nums;
	}
}
