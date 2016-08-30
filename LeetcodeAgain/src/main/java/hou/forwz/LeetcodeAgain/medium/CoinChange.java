package hou.forwz.LeetcodeAgain.medium;

/**
 * @author houweitao
 * @date 2016年8月31日上午1:07:12
 * @end 2016年08月31日01:12:29
 */

public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		int[] may = new int[amount + 1];
		may[0] = Integer.MAX_VALUE;
		for (int i = 1; i <= amount; i++) {
			may[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i == coins[j])
					may[i] = 1;
				else if ((i - coins[j] > 0) && may[i - coins[j]] != Integer.MAX_VALUE) {
					may[i] = Math.min(may[i], may[i - coins[j]] + 1);
				}
			}
		}

		if (may[amount] == Integer.MAX_VALUE)
			return -1;
		else
			return may[amount];
	}

}
