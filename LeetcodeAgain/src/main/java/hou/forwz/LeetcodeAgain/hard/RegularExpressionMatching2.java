//package hou.forwz.LeetcodeAgain.hard;
//
///**
// * @author houweitao
// * @date 2016年9月16日上午10:22:01
// */
//
//public class RegularExpressionMatching2 {
//	public static void main(String[] args) {
//		RegularExpressionMatching2 pe = new RegularExpressionMatching2();
//		String s = "aasdfasdfasdfasdfas";
//		String p = "aasdf.*asdf.*asdf.*asdf.*s";
//		System.out.println(pe.isMatch(s, p));
//	}
//
//	public boolean isMatch(String s, String p) {
//		boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
//		dp[0][0] = true;
//		for (int i = 2; i < dp.length; i++) {
//			if (dp[i - 2][0])
//				dp[i][0] = true;
//		}
//
//		for (int i = 1; i <= p.length(); i++) {
//			char ii = p.charAt(i - 1);
//			for (int j = 1; j <= s.length(); j++) {
//				char jj = s.charAt(j - 1);
//
//				if (ii == '.') {
//					dp[i][j] = dp[i - 1][j - 1];
//				} else if (ii == '*') {
//					if (p.charAt(i - 2) != jj && p.charAt(i - 2) != '.') {
//						dp[i][j] = dp[i - 2][j];
//					} else {
//						dp[i][j] = dp[i - 1][j] || // 0
//								dp[i][j - 1] || //
//								dp[i - 2][j];
//					}
//
//					// dp[i][j] = dp[i - 2][j] || // null
//					// dp[i - 1][j] || // one
//					// dp[i][j - 1] // duo
//					// || (dp[i - 1][j - 1]
//					// // && s.charAt(j - 1) == s.charAt(j - 2));
//					// && (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2)
//					// == '.'));
//				} else {
//					dp[i][j] = ii == jj && dp[i - 1][j - 1];
//				}
//
//			}
//		}
//
//		return dp[p.length()][s.length()];
//	}
//}
