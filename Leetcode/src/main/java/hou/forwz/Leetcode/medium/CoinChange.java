package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月26日上午12:51:10
 */

public class CoinChange {

	public int coinChange(int[] coins, int amount) {

		int[] can = new int[amount + 1];

		for (int i = 1; i <= amount; i++) {
			can[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i == coins[j])
					can[i] = 1;
				else {
					if (i > coins[j] && can[i - coins[j]] != Integer.MAX_VALUE) {
						can[i] = Math.min(can[i], can[i - coins[j]] + 1);
					}

				}

			}
		}
		return can[amount] == Integer.MAX_VALUE ? -1 : can[amount];
	}

}
