package hou.forme.GooglePrepare.GooglePrepare.medium;

/**
 * @author houweitao
 * @date 2016年12月5日下午9:32:16
 * @end 2016年12月05日21:36:37
 */

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					sum++;
					deal(grid, i, j);
				}
			}
		}
		return sum;
	}

	private void deal(char[][] grid, int i, int j) {
		if (yes(grid, i, j) && grid[i][j] == '1') {
			grid[i][j] = '#';
			deal(grid, i + 1, j);
			deal(grid, i - 1, j);
			deal(grid, i, j + 1);
			deal(grid, i, j - 1);
		}
	}

	private boolean yes(char[][] grid, int i, int j) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)
			return true;
		else
			return false;
	}
}
