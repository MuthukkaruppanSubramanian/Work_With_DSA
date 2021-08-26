import org.junit.*;
import java.util.*;

public class Merge_Overlapping_Intervals {
	
	/*
	 * 
	 *
	 * Sample Test Data 
	 *    Input : [1,3],[2,5],[6,9]
	 *    output: [1,5],[6,9]
	 *
	 * Approach 1: Test_Template.java
	 * 
	 *
	 * Time / Space Complexity:
	 * 		
	 */
	
	@Test
	public void test1() {
		List<List<Integer>> data1 = new ArrayList<>();
//		data.add(new ArrayList<>(Arrays.asList(1,3)));
//		data.add(new ArrayList<>(Arrays.asList(3,4)));
//		data.add(new ArrayList<>(Arrays.asList(6,9)));
		int[][] data = {{1,3},{2,4},{6,9}};
		System.out.println(Arrays.deepToString(mergerOverLappingIntervals(data)));
	}

	@Test
	public void test2() {
		int[][] data = {{1,3},{7,4},{8,9}};
		System.out.println(Arrays.deepToString(mergerOverLappingIntervals(data)));
	}

	@Test
	public void test3() {
		int[][] data = {{1,3},{7,4},{1,9}};
		System.out.println(Arrays.deepToString(mergerOverLappingIntervals(data)));
	}
	
	/*
	 * Pseudo Code
	 * Sort the given array based on the start value
	 * Declare a list and add the first set to list
	 * declare the endValue of last set in the list
	 * Traverse the array in for loop until its length
	 * if(startValue is <= endValue) 
	 * -----then get the max of current end time and end value
	 * -----replace the value in the last set
	 * else
	 * -----add the current set to list
	 * -----update the endIndex = current set end index
	 * 
	 * return list.to_array;
	 * 
	 */

	/**
	 * @param data
	 * @return
	 */
	private int[][] mergerOverLappingIntervals(int[][] data) {
		Arrays.sort(data, (a,b) -> {
			return a[0] - b[0];
		});
		
		List<int[]> output = new ArrayList<>();
		output.add(data[0]);
		int endValue = data[0][1];
		int j = 0;
		for (int i = 1; i < data.length; i++) {
			if(data[i][0] <= endValue) {
				output.get(j)[1] = Math.max(endValue, data[i][1]);
						
			}else {
				output.add(data[i]);
				j++;
			}
			endValue = output.get(j)[1];
		}
		int[][] result = output.toArray(new int[j][2]);
		return result;
	}
	
}






