package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月20日上午1:00:10
 */

public class IntegerBreak {

	// https://discuss.leetcode.com/topic/42978/java-dp-solution
	public int integerBreak(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * Math.max(i - j, dp[i - j]));
			}
		}
		return dp[n];
	}

}
