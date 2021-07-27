package dsa.two_pointer.algo;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseAString {
	
	//@Test
	public void test1() {
		String str =  "A man, a plan, a canal: Panama";
		System.out.println(isPanlindrome(str));
	}
	
	@Test
	public void test2() {
		String str =  "aaa43534";
		System.out.println(isPanlindrome(str));
	}
	
	@Test
	public void test3() {
		String str =  "4a a a4";
		System.out.println(isPanlindrome(str));
	}

	@Test
	public void test4() {
		String str =  "a-bC-dEf-ghIj";
		Assert.assertEquals("j-Ih-gfE-dCba",reverseString(str));
	}
	
	@Test
	public void test5() {
		String str =  "ad-cd";
		Assert.assertEquals("dc-da",reverseString(str));
	}
	
	@Test
	public void test6() {
		String str =  "Test1ng-Leet=code-Q!";
		Assert.assertEquals("Qedo1ct-eeLg=ntse-T!",reverseString(str));
	}
	public boolean isPanlindrome(String str) {		
		/*
		 * Given a string s, determine if it is a palindrome, considering only
		 * alphanumeric characters and ignoring cases.
		 * 
		 * Example 1: 
		 * Input: s = "A man, a plan, a canal: Panama" , Output: true
		 * Explanation: "amanaplanacanalpanama" is a palindrome. 
		 * Example 2: Input: s = "race a car" Output: false
		 * Explanation: "raceacar" is not a palindrome.
		 * 
		 * Pseudo code:
		 * 	a.Assign two pointer with value as 0 and last index
		 *  b.validate the give string with while conditon of left <= right
		 *  if both the pointer's char is same left++ and right--
		 *  c.if any of the pointer has char other A-z move that pointer to +1 position
		 *  d. when left > right loop break
		 *  
		 *  Time Complexity: O(n) / Space Complexity: O(1)
		 */
		int left = 0, right = str.length()-1;
		while(left <= right) {
			if(!Character.isLetterOrDigit(str.charAt(left))) left++;
			else if(!Character.isLetterOrDigit(str.charAt(right))) right--;
			else if(Character.toLowerCase(str.charAt(left))==Character.toLowerCase(str.charAt(right))) {
				left++;
				right--;
			}else if(Character.toLowerCase(str.charAt(left))!=Character.toLowerCase(str.charAt(right))) return false;
		}
		return true;
	}
	
	private String reverseString(String str) {
		/*
		 * Approach 2 Pseudo Code:
		 * 
		 * Ques: Reverse a string str = "Target" and other char should remains in same index
		 * 
		 * 
		 * Input: s = "ab-cd" Output: "dc-ba" 
		 * 
		 * Example 2: Input: s = "a-bC-dEf-ghIj"
		 * 				 Output: "j-Ih-gfE-dCba" 
		 * Example 3: Input: s = "Test1ng-Leet=code-Q!"
		 * 			     Output: "Qedo1ct-eeLg=ntse-T!"
		 * 
		 * Pseudo Code:
		 *  a.Convert the give str to char arr
		 *  b.have two pointer respectively start of each corner
		 *  c.Traverse the loop until left <=right
		 *  d.if value at left and right are letter then swap
		 *  e.else if any pointers value is not a letter then left++ / right--
		 */
		int left=0,right=str.length()-1;
		char[] newArray = str.toCharArray();
		while(left<=right) {
			if(Character.isLetter(newArray[left]) && Character.isLetter(newArray[right])) {
				char tmp = newArray[left];
				newArray[right--] = newArray[left];
				newArray[left++] = tmp;
			}else if(Character.isLetter(newArray[left])) left++;
			else right--;
		}
		System.out.println(Arrays.toString(newArray));
		return newArray.toString();
	}
}
