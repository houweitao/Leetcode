package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月22日下午11:00:58
 */

public class SpiralMatrixII {
	public static void main(String[] args) {
		SpiralMatrixII sm = new SpiralMatrixII();
		System.out.println(sm.generateMatrix(5));
	}

	public int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];
		if (n == 0)
			return ret;
		int left = 0, right = n - 1, up = 0, down = n - 1;

		int cur = 1;
		while (left <= right && up <= down) {

			for (int i = left; i <= right; i++) {
				ret[up][i] = cur++;
			}

			up++;
			if (up > down)
				break;
			for (int i = up; i <= down; i++) {
				ret[i][right] = cur++;
			}

			right--;
			if (right < left)
				break;

			for (int i = right; i >= left; i--) {
				ret[down][i] = cur++;
			}

			down--;
			if (down < up)
				break;

			for (int i = down; i >= up; i--)
				ret[i][left] = cur++;

			left++;
		}

		System.out.println(cur);
		print(ret);
		return ret;

	}

	private void print(int[][] ret) {

		for (int i = 0; i < ret.length; i++) {
			for (int j = 0; j < ret[0].length; j++) {
				System.out.print(ret[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
