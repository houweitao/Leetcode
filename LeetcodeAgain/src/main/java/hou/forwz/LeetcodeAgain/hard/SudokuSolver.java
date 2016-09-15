package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年9月15日下午1:44:08
 */

public class SudokuSolver {
	public static void main(String[] args) {
		SudokuSolver ss = new SudokuSolver();
		ss.init();
	}

	private void init() {
		String[] strs = { "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.",
				"...419..5", "....8..79" };
		char[][] board = build(strs);
		print(board);
		System.out.println();

		// solveSudoku(board);
		solveSudokuNew(board);
		// print(board);
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

	// 2016年09月16日02:49:11
	public void solveSudokuNew(char[][] board) {
		boolean[] help = new boolean[81];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				if (c - '0' > 0 && c - '9' <= 0)
					help[i * 9 + j] = true;
			}
		}

		int pos = 0;
		while (pos >= 0) {
			if (help[pos]) {
				pos++;
				// System.out.println(pos);
				if (pos == 81) {
					System.out.println("find~~~");
					print(board);
					break;
				}
			} else {
				int heng = pos / 9;
				int shu = pos % 9;
				char begin = board[pos / 9][pos % 9];
				if (board[pos / 9][pos % 9] == '.') {
					begin = '0';
				}

				boolean find = false;
				for (char ch = begin; ch <= '9'; ch++) {
					if (ch != begin) {
						board[heng][shu] = ch;
						if (easyNice(board, pos)) {
							find = true;
							if (pos == 80) {
								System.out.println("!!!yes!!!");
								return;
							} else {
								pos++;
								break;
							}
						}
					}
				}

				if (!find) {
					board[heng][shu] = '.';
					pos--;
					while (help[pos]) {
						pos--;
					}
				}

			}
		}

	}

	public void solveSudoku(char[][] board) {
		char[][] help = new char[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				if (c - '0' > 0 && c - '9' <= 0)
					help[i][j] = c;
				else
					help[i][j] = '0';
			}
		}

		int pos = 0;
		while (pos >= 0) {
			if (pos == 81) {
				print(help);
				return;
			}

			int heng = pos / 9, shu = pos % 9;
			if (isChar(board[heng][shu])) {
				pos++;
			} else {
				char c = help[heng][shu];

				// System.out.println(pos+", "+c);

				boolean find = false;
				for (char ch = c; ch <= '9'; ch++) {
					if (ch == c)
						continue;
					help[heng][shu] = ch;
					if (easyNice(help, pos)) {
						// System.out.println(pos + ", " + ch);
						find = true;
						pos++;
						// if (pos == 81) {
						// // print(help);
						//
						// for (int i = 0; i < 9; i++) {
						// for (int j = 0; j < 9; j++) {
						// board[i][j] = help[i][j];
						// }
						// }
						//
						// return;
						// }
						break;
					}
				}

				if (!find) {
					help[heng][shu] = '0';
					pos--;
					if (pos < 0)
						return;

					while (true) {
						int h = pos / 9;
						int s = pos % 9;
						if (isChar(board[h][s])) {
							pos--;
							if (pos == -1)
								return;
						} else
							break;
					}
				}
			}
		}

	}

	private boolean isChar(char c) {
		if (c - '0' > 0 && c - '9' <= 0)
			return true;
		else
			return false;
	}

	boolean easyNice(char[][] board, int pos) {
		int heng = pos / 9;
		int shu = pos % 9;

		return nice(board, heng, shu);
	}

	boolean nice(char[][] board, int i, int j) {
		int heng = (i) / 3;
		int shu = (j) / 3;
		char c = board[i][j];
		for (int k = 0; k < 9; k++) {
			if (k != i) {
				if (board[k][j] == c)
					return false;
			}

			if (k != j) {
				if (board[i][k] == c)
					return false;
			}
		}

		for (int m = 3 * heng; m < 3 * heng + 3; m++) {
			for (int n = 3 * shu; n < 3 * shu + 3; n++) {
				if (m != i && n != j) {
					if (board[m][n] == c)
						return false;
				} else {
					// System.out.println("same");
				}
			}
		}

		return true;
	}
}
