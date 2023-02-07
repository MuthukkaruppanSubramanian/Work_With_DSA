package dsa.two_pointer.sdte3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.junit.Assert;
import org.junit.Test;

public class LC_771_Jewels_And_Stones {
	/*
		You're given strings jewels representing the types of stones that are jewels, and stones representing
		 the stones you have. Each character in stones is a type of stone you have. You want to know how many of 
		 the stones you have are also jewels.
		
		Letters are case sensitive, so "a" is considered a different type of stone from "A".
	 * 
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - Strings
	 * What is the expected output? - String
	 * Do I have constraints to solve the problem? - No
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 * 
	 *
	 * 3) Do I know how to solver it?
	 *	Yes - great, Is there any alternate solution?
	 *	No - Can I break down the problem to sub problems?
	 *
	 * 4) Ask for the hint (If you don't know how to solve it)
	 *
	 *
	 * 5) Do I know alternate solution to solve this problem? - yes
	 *	Yes - What are those? Yes
	 *	No � That is still fine, proceed to solve by what you know !!
	 *  Simple Technique - > Brute Force !!
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 *  Approach 1: Hashing
	 *  
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 *
	 */

	@Test
	public void test1() {
		String jewels = "aA",  stones = "aAAbbbb";
		Assert.assertTrue(numJewelsInStones(jewels,stones)==3);
	}

	@Test
	public void test2() {
		String jewels = "z", stones = "ZZ";
		Assert.assertTrue(numJewelsInStones1(jewels,stones)==0);
	}

	@Test
	public void test3() {
		String jewels = "zAq", stones = "zaqA";
		Assert.assertEquals(numJewelsInStones2(jewels,stones),3);
	}

	/*
	 * Pseudo Code:
	 * 
	 * Algorithm: Hashing
	 * 
	 * 1. Convert the jeweles string in to str[] and add it to set and declare a count = 0 var
	 * 2. In For loop iterate the stone string
	 * 3. ----Check if the current char exists in jeweles set
	 * 4. ----------then increase count
	 * 5. return count
	 * 
	 * Time Complexity: O(1)
	 * Space Complexity: O(n) - In Place memory
	 */


    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelBox = new HashSet<>();
        int stoneCount = 0;
        for(int i=0; i<jewels.length(); i++) jewelBox.add(jewels.charAt(i));
        for(int i=0; i<stones.length(); i++) if(jewelBox.contains(stones.charAt(i))) stoneCount ++;
        return stoneCount;
    }
    
    public int numJewelsInStones1(String jewels, String stones) {
        int stoneCount = 0;
        for(int i=0; i<stones.length(); i++) if(jewels.contains(stones.charAt(i)+"")) stoneCount ++;
        return stoneCount;
    }
    
	/*
	 * Pseudo Code:
	 * 
	 * Algorithm: Hashing
	 * 
	 * 1. Convert the jeweles string in to str[] and add it to set and declare a count = 0 var
	 * 2. In For loop iterate the stone string
	 * 3. --Check if the current char exists in jeweles using index of function -(if char exists it return the index of that char else it returns -1)
	 * 4. ----------then increase count
	 * 5. return count
	 * 
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 */

    public int numJewelsInStones2(String jewels, String stones) {
        int stoneCount = 0;
        for(int i=0; i<stones.length(); i++) if(jewels.indexOf(stones.charAt(i)) >= 0) stoneCount ++;
        return stoneCount;
    }
}

