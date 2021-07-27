package dsa.hashing.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class GroupByTransaction {
	/* 
	 * 
	 * Given Input  data type:
	 *       Output data type:
	 * Sample Test Data 
	 *    Input :
	 *    output:
	 *
	 * Approach 1:
	 *
	 * Pseudo code:
	 * 
	 * 
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		ArrayList<String> list = new ArrayList<>();
		list.add("mouse");
		list.add("mouse");
		list.add("mouse");
		list.add("notebook");
		list.add("notebook");
		list.add("keyboard");
		Assert.assertTrue(groupTransactions(list).equals(Arrays.asList("mouse 3","notebook 2","keyboard 1")));
	}

	@Test
	public void test2() {
		ArrayList<String> list = new ArrayList<>();
		list.add("bin");
		list.add("can");
		list.add("bin");
		list.add("can");
		list.add("bin");
		list.add("can");
		Assert.assertTrue(groupTransactions(list).equals(Arrays.asList("bin 3","can 3")));
	}


    public List<String> groupTransactions(List<String> transactions) {
    // Write your code here
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for (int i = 0; i < transactions.size(); i++) {
            map.put(transactions.get(i), map.getOrDefault(transactions.get(i), 0)+1);
        }
        ArrayList<String> list = new ArrayList<>();
        
        for(Map.Entry<String, Integer> keyValues : map.entrySet()){
            list.add(keyValues.getKey()+" "+keyValues.getValue());
        }
        Collections.sort(list);
        
        return list;
    }
}
