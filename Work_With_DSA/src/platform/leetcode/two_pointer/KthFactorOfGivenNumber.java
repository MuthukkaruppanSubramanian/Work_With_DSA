package platform.leetcode.two_pointer;
import java.util.*;
import org.junit.*;

public class KthFactorOfGivenNumber {
	/* 
	 * 
	 * Given Input  data type:
	 *       Output data type:
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

	@Test
	public void test1() {
		int n = 1000, k = 3;
//		System.out.println(getKthFactorOfGivenN(n, k));
		Assert.assertTrue(getKthFactorOfGivenNUsingFor(n, k)==4);
	}

	@Test
	public void test2() {
		int n = 7, k = 2;
//		System.out.println(getKthFactorOfGivenN(n, k));
		Assert.assertTrue(getKthFactorOfGivenNUsingFor(n, k)==7);
	}

	@Test
	public void test3() {
		int n = 4, k = 4;
//		System.out.println(getKthFactorOfGivenN(n, k));
		Assert.assertTrue(getKthFactorOfGivenNUsingFor(n, k)==-1);
	}
	
	/*
	 * Pseudo Code:
	 * If the Kth factor is 1 return as 1
	 * Declare the count as 2 , output = 1
	 * Traverse the logic in count reaches output < k
	 * Declare a int dived and do n/count.
	 * if dived ==0 output++
	 * count++
	 */
	
	public int getKthFactorOfGivenN(int n, int k) {
		if(k==1) return 1;
		int count = 2, output = 1;
		while(output < k) {
			int reminder = n%count;
			if(reminder==0) output++;
			count++;
			if(count > n) break;
		}
		if(output!=k) return -1;
		return --count;
	}
	
	public int getKthFactorOfGivenNUsingFor(int n, int k) {
		for (int i = 1; i <=n; i++) {
			if(n%i == 0) k--;
			if(k==0) return i;
		}
		return -1;
	}
}






















