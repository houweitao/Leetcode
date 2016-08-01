package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月2日上午12:00:18
 */

public class BestTimeToBuyAndSellStockIII3 {
	public int maxProfit(int[] prices) {
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		int low = prices[0];
		for (int i = 1; i < prices.length; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - low);
			if (prices[i] < low)
				low = prices[i];
		}

		int high = prices[prices.length - 1];

		for (int i = prices.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], high - prices[i]);
			if (prices[i] > high)
				high = prices[i];
		}

		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, left[i] + right[i]);
		}
		return max;
	}
}
