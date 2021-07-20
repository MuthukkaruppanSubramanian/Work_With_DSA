package problem_solving_genric;

public class ReverseAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * // TODO Auto-generated method stub
		 * 
		 * 1) Did I understand the problem? Yes or No !! - Yes 
		 * -> If No, Ask the person to provide more detail with example(s) 
		 * -> If yes, go to next step !!
		 * 
		 * What is the input(s)? - String
		 * What is the expected output? - String
		 * Do I have constraints to solve the problem? - No
		 * Do I have all informations to go to next step!!
		 * How big is your test data set will be?
		 *
		 *
		 *2) Test Data Set
		 *  Minimum of 3 data set !! Positive		/*
		 * // TODO Auto-generated method stub
		 * 
		 * 1) Did I understand the problem? Yes or No !! - Yes 
		 * -> If No, Ask the person to provide more detail with example(s) 
		 * -> If yes, go to next step !!
		 * 
		 * What is the input(s)? - String
		 * What is the expected output? - String
		 * Do I have constraints to solve the problem? - No, IS the string are case sensitive
		 * Do I have all informations to go to next step!!
		 * How big is your test data set will be?
		 *
		 *
		 *2) Test Data Set
		 *  Minimum of 3 data set !! 
		 *  Positive - "Start","Bowl"
		 *  Edge 	 = "asd315%ASF"
		 *  Negative = "","12000","Noon"
		 *  Validate the data set with the interviewer 
		 *
		 *3) Do I know how to solver it?
		 *	Yes - great, Is there any alternate solution?
		 *	No - Can I break down the problem to sub problems?
		 *
		 *4) Ask for the hint (If you don't know how to solve it)
		 *
		 *
		 *5) Do I know alternate solution to solve this problem? 
		 *
		 */
		
		//Method 1
		String name = "asd315%ASF";
		String reversedStr = "";
		for(int i=name.length()-1; i >=0; i--) {
			reversedStr += name.charAt(i);
		}
		
		System.out.println("Reversed String 1st Method: " + reversedStr);
		
		//Method 2
		char [] chArray = name.toCharArray();
		String reversedStr1 = "";
		for(int i=name.length()-1; i >=0; i--) {
			reversedStr1 += chArray[i];
		}
		
		System.out.println("Reversed String 2nd Method: " + reversedStr1);
		
		//Method 3 Using String Builder
		StringBuilder _name = new StringBuilder(name);
		StringBuilder reversedStr2 = _name.reverse();
		System.out.println("Reversed String 3rd Method: " + reversedStr2);
		
		
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
		 */
		
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
		 *  if both the pointer's char is same increment both pointer
		 *  c.if any of the pointer has char other A-z move that pointer to +1 position
		 *  d. when left > right loop break
		 *  
		 *  Time Complexity: O(n) / Space Complexity: O(1)
		 */
		
	
	}

}
