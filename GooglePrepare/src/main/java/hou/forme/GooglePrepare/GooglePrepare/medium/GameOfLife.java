package hou.forme.GooglePrepare.GooglePrepare.medium;

/**
 * @author houweitao
 * @date 2016年12月6日下午3:32:21
 */

public class GameOfLife {
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0)
			return;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = cal(board, i, j);
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = next(board[i][j]);
			}
		}

	}

	private int next(int n) {
		if (n > 0) {
			if (n < 2)
				return 0;
			else if (n == 2 || n == 3)
				return 1;
			else
				return 0;
		} else {
			n = -n;
			if (n == 3)
				return 1;
			else
				return 0;
		}
	}

	private int cal(int[][] board, int i, int j) {
		int sum = get(board, i + 1, j) + get(board, i - 1, j) + get(board, i, j + 1) + get(board, i, j - 1)
				+ get(board, i + 1, j + 1) + get(board, i - 1, j - 1) + get(board, i + 1, j - 1)
				+ get(board, i - 1, j + 1);

		if (get(board, i, j) == 1)
			return Math.max(sum, 1);// 不能变性！2016年12月06日15:45:55
		else
			return -sum;
	}

	private int get(int[][] board, int i, int j) {
		if (in(board, i, j) && board[i][j] > 0) {
			return 1;
		} else
			return 0;
	}

	private boolean in(int[][] board, int i, int j) {
		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length)
			return true;
		return false;
	}
}
