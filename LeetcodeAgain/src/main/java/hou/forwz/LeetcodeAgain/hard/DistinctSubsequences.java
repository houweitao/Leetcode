package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年9月14日上午10:04:35
 */

public class DistinctSubsequences {

	public int numDistinct(String s, String t) {
		int[][] dp = new int[t.length() + 1][s.length() + 1];
		dp[0][0] = 0;

		for (int i = 0; i <= s.length(); i++)
			dp[0][i] = 1;
		for (int i = 1; i <= t.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (t.charAt(i - 1) != s.charAt(j - 1)) {
					dp[i][j] = dp[i][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				}
			}
		}
		return dp[t.length()][s.length()];
	}

}
