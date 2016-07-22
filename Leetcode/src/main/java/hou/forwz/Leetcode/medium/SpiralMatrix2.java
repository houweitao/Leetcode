package hou.forwz.Leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月22日下午10:47:16
 */

public class SpiralMatrix2 {
	public static void main(String[] args) {

		SpiralMatrix2 sm = new SpiralMatrix2();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		System.out.println(sm.spiralOrder(matrix));

	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new LinkedList<>();
		if (matrix.length == 0)
			return ret;

		int m = matrix.length - 1, n = matrix[0].length - 1;

		int up = 0, down = m, left = 0, right = n;

		while (left <= right && up <= down) {
			for (int i = left; i <= right; i++) {
				ret.add(matrix[up][i]);
			}
			up++;

			if (up > down)
				break;

			for (int i = up; i <= down; i++) {
				ret.add(matrix[i][right]);
			}
			right--;

			if (right < left)
				break;
			for (int i = right; i >= left; i--) {
				ret.add(matrix[down][i]);
			}
			down--;

			if (down < up)
				break;

			for (int i = down; i >= up; i--) {
				ret.add(matrix[i][left]);
			}
			left++;

			if (left > right)
				break;
		}
		return ret;
	}

}
