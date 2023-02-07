import org.junit.*;
import java.util.*;

public class Determine_Meeting_Rooms {

	/*
	 * 
	 *
	 * Sample Test Data 
	 *    Input : 		String[][] meetingTimes = {{"09 00", "09 45"},{"09 30", "10 30"},
	 *    										   {"10 40", "12 00"},{"11 00", "13 00"},
	 *    										   {"11 45", "14 00"},{"16 00", "17 00"}};
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
		List<Integer> scheduleStart = new ArrayList<>(Arrays.asList(6, 1, 2, 4));
		List<Integer> scheduleEnd = new ArrayList<>(Arrays.asList  (8, 9, 4, 7));

		int maxPresentations = maxPresentations(scheduleStart, scheduleEnd);
		System.out.println(maxPresentations);
	}

	@Test
	public void test2() {
		List<Integer> scheduleStart = new ArrayList<>(Arrays.asList(1, 1, 2));
		List<Integer> scheduleEnd = new ArrayList<>(Arrays.asList(3, 2, 4));

		int maxPresentations = maxPresentations(scheduleStart, scheduleEnd);
		System.out.println(maxPresentations);
	}

	@Test
	public void test3() {

	}

	/*
	 * Pseudo Code
	 */

	public int maxPresentations(List<Integer> scheduleStart, List<Integer> scheduleEnd) {

		// Create 2 dimensional array to start comparision with start and end at once
		int[][] conferneceTimes = new int[scheduleStart.size()][2];

		// Push the start and end time to 2 dimensional array for sorting
		for (int i = 0; i < conferneceTimes.length; i++) {
			conferneceTimes[i][0] = scheduleStart.get(i);
			conferneceTimes[i][1] = scheduleEnd.get(i);
		}
		//int da;
		// Sort by compartor (start and end times) so that compariosn can be done
		Arrays.sort(conferneceTimes, (a, b) -> {
			if (a[1] != b[1]) {
				return a[1] - b[1]; // end times
			}else {
				return a[0] - b[0]; // start times
			}
		});

		// Let the first small meeting be attended
		int endTime = conferneceTimes[0][1];

		// Default number of presentation can be attended is 1
		int maxPresentations = 1;

		// Iterate through every conference start and end
		for (int i = 0; i < conferneceTimes.length; i++) {
			if (conferneceTimes[i][0] >= endTime) {// If start time >end
				maxPresentations++;// increment presentations
				endTime = conferneceTimes[i][1];// reset the endTime
			}
		}
		return maxPresentations;
	}
}
