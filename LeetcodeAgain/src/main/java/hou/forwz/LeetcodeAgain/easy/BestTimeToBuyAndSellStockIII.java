package hou.forwz.LeetcodeAgain.easy;

/**
 * @author houweitao
 * @date 2016年9月13日下午11:25:13
 */

public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;

		int[] fromNow = new int[prices.length];
		int max = prices[prices.length - 1];
		for (int i = prices.length - 1; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			fromNow[i] = max - prices[i];
		}

		int[] endNow = new int[prices.length];
		int min = prices[0];
		int ret = 0;
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			endNow[i] = Math.max(endNow[i - 1], prices[i] - min);
			ret = Math.max(ret, endNow[i]);
		}

		// int ret = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			ret = Math.max(ret, endNow[i] + fromNow[i + 1]);
		}
		return ret;
	}

}
