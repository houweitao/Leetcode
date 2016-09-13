package hou.forwz.LeetcodeAgain.easy;

/**
 * @author houweitao
 * @date 2016年9月13日下午11:12:32
 */

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		else {
			int ret = 0;
			int max = prices[prices.length-1];
			for (int i = prices.length - 2; i >= 0; i--) {
				max = Math.max(max, prices[i]);
				ret = Math.max(ret, max - prices[i]);
			}
			return ret;
		}

	}
}
