package dsa.hashing.algo;
import java.util.*;
import org.junit.*;

public class FindSecondLeastOccurrence {
	/* String s= amazon, find out what is the second least repeating char, 
	 * when all the matches are same return the second least char
	 * 
	 * Given Input  data type: String s = "amazon"
	 *       Output data type: Char n
	 *       
	 * Sample Test Data 
	 *    Input : 
	 *    output:
	 *
	 * Approach 1: Using For loop 3 pass
	 *
	 *
	 * Time / Space Complexity: O(n) / O(n)
	 * 		
	 */

	@Test
	public void test1() {
		String str = "amazon";
		Assert.assertTrue(getSecondMinOccrChar(str).equals('n'));
	}

	@Test
	public void test2() {
		String str = "aabbcd";
		Assert.assertTrue(getSecondMinOccrChar(str).equals('b'));
	}

	@Test
	public void test3() {
		String str = "aaaaa";
		Assert.assertTrue(getSecondMinOccrChar(str).equals('a'));
	}

	/*
	 * Pseudo Code:
	 * Declare two var min and secondMin and duplicate, secondMinChar
	 * Declare a ascii array to store the occurrence of the char in String
	 * Traverse the array in for loop to store the value in ascii array
	 * Assign the min value by comparing 0 char and 1 char with Math.min
	 * Assign the min value by comparing 0 char and 1 char with Math.max
	 * Assign secondMinChar = (min== value of 0th char)? 1st char : 0thchar
	 * Assign MinChar 		= (min== value of 0th char)? 0thchar : 1st char
	 * Traverse the string in for loop
	 * ----Check if 3rd char < min then
	 * --------secondMin = min, secondMinChar = minChar
	 * --------min = 3rd char and minChar = currentChar
	 * --------duplicate = false;
	 * ----else if 3rd is less than second main
	 * ---------then swap the var and secondMinChar = currentChar
	 * --------duplicate = false;
	 * ----else if second min == currentChar and !duplicate
	 * ---------duplicate = true;
	 * ---------check if currentChar > seconMin char
	 * ------------then swap the second min Value
	 * ------------secondMinChar = currentChar
	 * return the char
	 */
	
	private Character getSecondMinOccrChar(String str) {
		int min = 0, secondMin = 0;
		char minChar = ' ', secondMinChar = ' ';
		boolean duplicate = false;
		int[] charArray = new int[128];
		for(int i = 0;i<str.length();i++) {
			charArray[str.charAt(i)]++;
		}
		min = Math.min(charArray[str.charAt(0)], charArray[str.charAt(1)]);
		secondMin = Math.max(charArray[str.charAt(0)], charArray[str.charAt(1)]);
		minChar = (min==charArray[str.charAt(0)])? str.charAt(0) : str.charAt(1);
		secondMinChar = (min==charArray[str.charAt(0)])? str.charAt(1) : str.charAt(0);
		for(int i=2; i<str.length();i++) {
			if(charArray[str.charAt(i)]<min) {
				if ((min==secondMin && secondMin < min) || min < secondMin) {
					secondMin = min;
					secondMinChar = minChar;
					min = charArray[str.charAt(i)];
					minChar = str.charAt(i);
				}
			}else if (charArray[str.charAt(i)]<secondMin) {
				secondMin = charArray[str.charAt(i)];
				secondMinChar = str.charAt(i);
			}else if (charArray[str.charAt(i)] == secondMin) {
				if(str.charAt(i) < secondMinChar) {
					secondMin = charArray[str.charAt(i)];
					secondMinChar = str.charAt(i);
				}
			}
		}
		System.out.println(secondMinChar);
		return secondMinChar;
	}
}
















