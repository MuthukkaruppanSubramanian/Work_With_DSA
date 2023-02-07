import java.util.*;
import org.junit.*;

public class Apple_Swap_Two_To_Get_Biggest_Num {

	/*
	 * Swap any two digits to get the biggest number
 
Example 1:
Input: num = 2736. 
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: num = 9973
Output: 9973
Explanation: No swap.
1996-9916
	 */


	@Test
	public void test1(){
		int num=2736;
		Assert.assertEquals(7236,findMaxNum(num));
	}


	@Test
	public void test2(){
		int num=2176;
		char[] c = Integer.toString(num).toCharArray();
		Assert.assertEquals(7126,findMaxNum(num));
	}


	@Test
	public void test3(){
		int num=1996;
		Assert.assertEquals(9916,findMaxNum(num));
	}

	@Test
	public void test4(){
		int num=9973;
		Assert.assertEquals(9973,findMaxNum(num));
	}

	@Test
	public void test5(){
		int num=98419;
		Assert.assertEquals(99418,findMaxNum(num));
	}

	/*
	 * convert int to list
	 * Initialize left as 0 right as 1 current max as 0 index as -1
	 * Traverse the list in while loop right less than array length
	 * if list.get(L) > list.get(R) and r equals list.size-1
	 * 		Left++ and Right=left
	 * else currentMax less than list.get(R) 
	 * 		currentMax=list.get(R) 
	 * 		index=right
	 * right++
	 *
	 * if index !=-1
	 * swap the values

	 */

	private int findMaxNum(int num) {

		List<Integer> list =new ArrayList<Integer>();
		int number = num;
		while(number>0){			
			int temp=number%10;
			number=number/10;
			list.add(0,temp);
		}
		int left=0,right=1,currentMax=0,index=-1;
		for ( left = 1; left < list.size(); left++) {//989
			if(list.get(left)>list.get(left-1)){
				break;
			}			
		}
		if(left==list.size()) return num;

		for (int i = left; i < list.size(); i++) {
			if(list.get(i)>=currentMax){
				currentMax=list.get(i);
				right=i;
			}

		}
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)<currentMax){
				int temp=list.get(i);
				list.set(i, list.get(right));
				list.set(right, temp);
				break;
			}		
		}

		int result = 0;
		for (Integer integer : list) {
			result = (result*10)+integer;
		}
		System.out.println(result);
		return result;
	}

}
