package com.two_pointer.algo;

import java.util.Arrays;

import org.junit.Test;

public class P24_Move_Ones_To_Left {

	@Test
	public void test1() {
		int[] data = {1,2,1,4,1,2,1};//1 1 2 2 3 3 4
		System.out.println(Arrays.toString(moveAllTheOnes(data)));
	}

	private int[] moveAllTheOnes(int[] data) {
		// TODO Auto-generated method stub
		int left = 0, right = data.length-1;
		while(left < right) {
			if(data[left] == 1 && data[right] !=1) {
				int tmp = data[right];
				data[right--] = data[left];
				data[left++] = tmp;
			}else if(data[left] != 1) left++;
			else if(data[right] == 1) right--;
		}
		return data;
	}
}
