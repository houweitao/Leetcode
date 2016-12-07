package hou.forme.GooglePrepare.GooglePrepare.hard;

/**
 * @author houweitao
 * @date 2016年12月7日下午1:31:07
 * @end 2016年12月07日13:46:46
 */

public class LongestIncreasingPathInAMatrix {
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int[][] path = new int[matrix.length][matrix[0].length];
		int ret = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int cur = findMax(matrix, i, j, matrix[i][j] - 1, path);
				ret = Math.max(ret, cur);
			}
		}
		return ret;
	}

	private int findMax(int[][] matrix, int i, int j, int pre, int[][] path) {
		if (in(matrix, i, j) && matrix[i][j] > pre) {
			if (path[i][j] != 0)
				return path[i][j] + 1;
			else {
				int up = findMax(matrix, i - 1, j, matrix[i][j], path);
				int down = findMax(matrix, i + 1, j, matrix[i][j], path);
				int left = findMax(matrix, i, j - 1, matrix[i][j], path);
				int right = findMax(matrix, i, j + 1, matrix[i][j], path);

				int sum = Math.max(Math.max(up, down), Math.max(left, right));
				path[i][j] = sum;
				return sum + 1;
			}
		} else
			return 0;
	}

	private boolean in(int[][] matrix, int i, int j) {
		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)
			return true;
		else
			return false;
	}
}
