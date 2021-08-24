import org.junit.*;
import java.util.*;

public class Find_Meeting_Room {

	/*
	 * Input : 
	 * String[][] meetingTimes = {{"09 00", "09 45"},{"09 30", "10 30"},
	 *    						  {"10 40", "12 00"},{"11 00", "13 00"},
	 *    						  {"11 45", "14 00"},{"16 00", "17 00"}};
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
		String[][] meetingTimes = {{"09 00", "09 45"},{"09 30", "10 30"},
				{"10 40", "12 00"},{"11 00", "13 00"},
				{"11 45", "14 00"},{"16 00", "17 00"}};

		Assert.assertTrue(getNoOfRoomsRequired(meetingTimes)==3);
	}

	//@Test
	public void test2() {
		String[][] meetingTimes = {{"09 00", "11 20"},{"11 00", "11 10"},
								   {"09 30", "10 00"},{"10 40", "11 40"}};

		Assert.assertTrue(getNoOfRoomsRequired(meetingTimes)==3);
	}

	@Test
	public void test3() {
		String[][] meetingTimes = {{"09 00", "09 30"},{"11 00", "11 10"},
				   				   {"10 30", "11 00"},{"10 40", "11 40"}};

		Assert.assertTrue(getNoOfRoomsRequired(meetingTimes)==2);
	}

	@Test
	public void test4() {
		String[][] meetingTimes = {{"09 00", "09 30"},{"12 00", "12 10"},
				   				   {"13 30", "13 50"},{"10 40", "11 40"}};

		Assert.assertTrue(getNoOfRoomsRequired(meetingTimes)==1);
	}
	
	/*
	 * Pseudo Code
	 * Declare the total meeting room required as length of meeting timing array.
	 * Convert the string of start and end time to integer in a new array.
	 * Sort the array using comparator
	 * Traverse the array in while loop until start reaches the length of array
	 * if end time is less than nextStart time
	 * ------decrement the total meeting count
	 * ------endtime = nextStartime's endtime
	 * ------nextstart time ++
	 * else nextStartTime++
	 * return nextStarttime
	 */

	/**
	 * @param meetingTimes
	 */
	private int getNoOfRoomsRequired(String[][] meetingTimes) {
		int meetingRoom = meetingTimes.length;
		int[][] integerTimings = new int[meetingTimes.length][2];
		for (int i = 0; i < meetingTimes.length; i++) {
			integerTimings[i][0] = Integer.parseInt(meetingTimes[i][0].replace(" ", ""));
			integerTimings[i][1] = Integer.parseInt(meetingTimes[i][1].replace(" ", ""));
		}
		
		Arrays.sort(integerTimings, (a,b) -> {
			if(a[1] != b[1]) return a[1]-b[1]; //end Times
			else return a[0] - b[0]; //start times
		});
		
		int right = 1, left = 0;
		
		while(right <integerTimings.length) {
			int nextStartTime = integerTimings[right][0];// Second Meeting Start Time
			int endTime = integerTimings[left][1]; // First meeting end time
			if(endTime < nextStartTime) {
				meetingRoom--;
				left = right-1;
				right++;
			}else right++;
		}
		return meetingRoom;
	}
}












