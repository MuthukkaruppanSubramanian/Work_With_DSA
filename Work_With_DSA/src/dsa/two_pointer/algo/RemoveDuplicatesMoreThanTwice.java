package dsa.two_pointer.algo;

import org.junit.Test;

public class RemoveDuplicatesMoreThanTwice {

	/*
	 * Input is int [] and output in int
	 * 
	 * Sample Test Data:
	 * 
	 * intput = {0,1,1,2,2,2,3} => output is 6
	 * 
	 * Approach 1: Using nested for loop as Brute Force
	 * Time / Space Complexity: O(n^2)/O(1)
	 * 
	 * Approach 2: Two Pointer
	 * Time / Space Complexity: O(n)/O(1)
	 * 
	 * Pseudo Code - Approach 1:
	 * a.Create two var count as output and lastMatchedValue
	 * b.The outer for loop should with i=0 till array length
	 * c.inside that check if i is the lastIndex and if lastMatchedValue==i then break
	 * d.otherwise increase the count+1
	 * e.inner for loop should start with j=i+1 till array length
	 * f.if i==j then increase the count by 2 and lastmatchedValue = i
	 * g.else if j+1 >= arr.length then assign i=j and break
	 * h.Otherwise i==lastMatchedValue and j==j+1 then i=j break
	 * i.else count +1 and i=j+1
	 * k.return count 
	 * 
	 */
	
	//@Test
	public void test1() {
		int[] num = {1,1,2,2,2,3};
		countVarwithAtMostTwoOccrrenceTwoPointer(num);
	}
	
	//@Test
	public void test2() {
		int[] num = {0,0,1,1,1,1,2,3,3};
		countVarwithAtMostTwoOccrrenceTwoPointer(num);
	}
	
	@Test
	public void test3() {
		int[] num = {1,2,3};
		countVarwithAtMostTwoOccrrence(num);
	}
	
	public int countVarwithAtMostTwoOccrrence(int[] num) {
		int count = 0, lastMatchedValue=Integer.MAX_VALUE;
		for (int i = 0; i < num.length-1; i++) {
			for (int j = i+1; j < num.length; j++) {
				if(num[i]==num[j] && num[i]!=lastMatchedValue) {
						count +=2;
					lastMatchedValue = num[i];
				}
				else if(num[i]!=num[j]) {
					if(j+1 >= num.length) {
						i=j;
						if(num[j]!=lastMatchedValue) count++; 
						break;
					}
					if(num[i]==lastMatchedValue && num[j]==num[j+1]) {
						i=j-1;break;
					}else {
						count++;
						i=j;
						break;
					}
				}
			}
		}
		if(lastMatchedValue==Integer.MAX_VALUE) count = num.length;
		return count;
	}
	
	
	public int countVarwithAtMostTwoOccrrenceTwoPointer(int[] num) {
		int count = 0, lastMatchedValue=Integer.MAX_VALUE, left=0, right=1;
		while(right < num.length) {
			if(num[left]==num[right] && num[left]!=lastMatchedValue) {
				count +=2;
				lastMatchedValue = num[left];
				right++;
			}
			else if(num[left]!=num[right]) {
				if(right+1 >= num.length) {
					left=right;
					if(num[right]!=lastMatchedValue) count++; 
					break;
				}
				if(num[left]==lastMatchedValue && num[right]==num[right+1]) {
					left=right;
					right++;
				}else {
					count++;
					left=right+1;
					right += 2;
				}
			}else right++;
		}
		if(lastMatchedValue==Integer.MAX_VALUE) count = num.length;
		return count;
	}
}
