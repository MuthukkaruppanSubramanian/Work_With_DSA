package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P26_Rotate_The_Digit {
	
	/*
	 * 
	 *
	 * Sample Test Data 
	 *    Input : 
	 *    output: 
	 *
	 * Approach 1: Test_Template.java
	 * 
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		System.out.println(rotateTheDigit(1234,4));
	}


	@Test
	public void test2() {
		System.out.println(rotateTheDigit(1234,2));
	}

	@Test
	public void test3() {
		System.out.println(rotateTheDigit(1234567,2));
	}
	public int power = 0;
	/*
	 * Pseudo Code
	 * Create a generic function to reverse the digit
	 * call the generic function to reverse the full digit
	 * call the generic function to reverse of digit/10^k
	 * call the generic function to reverse of digit%10^k
	 */
	private int rotateTheDigit(int num, int j) {

		num  = reverseTheDigit(num);
		int  square= (int) (Math.pow(10, power-j));
		int output = (reverseTheDigit(num/square)*(square));
		output += reverseTheDigit((int) (num%square));
		return output;
	}
	
	public int reverseTheDigit(int num) {
		int output = 0;
		while(num > 0) {
			int mod = num%10;
			output = (output*10)+mod;
			num /=10;
			power++;
		}
		return output;
	}




}
