package hou.forwz.Leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author houweitao
 * @date 2016年8月14日下午11:00:25
 * @runtime_error 2016年08月14日23:13:07
 * @nice 2016年08月14日23:59:30
 */

public class SurroundedRegions2 {
	boolean[][] visited;

	public static void main(String[] args) {
		SurroundedRegions2 sr = new SurroundedRegions2();
		sr.init();
	}

	private void init() {

		String[] strs = { "XOOOOOOOOOOOOOOOOOOO", "OXOOOOXOOOOOOOOOOOXX", "OOOOOOOOXOOOOOOOOOOX",
				"OOXOOOOOOOOOOOOOOOXO", "OOOOOXOOOOXOOOOOXOOX", "XOOOXOOOOOXOXOXOXOXO", "OOOOXOOXOOOOOXOOXOOO",
				"XOOOXXXOXOOOOXXOXOOO", "OOOOOXXXXOOOOXOOXOOO", "XOOOOXOOOOOOXXOOXOOX", "OOOOOOOOOOXOOXOOOXOX",
				"OOOOXOXOOXXOOOOOXOOO", "XXOOOOOXOOOOOOOOOOOO", "OXOXOOOXOXOOOXOXOXOO", "OOXOOOOOOOXOOOOOXOXO",
				"XXOOOOOOOOXOXXOOOXOO", "OOXOOOOOOOXOOXOXOXOO", "OOOXOOOOOXXXOOXOOOXO", "OOOOOOOOOOOOOOOOOOOO",
				"XOOOOXOOOXXOOXOXOXOO" };
		char[][] board = build(strs);
		print(board);
		solve(board);
		System.out.println();
		print(board);
	}

	private void print(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
	}

	private char[][] build(String[] strs) {
		char[][] ret = new char[strs.length][strs[0].length()];
		for (int i = 0; i < strs.length; i++) {
			for (int j = 0; j < ret[0].length; j++) {
				ret[i][j] = strs[i].charAt(j);
			}
		}

		return ret;
	}

	public void solve(char[][] board) {
		if (board.length < 1)
			return;

		visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			bfs(board, i, 0);
			bfs(board, i, board[0].length - 1);
		}
		for (int i = 0; i < board[0].length; i++) {
			bfs(board, 0, i);
			bfs(board, board.length - 1, i);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == 'P')
					board[i][j] = 'O';
			}
		}

	}

	private void bfs(char[][] board, int i, int j) {
		if (yes(board, i, j) && board[i][j] == 'O') {
			Queue<Point> queue = new LinkedList<>();
			Point cur = new Point(i, j);
			visited[i][j] = true;

			queue.offer(cur);
			while (!queue.isEmpty()) {
				Point point = queue.poll();
				board[point.x][point.y] = 'P';

				if (yes(board, point.x + 1, point.y) && !visited[point.x + 1][point.y]
						&& board[point.x + 1][point.y] == 'O') {
					visited[point.x + 1][point.y] = true;
					queue.offer(new Point(point.x + 1, point.y));
				}
				if (yes(board, point.x - 1, point.y) && !visited[point.x - 1][point.y]
						&& board[point.x - 1][point.y] == 'O') {
					visited[point.x - 1][point.y] = true;
					queue.offer(new Point(point.x - 1, point.y));
				}
				if (yes(board, point.x, point.y + 1) && !visited[point.x][point.y + 1]
						&& board[point.x][point.y + 1] == 'O') {
					visited[point.x][point.y + 1] = true;
					queue.offer(new Point(point.x, point.y + 1));
				}
				if (yes(board, point.x, point.y - 1) && !visited[point.x][point.y - 1]
						&& board[point.x][point.y - 1] == 'O') {
					visited[point.x][point.y - 1] = true;
					queue.offer(new Point(point.x, point.y - 1));
				}
			}
		}
	}

	private boolean yes(char[][] help, int i, int j) {
		if (i >= 0 && i < help.length && j >= 0 && j < help[0].length)
			return true;
		else
			return false;

	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
