package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月26日下午11:41:44
 */

public class RangeSumQuery2DImmutable {

	public static void main(String[] args) {
		RangeSumQuery2DImmutable rs = new RangeSumQuery2DImmutable();
		rs.init();
	}

	void init() {
		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		print(matrix);

		NumMatrix nm = new NumMatrix(matrix);

		System.out.println(nm.sumRegion(2, 1, 4, 3));

	}

	void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	class NumMatrix {
		int[][] map;

		public NumMatrix(int[][] matrix) {
			if (matrix.length < 1)
				return;

			int m = matrix.length, n = matrix[0].length;
			map = new int[m + 1][n + 1];

			map[1][1] = matrix[0][0];

			for (int i = 1; i <= m; i++)
				map[i][1] = map[i - 1][0] + matrix[i - 1][0];
			for (int i = 1; i <= n; i++)
				map[1][i] = map[0][i - 1] + matrix[0][i - 1];

			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = map[i][j - 1] + map[i - 1][j] - map[i - 1][j - 1] + matrix[i - 1][j - 1];
				}
			}
//			print(map);
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			row1++;
			col1++;
			row2++;
			col2++;
			int all = map[row2][col2];
			int inside = map[row1 - 1][col1 - 1];

			int left = map[row2][col1 - 1];
			int up = map[row1 - 1][col2];

			return all - left - up + inside;
		}
	}

}
