package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_05_Largest_Number_After_Mutating_Substring_LC_1946 {
	
	/*
	 * https://leetcode.com/problems/largest-number-after-mutating-substring/
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
		String num = "132";
		int[] change = {9,8,5,0,3,6,4,2,6,8};
		maximumNumberToCharArray(num, change);
	}

	@Test
	public void test2() {
		String num = "9303333";
		int[] change = {9,8,5,0,3,6,4,2,6,8};
		maximumNumberToCharArray(num, change);
	}

	@Test
	public void test3() {
		String num = "23";
		int[] change = {7,7,3,6,0,2,6,0,6,4};
		maximumNumberToCharArray(num, change);
	}
	
	/*
	 * Pseudo Code - Approach 2
	 * Convert the string to char array
	 * traverse the char array in for loop till length
	 * ---if number[i] < the value of change index of number i
	 * ------then replace the char
	 * ------set the flag to true, so when the next greater number 
	 * 		 occurs we can break the loop
	 * ---else if number[i] == change[number[i]]
	 * ----------continue
	 * ---else
	 * --------if flag set to true break, else continue;
	 * return number as string
	 */
	
    public String maximumNumber(String num, int[] change) {
    	StringBuffer sb = new StringBuffer(num);
    	boolean modified = false;
        for(int i = 0; i < num.length(); i++){
            if(sb.charAt(i)-'0' < change[sb.charAt(i)-'0']){
                sb.replace(i, i+1, change[sb.charAt(i)-'0']+"");
                modified = true;
            }else if(sb.charAt(i)-'0' == change[sb.charAt(i)-'0']){
                continue;
            }else {
            	if (modified)
            		break;
            }
        }
        return sb.toString();
    }
    
    public String maximumNumberToCharArray(String num, int[] change) {
    	char[] number = num.toCharArray();
    	boolean modified = false;
        for(int i = 0; i < number.length; i++){
        	if(number[i]-'0' < change[number[i]-'0']) {
        		number[i] = (char) (change[number[i]-'0']+'0');
        		modified = true;
        	}else if(number[i]-'0' == change[number[i]-'0']) {
        		continue;
        	}else {
        		if(modified)
        			break;
        	}
        }
        return new String(number);
    }
}
