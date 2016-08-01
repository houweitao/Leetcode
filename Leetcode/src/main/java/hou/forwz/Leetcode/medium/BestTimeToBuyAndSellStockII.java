package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年8月1日下午10:14:29
 */

public class BestTimeToBuyAndSellStockII {

	public int maxProfit(int[] prices) {
		int firstBuy = -1;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i + 1] > prices[i]) {
				firstBuy = i;
				break;
			}
		}

		if (firstBuy == -1)
			return 0;

		int max = -prices[firstBuy];
		boolean top = true;
		for (int i = firstBuy + 1; i < prices.length - 1; i++) {
			if (top) {
				if (prices[i + 1] >= prices[i]) {

				} else {
					top = false;
					max = max + prices[i];
				}
			} else {
				if (prices[i + 1] > prices[i]) {
					top = true;
					max = max - prices[i];
				} else {
				}

			}
		}

		if (top) {
			max = max + prices[prices.length - 1];
		}

		return max;
	}

}
