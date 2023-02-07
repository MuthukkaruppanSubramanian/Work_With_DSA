import org.junit.*;
import java.util.*;

public class Attend_All_Meeting {
	
	/*
	 * Given an array of meeting time intervals where intervals[i] = [starti, endi],
	 * determine if a person could attend all meetings. 
	 * Example 1: Input: intervals = [[0,30],[5,10],[15,20]] 
	 *            Output: false 
	 * Example 2: Input: intervals = [[7,10],[2,4]]
	 * 			  Output: true
	 *
	 * Approach 1: 
	 * 
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		int[][] timings = {{0,30},{5,10},{15,20}};
		Assert.assertFalse(possibleToAttendAllMeetings(timings));
	}

	@Test
	public void test2() {
		int[][] timings = {{7,10},{2,4}};
		Assert.assertTrue(possibleToAttendAllMeetings(timings));
	}

	@Test
	public void test3() {
		int[][] timings = {{7,10},{2,4},{8,10}};
		Assert.assertFalse(possibleToAttendAllMeetings(timings));
	}
	
	/*
	 * Pseudo Code
	 * Sort the give array
	 * Declare the endTime as first meeting end time
	 * Iterate the array
	 * ---if currentStartTime is greater than than end time
	 * ---endTime = currentEndTime
	 * ---else
	 * --------return false
	 * return true 
	 */
	
	/**
	 * @param timings
	 * @return
	 */
	private boolean possibleToAttendAllMeetings(int[][] timings) {
		Arrays.sort(timings, (a,b) ->{
			if(a[1] != b[1]) return a[1]-b[1];
			return a[0]-b[0];
		});

		int endTime = timings[0][1];//first end time after sorting
		for (int i = 1; i < timings.length; i++) {
			if(timings[i][0]> endTime) endTime = timings[i][1];
			else return false;
		}
		return true;
	}
}
