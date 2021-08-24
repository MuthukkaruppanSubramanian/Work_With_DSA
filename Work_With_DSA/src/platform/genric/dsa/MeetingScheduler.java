import org.junit.*;
import java.util.*;

public class MeetingScheduler {
	
	/*
	 * Given the availability time slots arrays slots1 and slots2 of two people and
	 * a meeting duration duration, return the earliest time slot that works for
	 * both of them and is of duration duration. 
	 * 
	 * If there is no common time slotthat satisfies the requirements, return an empty array. 
	 * The format of a time slot is an array of two elements [start, end] representing an inclusive time
	 * range from start to end. It is guaranteed that no two availability slots of
	 * the same person intersect with each other. 
	 * 
	 * That is, for any two time slots [start1, end1] and [start2, end2] of the same person, 
	 * either start1 > end2 or start2 > end1. 
	 * Example 1: Input: slots1 = [[10,50],[60,120],[140,210]],
	 * 					 slots2 = [[0,15],[60,70]], duration = 8 
	 * Output: [60,68] 
	 * 
	 * Example 2: Input:
	 * slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
	 * Output: []
	 *
	 * Approach 1: Test_Template.java
	 * 
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		int[][] slot1 = {{10,50},{60,120},{140,210}};
		int[][] slot2 = {{0,15},{60,70}};
		int duration = 8;
		Assert.assertTrue(Arrays.equals(getTimings(slot1,slot2,duration), new int[] {60,68}));
	}

	@Test
	public void test2() {
		int[][] slot1 = {{10,50},{60,120},{140,210}};
		int[][] slot2 = {{0,15},{60,70}};
		int duration = 12;
		Assert.assertTrue(Arrays.equals(getTimings(slot1,slot2,duration), new int[] {}));
	}


	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code
	 * Traverse the solt1 and slot2 in while loop until it reaches its length
	 * if slot1 and slot2 starting time are same and add duration to it
	 * if it exceed the endtime of those slots continue to next sets
	 * else return [start time, startTime+duration]
	 * default return [];
	 */
	
	/**
	 * @param slot1
	 * @param slot2
	 * @param duration
	 * @return
	 */
	private int[] getTimings(int[][] slot1, int[][] slot2, int duration) {
		int left = 0;
		while(left < slot1.length && left < slot2.length) {
			if(slot1[left][0] == slot2[left][0]) {
				if ((slot1[left][0]+duration <= slot1[left][1]) && (slot2[left][0]+duration <= slot2[left][1]))
					return new int[] {slot1[left][0], slot1[left][0]+duration};
			}
			left++;
		}
		return new int[] {};
	}
}





















