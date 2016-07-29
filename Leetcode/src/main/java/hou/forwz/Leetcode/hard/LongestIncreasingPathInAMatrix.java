package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月30日上午1:12:56
 */

public class LongestIncreasingPathInAMatrix {

	int[][] visited;
	int max;

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0)
			return 0;

		visited = new int[matrix.length][matrix[0].length];
		max = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				// if (visited[i][j] != 0) {
				int chang = dfs(matrix, i, j, 1);
				max = Math.max(max, chang);
				// }
			}
		}

		return max;
	}

	private int dfs(int[][] matrix, int i, int j, int curMax) {
		if (visited[i][j] != 0)
			return visited[i][j];
		// visited[i][j] = 1;
		int cur = matrix[i][j];
		boolean find = false;
		int da = 0;
		if (in(matrix, i, j + 1) && matrix[i][j + 1] > cur) {
			int tmp = dfs(matrix, i, j + 1, curMax + 1);
			da = Math.max(da, tmp);
			find = true;
		}
		if (in(matrix, i, j - 1) && matrix[i][j - 1] > cur) {
			int tmp = dfs(matrix, i, j - 1, curMax + 1);
			da = Math.max(da, tmp);

			find = true;
		}
		if (in(matrix, i + 1, j) && matrix[i + 1][j] > cur) {
			int tmp = dfs(matrix, i + 1, j, curMax + 1);
			da = Math.max(da, tmp);

			find = true;
		}
		if (in(matrix, i - 1, j) && matrix[i - 1][j] > cur) {
			int tmp = dfs(matrix, i - 1, j, curMax + 1);
			da = Math.max(da, tmp);

			find = true;
		}

		if (!find) {
			System.out.println("cur max: " + max);
			max = Math.max(max, curMax);
		}

		visited[i][j] = da;
		return da;
	}

	private boolean in(int[][] matrix, int i, int j) {
		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)
			return true;
		else
			return false;
	}

}
