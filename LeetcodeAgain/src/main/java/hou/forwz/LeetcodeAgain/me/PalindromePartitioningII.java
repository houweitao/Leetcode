package hou.forwz.LeetcodeAgain.me;

/**
 * @author houweitao
 * @date 2016年11月28日下午7:57:40
 */

public class PalindromePartitioningII {
	public static void main(String[] args) {
		PalindromePartitioningII pp = new PalindromePartitioningII();
		String s = "abasbfsebababab";
		System.out.println(pp.minCut(s));
	}

	public int minCut(String s) {
		if (s == null || s.length() < 2)
			return 0;
		boolean[][] dp = new boolean[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
			deal(s, dp, i - 1, i + 1);
		}

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == s.charAt(i)) {
				dp[i - 1][i] = true;
				deal(s, dp, i - 2, i + 1);
			}
		}
		int[] cut = new int[s.length() + 1];
		for (int i = 0; i < cut.length; i++) {
			cut[i] = i - 1;
		}

		for (int i = 1; i < cut.length; i++) {
			for (int j = 1; j <= i; j++) {
				if (dp[j - 1][i - 1] && cut[j - 1] + 1 < cut[i]) {
					cut[i] = cut[j - 1] + 1;
				}
			}
		}

		return cut[s.length()];
	}

	private void print(int[] cut) {
		StringBuilder sb = new StringBuilder();
		for (int i : cut)
			sb.append(i + ",");
		System.out.println(sb);
	}

	private void deal(String s, boolean[][] dp, int left, int right) {
		while (left >= 0 && right < dp.length) {
			if (s.charAt(left) == s.charAt(right)) {
				dp[left--][right++] = true;
			} else {
				break;
			}
		}
	}

}
