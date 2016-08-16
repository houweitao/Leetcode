package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月17日上午12:54:29
 */

public class MaxSumOfRectangleNoLargerThanK {

	public int maxSumSubmatrix(int[][] matrix, int k) {
		if (matrix.length < 1)
			return 0;
		int[][] help = new int[matrix.length + 1][matrix[0].length + 1];

		for (int i = 1; i < help.length; i++) {
			for (int j = 1; j < help[0].length; j++) {
				help[i][j] = help[i - 1][j] + help[i][j - 1] - help[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
		}

		// print(help);

		int max = Integer.MIN_VALUE;
		for (int i = 1; i < help.length; i++) {
			for (int j = 1; j < help[0].length; j++) {
				for (int m = i; m < help.length; m++) {
					for (int n = j; n < help[0].length; n++) {
						int cur = help[m][n] - help[i - 1][n] - help[m][j - 1] + help[i - 1][j - 1];
						// System.out.println("(" + i + "," + j + "),(" + m +
						// "," + n + ") " + cur);
						if (cur > k)
							continue;
						if (cur == k)
							return k;
						if (cur > max)
							max = cur;
					}
				}
			}
		}

		return max;

	}

	private void print(int[][] help) {
		for (int i = 1; i < help.length; i++) {
			for (int j = 1; j < help[0].length; j++) {
				System.out.print(help[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
	}

}
