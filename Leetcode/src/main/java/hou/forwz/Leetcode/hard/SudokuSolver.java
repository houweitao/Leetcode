package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年8月14日下午11:59:52
 */

public class SudokuSolver {

	char[] charMap = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static void main(String[] args) {
		SudokuSolver ss = new SudokuSolver();
		ss.init();
	}

	private void init() {
		String[] strs = { "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.",
				"........6", "...2759.." };
		char[][] board = build(strs);
		print(board);
		System.out.println();

		solveSudoku(board);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char bak = board[i][j];
				board[i][j] = '.';
				List<Integer> list = makeList(board, i, j);
				System.out.println(i + "," + j + ": " + bak + "," + list);
				board[i][j] = bak;
			}
		}

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

	public void solveSudoku(char[][] board) {
		Answer[][] answers = new Answer[board.length][board[0].length];
		List<Answer> list = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					Answer answer = new Answer(i, j);
					answer.list = makeList(board, i, j);
					answers[i][j] = answer;
					list.add(answer);
					System.out.println(i + "," + j + ": " + answers[i][j].list);
					// return;
				}
			}
		}

		Stack<Answer> stack = new Stack<>();
		stack.push(list.get(0));

		while (!stack.isEmpty()) {
			Answer peek = stack.peek();
			peek.point++;

			if (peek.point == peek.list.size()) {
				peek.point = -1;
				board[peek.x][peek.y] = '.';// 恢复原始状态 2016年08月15日01:03:51
				stack.pop();
			} else {
				// System.out.println(stack);

				int ch = peek.getPoint();
				char next = charMap[ch];
				if (niceTry2(board, peek.x, peek.y, ch)) {
					board[peek.x][peek.y] = next;

					int pos = stack.size();
					if (pos == list.size()) {
						System.out.println("success");
						// print(board);
						// System.out.println("----");
						return;
					} else
						stack.push(list.get(pos));
				}

			}

		}

	}

	private boolean niceTry(char[][] board, int x, int y, int now) {
		List<Integer> curList = makeList(board, x, y);
		if (curList.contains(now))
			return true;
		else
			return false;
	}

	private boolean niceTry2(char[][] board, int i, int j, int ch) {
		char c = charMap[ch];

		// Check colum
		for (int row = 0; row < 9; row++)
			if (board[row][j] == c)
				return false;

		// Check row
		for (int col = 0; col < 9; col++)
			if (board[i][col] == c)
				return false;

		// Check 3 x 3 block
		for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
			for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
				if (board[row][col] == c)
					return false;
		return true;
	}

	private List<Integer> makeList(char[][] board, int i, int j) {
		int shuPos = i / 3;
		int hengPos = j / 3;

		Set<Integer> fangkuai = getFangkuaiList(board, shuPos, hengPos);
		Set<Integer> heng = getHeng(board, i);
		Set<Integer> shu = getShu(board, j);

		// System.out.println(fangkuai);
		// System.out.println(heng);
		// System.out.println(shu);

		fangkuai.addAll(heng);
		fangkuai.addAll(shu);

		List<Integer> ret = new ArrayList<>();
		for (int index = 1; index < 10; index++) {
			if (!fangkuai.contains(index))
				ret.add(index);
		}

		return ret;
	}

	private Set<Integer> getShu(char[][] board, int n) {
		Set<Integer> ret = new HashSet<>();

		for (int i = 0; i < 9; i++) {
			if (board[i][n] != '.') {
				int rm = board[i][n] - '0';
				ret.add(rm);
			}
		}

		return ret;
	}

	private Set<Integer> getHeng(char[][] board, int m) {
		Set<Integer> ret = new HashSet<>();

		for (int i = 0; i < 9; i++) {
			if (board[m][i] != '.') {
				int rm = board[m][i] - '0';
				ret.add(rm);
			}
		}

		return ret;
	}

	private Set<Integer> getFangkuaiList(char[][] board, int shuPos, int hengPos) {
		Set<Integer> ret = new HashSet<>();
		for (int i = 3 * shuPos; i < 3 * shuPos + 3; i++) {
			for (int j = 3 * hengPos; j < 3 * hengPos + 3; j++) {
				if (board[i][j] != '.') {
					int rm = board[i][j] - '0';
					ret.add(rm);
				}
			}
		}

		return ret;
	}

	class Answer {
		int x;
		int y;
		List<Integer> list;
		int point;

		Answer(int x, int y) {
			this.x = x;
			this.y = y;
			list = new ArrayList<>();
			point = -1;
		}

		int getPoint() {
			return list.get(point);
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "(" + x + "," + y + "): " + getPoint();
		}
	}
}
