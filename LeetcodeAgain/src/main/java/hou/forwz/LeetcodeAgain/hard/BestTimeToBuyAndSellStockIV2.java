package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年9月13日下午11:48:12
 */

public class BestTimeToBuyAndSellStockIV2 {
	public int maxProfit(int k, int[] prices) {
		if (k >= prices.length / 2)
			return simple(prices);
		else {
			int[][] dp = new int[k + 1][prices.length];

			for (int i = 1; i <= k; i++) {
				int max = 0 - prices[0];
				for (int j = 0; j < prices.length; j++) {
					dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
					if (dp[i][j] > dp[i][j - 1])
						max = Math.max(max, dp[i - 1][j - 1] - prices[j]);
				}
			}
			return dp[k][prices.length - 1];
		}
	}

	private int simple(int[] prices) {
		int sum = 0;
		for (int i = 1; i < prices.length; i++) {
			int cha = prices[i] - prices[i - 1];
			if (cha > 0)
				sum += cha;
		}
		return sum;
	}
}
