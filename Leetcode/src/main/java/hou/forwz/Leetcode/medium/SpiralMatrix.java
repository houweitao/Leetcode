package hou.forwz.Leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月11日下午11:50:50
 */

public class SpiralMatrix {
	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = { { 1, 2, 3 } };
		// , { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		System.out.println(sm.spiralOrder(matrix));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new LinkedList<>();
		int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;

		while (up <= down && left <= right) {
			for (int k = left; k < right; k++) {
				ret.add(matrix[up][k]);
			}
			System.out.println(ret);
			for (int k = up; k < down; k++) {
				ret.add(matrix[k][right]);
			}
			up++;
			System.out.println(ret);

			for (int k = right; k > left; k--)
				ret.add(matrix[down][k]);
			right--;
			System.out.println(ret);

			for (int k = down; k > up; k--)
				ret.add(matrix[k][left]);
			down--;
			System.out.println(ret);

			left++;

		}
		return ret;
	}

}
