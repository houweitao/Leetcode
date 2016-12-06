package hou.forme.GooglePrepare.GooglePrepare.medium;

/**
 * @author houweitao
 * @date 2016年12月6日下午9:05:17
 */

public class BestTimeToBuyAndSellStockWithCooldown {
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;

		int[] buy = new int[prices.length];
		int[] reset = new int[prices.length];
		int[] sell = new int[prices.length];

		buy[0] = -prices[0];
		reset[0] = 0;
		sell[0] = Integer.MIN_VALUE;

		for (int i = 1; i < prices.length; i++) {
			// 顺序无影响？因为只跟前一个变量相关啊 2016年08月17日00:14:36
			buy[i] = Math.max(buy[i - 1], reset[i - 1] - prices[i]);
			sell[i] = buy[i - 1] + prices[i];
			reset[i] = Math.max(reset[i - 1], sell[i - 1]);
		}

		return Math.max(reset[prices.length - 1], sell[prices.length - 1]);
	}
}
