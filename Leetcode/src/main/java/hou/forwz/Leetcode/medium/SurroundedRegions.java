package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月16日下午10:26:29
 * @url https://leetcode.com/submissions/detail/67315824/
 */

public class SurroundedRegions {
	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		sr.print(board);
		sr.solve(board);
		System.out.println();
		sr.print(board);
	}

	void print(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				System.out.print(board[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void solve(char[][] board) {
		if (board.length == 0)
			return;

		int m = board.length - 1, n = board[0].length - 1;

		for (int i = 0; i <= m; i++) {
			deal(board, i, 0);
			deal(board, i, n);

		}

		for (int j = 0; j <= n; j++) {
			deal(board, 0, j);
			deal(board, m, j);
		}

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (board[i][j] == '#')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}

	private void deal(char[][] board, int m, int n) {
		if (in(board, m, n) && board[m][n] == 'O') {
			board[m][n] = '#';
			deal(board, m, n + 1);
			deal(board, m, n - 1);
			deal(board, m + 1, n);
			deal(board, m - 1, n);
		}

	}

	private boolean in(char[][] board, int m, int n) {
		if (m >= 0 && n >= 0 && m < board.length && n < board[0].length)
			return true;
		else
			return false;
	}

}
