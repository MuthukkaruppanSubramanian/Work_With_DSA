package com.two_pointer.algo;
import org.junit.*;
import java.util.*;

public class P_08_HashMap_Product_MisMatch {
	
	/*
	 * 
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
		String[] soldItems = {"eggs", "milk", "apple"}; 
		double[] soldPrices = {1.00, 2.50, 2.1}; 
		String[] productsAvailable = {"eggs", "lemons", "milk", "apple"}; 
		double[] productPrices = {1.01, 0.5, 2.50, 2.1};
		getMisMatchItemCount(soldItems, soldPrices, productsAvailable, productPrices);
	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}
	
	/*
	 * Pseudo Code
	 */
	
	public int getMisMatchItemCount(String[] soldItems, double[] soldPrices, String[] productsAvailable, double[] productPrices) {
		HashMap<String,Double> productList = new HashMap<>();
		HashMap<String,Double> productSold = new HashMap<>();

		for(int i = 0; i < soldItems .length; i++){
			productSold.put(soldItems[i],soldPrices[i]);
		}


		for(int i = 0; i < productsAvailable.length; i++){
			productList.put(productsAvailable[i],productPrices[i]);
		}

		int count = 0;
		for(int i = 0; i < soldItems.length; i++){
			if (productSold.get(soldItems[i]) - productList.get(soldItems[i]) != 0)
				count++;
		}

		return count;
	}
}













