package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年8月16日下午11:38:47
 */

public class BestTimeToBuyAndSellStockWithCooldown {
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;

		int[] last = new int[prices.length + 1];

		int k = prices.length / 2;

		for (int i = 1; i <= k; i++) {
			int[] cur = new int[prices.length + 1];
			int max = 0 - prices[0];
			for (int j = 2; j < last.length; j++) {
				cur[j] = Math.max(cur[j - 1], prices[j - 1] + max);
				max = Math.max(max, last[j - 2] - prices[j - 1]);
			}
			last = cur;
		}

		return last[prices.length];

	}

	public int maxProfitNative(int[] prices) {
		if (prices.length < 2)
			return 0;

		int[][] dp = new int[prices.length / 2 + 1][prices.length + 1];
		int k = prices.length / 2;

		for (int i = 1; i <= k; i++) {
			int max = 0 - prices[0];
			for (int j = 2; j < dp[0].length; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], prices[j - 1] + max);
				max = Math.max(max, dp[i - 1][j - 2] - prices[j - 1]);
			}
		}

		return dp[k][prices.length];

	}

}
