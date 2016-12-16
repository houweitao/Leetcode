package hou.forme.GooglePrepare.GooglePrepare.acres;

import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月14日下午2:46:15
 * @url http://www.1point3acres.com/bbs/thread-189741-1-1.html
 * @tips 把问题分解成 n 和 n+1 的问题
 */

public class MaxCoins {
	int getMaxCoin(List<List<Integer>> coins, int k) {
		if (coins == null || coins.size() == 0 || k < 1)
			return 0;

		int[][] dp = new int[coins.size() + 1][k + 1];
		for (int i = 1; i <= coins.size(); i++) {
			int tmp = 0;
			for (int j = 1; j <= k; j++) {
				if (j < coins.get(i - 1).size()) {
					tmp += coins.get(i - 1).get(j);
					dp[i][j] = Math.max(dp[i - 1][k + 1 - j], dp[i - 1][k - j] + tmp);
				}
			}
		}

		return dp[coins.size()][k];
	}
}
