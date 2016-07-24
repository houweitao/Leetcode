package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月25日上午12:14:47
 */

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0)
			return 0;

		int m = matrix.length;
		int n = matrix[0].length;
		int[][] map = new int[m + 1][n + 1];
		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					int before = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
					map[i][j] = before + 1;
					max = Math.max(max, map[i][j]);
				}
			}
		}

		return max * max;
	}

}
