package platform.hacker_rank.problems;

import org.junit.Assert;
import org.junit.Test;

public class Hacker_Rank_Caesar_Cipher {
	/*
	 * Original alphabet:      abcdefghijklmnopqrstuvwxyz
	   Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc
	 *
	 * Sample Test Data 
	 *    Input : 
	 *    output: 
	 *
	 * Approach 1: two pointer
	 * 
	 * Approach 2: 
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		String str = "middle-Outz";
		Assert.assertTrue(encodedString(str, 2).equals("okffng-Qwvb"));
	}

	@Test
	public void test2() {
		String str = "abcdefghijklmnopqrstuvwxyz";
		Assert.assertTrue(encodedString(str, 3).equals("defghijklmnopqrstuvwxyzabc"));
	}

	@Test
	public void test3() {
		String str = "abcdefghijklmnopqrstuvwxyz";
		Assert.assertTrue(encodedString(str, 2).equals("cdefghijklmnopqrstuvwxyzab"));
	}

	@Test
	public void test4() {
		String str = "cba";
		Assert.assertTrue(encodedString(str, 100).equals("yxw"));
	}

	@Test
	public void test5() {
		String str = "159357lcfd";
		Assert.assertTrue(encodedString(str, 98).equals("159357fwzx"));
	}
	
	/*
	 * Declare two pointer left and right
	 * Declare a hash map with key as ascii value and value as A-z char
	 * Traverse the string in while loop until left <= right
	 * 
	 * Approach 2:
	 * Declare a hash map with ascii value and char
	 * declare output string, char d
	 * Travesre the string in for loop
	 * charToMinuz =  if currentChar is uppercase then 'AZ' else 'az'
	 * if(currentChar+k <= charToMinuz.charat(1)) output.append(currentChar+k)
	 * else
	 * ---if k <= 26 d = currentChar+k-cahrToMinus.charat(1)+.charat(0)  
	 * ---else d = (k%26)+1;
	 * return output
	 * 
	 */
	
	public String encodedString(String s, int k) {
		StringBuilder output = new StringBuilder();
		char d = ' ';
		String caseChar = "";
		for (int i = 0; i < s.length(); i++) {
			caseChar = (Character.isUpperCase(s.charAt(i)))? "AZ" : "az";
			if(!Character.isLetter(s.charAt(i))) output.append(s.charAt(i));
			else if((s.charAt(i)+k) <= caseChar.charAt(1)) {
				d = (char) (s.charAt(i)+k);
				output.append(d);
			}else {
				if(k <= 26) d = (char) ((s.charAt(i)+k)-(caseChar.charAt(1))+(caseChar.charAt(0))-1);
				else {
					int tmp = Math.abs((k-Math.abs(s.charAt(i)-caseChar.charAt(1)))%26);
					d = (tmp%26 == 0)?(char) caseChar.charAt(1) : (char) (tmp%26+(caseChar.charAt(0))-1);
				}
				output.append(d);
			}
		}
		System.out.println(output);
		return output.toString();
	}
}
