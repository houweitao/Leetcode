package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年10月7日下午3:45:26
 */

public class RegularExpressionMatching4 {
	public static void main(String[] args) {
		RegularExpressionMatching4 re = new RegularExpressionMatching4();
		String s = "aa", p = "c*aa";
		System.out.println(re.isMatch(s, p));
	}

	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && dp[0][i - 1]) {
				dp[0][i + 1] = true;
			} 
		}

		for (int i = 1; i <= s.length(); i++) {
			char heng = s.charAt(i - 1);
			for (int j = 1; j <= p.length(); j++) {
				char shu = p.charAt(j - 1);

				if (shu == '.')
					dp[i][j] = dp[i - 1][j - 1];
				else if (shu == '*') {
					char bef = p.charAt(j - 2);
					if (heng != bef && bef != '.') {
						dp[i][j] = dp[i][j - 2];// null
					} else {
						if (dp[i][j - 1])// zero
							dp[i][j] = true;
						if (dp[i - 1][j])// duo yi ge
							dp[i][j] = true;
						if (dp[i - 1][j - 1])// one
							dp[i][j] = true;
						if (dp[i][j - 2])// null
							dp[i][j] = true;
					}
				} else {
					dp[i][j] = dp[i - 1][j - 1] && heng == shu;
				}
			}
		}
		return dp[s.length()][p.length()];
	}

}
