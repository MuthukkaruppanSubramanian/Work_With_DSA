package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P22_Palindrome_LC_9 {
	
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
		System.out.println(isPalindrome(-121));
	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code
	 */
	
    public boolean isPalindrome(int x) {
        int result = 0;
        int n = x;
        while(n > 0){
            result =(result*10)+n%10;
            n = n/10;
        }
        return x == result;
    	//String tmp = x+"";
        //StringBuilder sb = new StringBuilder(tmp);
//        if(sb.charAt(0)=='-'){
//            sb.deleteCharAt(0).reverse();
//            sb.insert(0,'-');
//        }
        //return tmp.equals(sb.reverse().toString());
    }
}
