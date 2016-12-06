package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月6日下午3:18:18
 * @end 2016年12月06日15:23:37
 */

public class PerfectSquares {

	public int numSquares(int n) {
		List<Integer> maybe = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i * i <= n)
				maybe.add(i * i);
			else
				break;
		}

		if (maybe.size() == 0)
			return -1;

		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = i;
			for (int j = 0; j < maybe.size(); j++) {
				if (i < maybe.get(j))
					break;
				else if (i == maybe.get(j)) {
					dp[i] = 1;
					break;
				} else {
					if (dp[i - maybe.get(j)] + 1 < dp[i]) {
						dp[i] = dp[i - maybe.get(j)] + 1;
					}
				}
			}
		}
		return dp[n];
	}

}
