package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年8月28日下午11:44:21
 */

public class BestTimeToBuyAndSellStockIV {

	public int maxProfit(int k, int[] prices) {
		if (k > prices.length / 2)
			return full(prices);

		else {
			int[][] dp = new int[k + 1][prices.length];
			for (int i = 1; i <= k; i++) {
				int max = 0 - prices[0];
				boolean findNext = false;
				for (int j = 1; j < dp[0].length; j++) {
					dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
					if (dp[i][j] > dp[i][j - 1])
						findNext = true;
					max = Math.max(max, dp[i - 1][j - 1] - prices[j]);
				}
				if (!findNext)
					return dp[i - 1][prices.length - 1];
			}
			return dp[k][prices.length - 1];
		}
	}

	private int full(int[] prices) {
		int sum = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				sum = sum + prices[i] - prices[i - 1];
		}

		return sum;
	}

}
