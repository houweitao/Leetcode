package hou.forwz.LeetcodeAgain.medium;

/**
 * @author houweitao
 * @date 2016年9月14日上午11:31:14
 */

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		if(matrix.length==0)
			return 0;
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		int max = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				char c = matrix[i - 1][j - 1];
				if (c == '0')
					dp[i][j] = 0;
				else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					// dp[i][j]=Math.max(1,dp[i][j]);
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max * max;
	}

}
