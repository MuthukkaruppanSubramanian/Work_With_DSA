package com.two_pointer.algo;

import java.util.Arrays;

import org.junit.Test;

public class P23_Remove_Duplicates {

	@Test
	public void test1() {
		int[] data = {1,2,3,4,1,2,3};//1 1 2 2 3 3 4
		System.out.println(Arrays.toString(removeDuplicates(data)));
	}

	private int[] removeDuplicates(int[] data) {
		// TODO Auto-generated method stub
		int left = 0, right = 1;
		Arrays.sort(data);
		while(right < data.length) {
			if(data[left] != data[right]) {
				int tmp = data[right];
				data[right] = data[left++];	//Increment the left to store value in next index
				data[left] = tmp;
			}
			right++;
		}
		return Arrays.copyOfRange(data, 0, left+1);
	}
	
	
}
