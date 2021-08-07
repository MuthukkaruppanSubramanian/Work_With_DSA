package platform.leetcode.two_pointer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;


public class AddIntAndIntArray {

	@Test
	public void test1() {
		int[] nums = {1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3};
		int k = 516;
		System.out.println(addToArrayFormList(nums, k));
	}
	
	@Test
	public void test2() {
		int[] nums = {2,1,6};
		int k = 805;//508
		System.out.println(addToArrayFormList(nums, k));
	}
	
	@Test
	public void test3() {
		int[] nums = {9,9,9,9,9,9,9,9,9,9};
		int k = 1;
		System.out.println(addToArrayFormList(nums, k));
	}
	
	@Test
	public void test4() {
		int[] nums = {0};
		int k = 23;
		System.out.println(addToArrayFormList(nums, k));
	}
	
	public List<Integer> addToArrayForm(int[] num, int k) {
		double sum = 0L;
		BigInteger arrayValue = new BigInteger(Arrays.toString(num));
		BigInteger s = BigInteger.valueOf(k);
		BigInteger finalValue = arrayValue.add(s);
		ArrayList<Integer> list = new ArrayList<>();
		
		Collections.reverse(list);
		return list;
	}
	
	public List<Integer> addToArrayFormList(int[] num, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		int sum = 0;
		while (k > 0) {
			list.add(k%10);
			k = k/10;
		}
		int carry = 0;
		int arrayIndex = num.length-1;// 216
		int listIndex = list.size()-1;//8805
		ArrayList<Integer> outputList = new ArrayList<>();
		while(arrayIndex >=0 || listIndex < list.size()){
			if(listIndex >= list.size()) {
				sum = carry+num[arrayIndex--];
			}else if(arrayIndex >=0 && listIndex < list.size()) {
				sum = carry+num[arrayIndex--]+list.get(listIndex++);
			}else if (listIndex < list.size()) {
				sum = carry+list.get(listIndex++);
			}
			outputList.add(sum%10);
			carry = sum/10;
		}
		if(carry > 0)outputList.add(carry);
		Collections.reverse(outputList);
		return outputList;
	}
	
    public List<Integer> addToArrayFormInt(int[] num, int k) {
		long sum = 0;
		int[] output = new int[num.length+1];

		for(int i=0; i< num.length; i++){
			sum = num[i]+(sum*10);
		}

		sum = sum+k;
		ArrayList<Integer> list = new ArrayList<>();
        if(sum == 0){
            list.add(0);
            return list;
        }
		while(sum>0) {
			list.add((int) (sum%10));
			sum = sum/10;
		}
		
		Collections.reverse(list);
		return list;
    }
}
