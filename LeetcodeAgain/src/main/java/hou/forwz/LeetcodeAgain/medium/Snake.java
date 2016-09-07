package hou.forwz.LeetcodeAgain.medium;

import java.util.Scanner;

/**
 * @author houweitao
 * @date 2016年9月1日下午8:41:58
 */

public class Snake {

	public static void main(String[] args) {
		Snake snake = new Snake();
		snake.out(7);
		snake.init();
	}

	private void init() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		out(n);
	}

	void out(int n) {
		if (n <= 0)
			return;

		int[][] ret = new int[n][n];

		int up = 0, down = n - 1, left = 0, right = n - 1;

		int pos = 1;
		while (up < down && left < right) {
			for (int i = left; i <= right; i++) {
				ret[up][i] = pos++;
			}
			up++;

			for (int i = up; i <= down; i++) {
				ret[i][right] = pos++;
			}
			right--;

			for (int i = right; i >= left; i--) {
				ret[down][i] = pos++;
			}
			down--;

			for (int i = down; i >= up; i--) {
				ret[i][left] = pos++;
			}
			left++;

		}

		if (n % 2 == 1) {
			ret[n / 2][n / 2] = n * n;
		}

		print(ret);

	}

	private void print(int[][] ret) {
		for (int i = 0; i < ret.length; i++) {
			for (int j = 0; j < ret[0].length; j++) {
				System.out.print(ret[i][j] + " ");
			}
			// System.out.println();
		}
		System.out.println();
	}
}
