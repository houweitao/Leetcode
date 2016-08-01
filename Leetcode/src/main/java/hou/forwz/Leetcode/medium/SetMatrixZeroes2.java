package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年8月2日上午12:47:52
 */

public class SetMatrixZeroes2 {

	public void setZeroes(int[][] matrix) {
		if (matrix.length < 1)
			return;

		int m = matrix.length, n = matrix[0].length;

		int[] shu = new int[m];
		int[] heng = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					heng[j] = 1;
					shu[i] = 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			if (shu[i] == 1)
				for (int j = 0; j < n; j++)
					matrix[i][j] = 0;
		}
		for (int i = 0; i < n; i++) {
			if (heng[i] == 1)
				for (int j = 0; j < m; j++)
					matrix[j][i] = 0;
		}
	}

}
