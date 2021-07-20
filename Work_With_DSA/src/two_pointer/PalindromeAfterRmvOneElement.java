package two_pointer;

import org.junit.Test;

public class PalindromeAfterRmvOneElement {

	@Test
	public void test1() {
		String str = "eedede";
		System.out.println(isPanlindromeAfter(str));
		;
	}

	@Test
	public void test2() {
		String str = "abca";
		System.out.println(isPanlindromeAfter(str));
		;
	}

	@Test
	public void test3() {
		String str = "abc";
		System.out.println(isPanlindromeAfter(str));
	}

	@Test
	public void test4() {
		String str = "cbbcc";
		System.out.println(isPanlindromeAfter(str));
	}
	
	@Test
	public void test5() {
		String str = "edeeee";
		System.out.println(isPanlindromeAfter(str));
	}
	
	@Test
	public void test6() {
		String str = "deeee";
		System.out.println(isPanlindromeAfter(str));
	}
	
	@Test
	public void test7() {
		String str = "adceea";
		System.out.println(isPanlindromeAfter(str));
	}
	
	@Test
	public void test8() {
		String str = "ebcbbececabbacecbbcbe";
		System.out.println(isPanlindromeAfter(str));
	}
	
	@Test
	public void test9() {
		String str = "eeccccbebaeeabebccceea";
		System.out.println(isPanlindromeAfter(str));
	}
	
	public boolean isPanlindromeAfter(String str) {		
		
         /*		Given a string s, return true if the s can be palindrome after deleting at most one character from it.
				Example 1: 

					Input: s = "aba"
					Output: true
					Example 2:

					Input: s = "abca"
					Output: true
					Explanation: You could delete the character 'c'.
					Example 3:

					Input: s = "abc"
					Output: false
		
		 * Pseudo code:
		 * 	a.Assign two pointer with value as 0 and last index
		 *  b.Traverse the with loop until condition left <= right 
		 *  c.if left and right matches left++ and right --
		 *  c.else if counter == 1 reutrn false else do right ++ and check if left and right matches
		 *  d.then increase counter to 1 and do left ++ right --
		 *  e.else do left ++ and right ++
		 *  f. check if left and right are same then left ++ right --
		 *  
		 *  Time Complexity: O(n) / Space Complexity: O(1)
		 */
		int left = 0, right = str.length()-1, count = 0, lastUnMatchLeft = -1, lastUnMatchRight = -1;
		while(left <= right) {
			if(str.charAt(left)==str.charAt(right)) {
				left++;	right--;
			}else{
				count++;
				if(count == 1) {
					lastUnMatchLeft = left;
					lastUnMatchRight = right;
					right--;
				}else if(count == 2) {
					left = lastUnMatchLeft+1;
					right = lastUnMatchRight;
				}else return false;
			}
		}
		return true;
	}
	
	
    public boolean validPalindrome(String str) {
		int left = 0, right = str.length()-1, count = 0, lastUnMatchLeft = -1, lastUnMatchRight = -1;
		while(left <= right) {
			if(str.charAt(left)==str.charAt(right)) {
				left++;	right--;
			}else{
				
				if(count == 1) {
					left = lastUnMatchLeft;
					right = lastUnMatchRight;
					left++; count++;
				}else {
					lastUnMatchLeft = left; lastUnMatchRight = right;
					if(count > 2) return false;
					count++; right--;
				}
				if(str.charAt(left)==str.charAt(right)) {
					left++;	right--;
				}else {
					if(count > 2) return false;
					right++;left++;
                    if(right >= str.length()) right--;
					if(str.charAt(left)==str.charAt(right)) {
						left++;	right--;
					}else return false;
				}
			}
		}
		return true;
    }
}
