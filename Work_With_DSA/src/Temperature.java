import java.util.*;
import org.junit.*;

public class Temperature {
	/* 
	 * 
	 * Given Input  data type: int[] {32,33,34,31,28,36,37}
	 *       Output data type: int[] {1,1,3,2,1,1,0}
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

	//@Test
	public void test1() {
		int[] tmp = {32,33,34,31,28,36,37};
		Assert.assertTrue((Arrays.equals(findincreaseTmpTwoPointer(tmp),new int[] {1,1,3,2,1,1,0})));
	}

	@Test
	public void test2() {
		int[] tmp = {32,31,30,29,28,27,26};
		Assert.assertTrue((Arrays.equals(findincreaseTmpTwoPointer(tmp),new int[] {-1,-1,-1,-1,-1,-1,0})));
	}

	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code:
	 * Declare two pointer and int[] with size of given array
	 * Left pointer starts as 0 and right as 1
	 * Traverse the array in while loop break when left < tmp.length-1
	 * ---check if tmp[right]> tmp[left] then
	 * ------output[index++] = right-left
	 * ------right = left+1
	 * ------left++
	 * ---else do right++
	 * ---if right == nums.length and output[index] ==0 output[index] = -1
	 * return output array  
	 */
	
	private int[] findincreaseTmpTwoPointer(int[] tmp) {
		int left = 0, right = 1, index = 0;
		int[] days = new int[tmp.length];
		while(left < tmp.length-1) {
			if(tmp[right] > tmp[left]) {
				days[index++] = right-left;
				right = left+1;
				left++;
			}else right++;
			if(right == tmp.length) {
				days[index++] = -1;
				right = left+1;
				left++;
			}
		}
		System.out.println(Arrays.toString(days));
		return days;
	}
	
	/*
	 * Declare a stack and int[] output array
	 * Traverse the array in for loop from last index
	 * if stack.empty then push the output at index as 0
	 * else if currenttmp <  last tmp pushed to stack
	 * --------then output[i] = stack.peek-i
	 * --------stack.push(i)
	 * -----else in while loop check if stack is not empty and last pushed tmp is less than current tmp
	 * 			do pop until the condition breaks
	 * -----else subtract stack.peek - 1 and add the output to array[i]
	 * -----when condition breaks check if stack is empty then output[i]=0 
	 * -----then push i to stack
	 * return the array
	 */
	
	private int[] findincreaseTmpStack(int[] tmp) {
		Stack<Integer> stack = new Stack<>();
		int[] days = new int[tmp.length];
		stack.push(tmp.length-1);
		for(int i=tmp.length-2; i<=0; i--) {
			if(tmp[i]<tmp[stack.peek()]) {
				days[i] = stack.peek()-i;
			}
		}
		return days;
	}
}






















