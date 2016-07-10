package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月11日上午1:25:16
 */

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		int[] record = new int[prices.length];
		int max = 0;
		max = -1;
		for (int i = prices.length - 1; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			record[i] = max;
		}

		max = 0;
		for (int i = 0; i < record.length; i++)
			max = Math.max(max, record[i] - prices[i]);

		return max;
	}

}
