package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月1日上午1:20:29
 */

public class GameOfLife {
	public static void main(String[] args) {
		GameOfLife gl = new GameOfLife();
		int[][] board = { { 1, 1 }, { 1, 0 } };
		gl.gameOfLife(board);
	}

	public void gameOfLife(int[][] board) {
		if (board.length < 1)
			return;

		int[][] next = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				deal(board, i, j, next);
			}
		}
		// board = next;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = next[i][j];
			}
		}
		 System.out.println(board[0][0]);
	}

	private void deal(int[][] board, int x, int y, int[][] next) {
		int live = 0, dead = 0;

		if (in(board, x, y + 1)) {
			if (board[x][y + 1] == 1)
				live++;
			else
				dead++;
		}
		if (in(board, x, y - 1)) {
			if (board[x][y - 1] == 1)
				live++;
			else
				dead++;
		}
		if (in(board, x + 1, y)) {
			if (board[x + 1][y] == 1)
				live++;
			else
				dead++;
		}
		if (in(board, x - 1, y)) {
			if (board[x - 1][y] == 1)
				live++;
			else
				dead++;
		}
		if (in(board, x + 1, y + 1)) {
			if (board[x + 1][y + 1] == 1)
				live++;
			else
				dead++;
		}
		if (in(board, x - 1, y + 1)) {
			if (board[x - 1][y + 1] == 1)
				live++;
			else
				dead++;
		}
		if (in(board, x + 1, y - 1)) {
			if (board[x + 1][y - 1] == 1)
				live++;
			else
				dead++;
		}
		if (in(board, x - 1, y - 1)) {
			if (board[x - 1][y - 1] == 1)
				live++;
			else
				dead++;
		}

		System.out.println(x+","+y+": "+live);
		
		if (board[x][y] == 1) {
			if (live < 2 || live > 3)
				next[x][y] = 0;
		} else {
			if (live == 3)
				next[x][y] = 1;
		}
	}

	private boolean in(int[][] board, int x, int y) {
		if (x >= 0 && x < board.length && y >= 0 && y < board[0].length)
			return true;
		else
			return false;
	}

}
