package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月16日下午11:25:22
 */

public class BestTimeToBuyAndSellStockIV {

	// 思想是分割。从当前开始，剩下的归你多一次买卖。
	public int maxProfit(int k, int[] prices) {
		if (k > prices.length / 2)
			return nativeBuySell(prices);

		int[][] dp = new int[k + 1][prices.length];

		for (int i = 1; i <= k; i++) {
			int max = 0 - prices[0];
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
				max = Math.max(max, dp[i - 1][j - 1] - prices[j]);
			}
		}

		return dp[k][prices.length - 1];
	}

	private int nativeBuySell(int[] prices) {
		if (prices.length < 2)
			return 0;
		else {
			int sum = 0;

			for (int i = 0; i < prices.length - 1; i++) {
				if (prices[i + 1] >= prices[i])
					sum = sum + prices[i + 1] - prices[i];
			}

			return sum;
		}
	}

}
