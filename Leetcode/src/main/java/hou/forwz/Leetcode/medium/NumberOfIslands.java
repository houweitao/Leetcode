package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月16日下午10:17:33
 */

public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		if (grid.length == 0)
			return 0;
		else {
			int count = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] == '1') {
						count++;
						deal(grid, i, j);
					}
				}
			}
			return count;
		}
	}

	private void deal(char[][] grid, int m, int n) {

		if (in(grid, m, n) && grid[m][n] == '1') {
			grid[m][n] = '0';
			deal(grid, m, n - 1);
			deal(grid, m - 1, n);
			deal(grid, m, n + 1);
			deal(grid, m + 1, n);
		}
	}

	private boolean in(char[][] grid, int m, int n) {
		int x = grid.length, y = grid[0].length;

		if (m >= 0 && m < x && n >= 0 && n < y)
			return true;
		else
			return false;
	}

}
