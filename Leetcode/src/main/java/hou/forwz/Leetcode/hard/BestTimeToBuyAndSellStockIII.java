package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月1日下午10:35:27
 */

public class BestTimeToBuyAndSellStockIII {
	int[] maybe;

	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII bt = new BestTimeToBuyAndSellStockIII();
		int[] prices = { 1, 7, 4, 2, 11 };
		System.out.println(bt.maxProfit(prices));

		// System.out.println(bt.help(prices, 3, 4,1));
	}

	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;

		int out = help(prices, 0, prices.length - 1, 2);
		int inside = get(maybe);

		return Math.max(out, inside);
	}

	private int get(int[] nums) {
		if (nums == null)
			return 0;
		int max = nums[nums.length - 1] - nums[0];

		for (int i = 1; i < nums.length - 1; i++) {
			int cur = single(nums, 0, i) + single(nums, i + 1, nums.length - 1);
			// System.out.println(i+","+cur);
			max = Math.max(max, cur);
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

	private int help(int[] prices, int begin, int end, int time) {
		if (time == 0)
			return 0;
		time--;

		if (end - begin < 1)
			return 0;

		int[] nums = new int[end - begin + 1];

		int curMax = end;
		nums[nums.length - 1] = end;
		for (int i = end - 1; i >= begin; i--) {
			if (prices[i] >= prices[curMax]) {
				curMax = i;
			}
			nums[i - begin] = curMax;
		}

		int max = 0;
		int buy = -1, sell = -1;
		for (int i = begin; i <= end; i++) {
			int now = prices[nums[i - begin]] - prices[i];
			if (now > max) {
				max = now;
				buy = i;
				sell = nums[i - begin];
			}
		}

		// System.out.println(buy + "," + sell+": time:"+time);

		int second = 0;
		if (time > 0) {
			if (buy != -1) {
				int left = help(prices, 0, buy - 1, time);
				int right = help(prices, sell + 1, prices.length - 1, time);

				// System.out.println("right: "+right);

				second = Math.max(left, right);

				maybe = new int[sell - buy + 1];
				int pos = 0;
				for (int i = buy; i <= sell; i++)
					maybe[pos++] = prices[i];
			}

		}

		return max + second;
	}

}
