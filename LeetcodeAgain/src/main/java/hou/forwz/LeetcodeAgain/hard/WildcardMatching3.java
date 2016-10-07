package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年10月7日下午3:19:59
 */

public class WildcardMatching3 {
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && dp[0][i]) {
				dp[0][i + 1] = true;
			}
		}

		for (int i = 1; i <= s.length(); i++) {
			char shu = s.charAt(i - 1);
			for (int j = 1; j <= p.length(); j++) {
				char heng = p.charAt(j - 1);

				if (heng == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (heng == '*') {
					if (dp[i][j - 1])// NULL
						dp[i][j] = true;
					if (dp[i - 1][j - 1])// ONE ANYTHING
						dp[i][j] = true;
					if (dp[i - 1][j])// TWO(MULTY) ANYTHING
						dp[i][j] = true;
				} else {
					if (heng == shu)
						dp[i][j] = dp[i - 1][j - 1];
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
