package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月10日下午10:51:17
 * @end  yes 2016-07-10 23:13:23
 */

public class RotateImage {

	public void rotate(int[][] matrix) {

		if (matrix.length < 2)
			return;
		else {
			int len = matrix.length;
			for (int i = 0; i <= (len - 1) / 2; i++) {
				for (int j = i; j < len - i - 1; j++) {
					int tmp = matrix[i][j];
					matrix[i][j] = matrix[len - j - 1][i];
					matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
					matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
					matrix[j][len - i - 1] = tmp;
				}

			}
		}

	}

}
