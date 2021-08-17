package platform.leetcode.two_pointer;

import java.util.*;
import org.junit.*;


public class LC_415_Add_Strings {

	/* 
	 * 
	 * Given Input  data type: String a = abbccaadf, int[] target = [4,2,5,3,7]
	 *       Output data type: [true,true,false,true,false]
	 *       
	 * Sample Test Data 
	 *    Input : 5
	 *    output: ["1","2","Fizz","4","Buzz"]
	 *
	 *	Constrain: Hashmap and Two Pointer approach
	 *
	 * Approach 1: Two Pointer
	 *
	 * 8:50 to 8:85 - logic thinking
	 * 
	 * Time / Space Complexity: O(n) / O(n)
	 * 		
	 */

	@Test
	public void test1() {
		String s1 = "11", s2 = "123";
		Assert.assertTrue(addStrings(s1, s2).equals("134"));
	}

	@Test
	public void test2() {
		String s1 = "0", s2 = "123";
		Assert.assertTrue(addStrings(s1, s2).equals("123"));
	}

	@Test
	public void test3() {
		String s1 = "11", s2 = "0";
		Assert.assertTrue(addStrings(s1, s2).equals("11"));
	}
	
    //7:48 - 8:00
    //if left pointer is less than 0
    //...then add the right pointer value with carry and add to string
    //else if right pointer is less than 0
    //....then add left pointer value with carry and add to string
    //else
    //....Sum the last two digits with carry
    //append the modulus of 10 to output string
    //carry should be sum/10
    //return the string

    public String addStrings(String num1, String num2) {
        int carry = 0, sum = 0, left = num1.length()-1, right = num2.length()-1;
        String output = "";
        while(left >= 0 || right >= 0){
            if(left < 0){
                sum = (num2.charAt(right)-'0')+carry;
            }else if (right < 0){
                sum = (num1.charAt(left)-'0')+carry;
            }else{
                sum = (num2.charAt(right)-'0') + (num1.charAt(left)-'0')+carry;
            }
            left--;
            right--;
            output = sum%10+""+output;
            carry = sum/10;
        }
        if(carry > 0) output = carry+""+output;
        return output;
    }
}
