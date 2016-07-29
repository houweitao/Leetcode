package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月30日上午1:40:33
 */

public class LongestIncreasingPathInAMatrix2 {
	public int longestIncreasingPath(int[][] matrix) {

		if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return 0;

		int max = 0, n = matrix.length, m = matrix[0].length;

		// create a cache matrix
		int[][] cache = new int[n][m];

		// dfs search on every element in matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(dfs(matrix, Integer.MIN_VALUE, i, j, n, m, cache), max);
			}
		}
		return max;
	}

	int dfs(int[][] matrix, int min, int i, int j, int n, int m, int[][] cache) {

		// check boundary limits
		if (i < 0 || j < 0 || i >= n || j >= m)
			return 0;

		// check min condition
		if (matrix[i][j] <= min)
			return 0;

		// check into cache
		if (cache[i][j] != 0)
			return cache[i][j];

		// update min
		min = matrix[i][j];

		// run dfs in all four directions
		int a = dfs(matrix, min, i - 1, j, n, m, cache) + 1;
		int b = dfs(matrix, min, i + 1, j, n, m, cache) + 1;
		int c = dfs(matrix, min, i, j - 1, n, m, cache) + 1;
		int d = dfs(matrix, min, i, j + 1, n, m, cache) + 1;

		// find max and update cache
		int max = Math.max(a, Math.max(b, Math.max(c, d)));
		cache[i][j] = max;

		return max;
	}
}
