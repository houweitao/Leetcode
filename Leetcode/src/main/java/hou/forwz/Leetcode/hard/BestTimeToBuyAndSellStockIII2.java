package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月1日下午11:45:54
 */

public class BestTimeToBuyAndSellStockIII2 {
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII2 bt = new BestTimeToBuyAndSellStockIII2();
		int[] prices = { 1, 7, 4, 2, 11 };
		System.out.println(bt.maxProfit(prices));

		// System.out.println(bt.help(prices, 3, 4,1));
	}

	//超时
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;

		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			int left = single(prices, 0, i);
			int right = single(prices, i + 1, prices.length - 1);
			max = Math.max(max, left + right);
		}
		
		return max;
	}

	int single(int[] prices, int begin, int end) {
		if (end - begin < 1)
			return 0;
		int[] record = new int[prices.length];
		int max = 0;
		max = -1;
		for (int i = end; i >= begin; i--) {
			max = Math.max(max, prices[i]);
			record[i] = max;
		}

		max = 0;
		for (int i = 0; i < record.length; i++)
			max = Math.max(max, record[i] - prices[i]);

		return max;
	}

}
