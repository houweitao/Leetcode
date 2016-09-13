package hou.forwz.LeetcodeAgain.medium;

/**
 * @author houweitao
 * @date 2016年9月14日上午1:50:58
 */

public class UniqueBinarySearchTrees {
	public static void main(String[] args) {
		UniqueBinarySearchTrees bs = new UniqueBinarySearchTrees();
		System.out.println(bs.numTrees(10));
	}

	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[0] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}

		}

		return dp[n];
	}

}
