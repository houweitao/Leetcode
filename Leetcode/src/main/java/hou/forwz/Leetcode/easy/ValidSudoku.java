package hou.forwz.Leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年7月9日下午11:28:04
 */

public class ValidSudoku {
	public static void main(String[] args) {
		char[][] map = new char[10][10];
		System.out.println('.' - '0');
	}

	public boolean isValidSudoku(char[][] board) {
		if (board.length != 9 || board[0].length != 9)
			return false;

		for (int i = 0; i < 9; i++) {
			Set<Character> hengSet = new HashSet<>();
			Set<Character> shuSet = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c - '0' > 0) {
					if (hengSet.contains(c))
						return false;
					else
						hengSet.add(c);
				}
				c = board[j][i];
				if (c - '0' > 0) {
					if (shuSet.contains(c))
						return false;
					else
						shuSet.add(c);
				}
			}
		}

		for (int i = 0; i < 9; i = i + 3) {
			for (int j = 0; j < 9; j = j + 3) {
				Set<Character> set = new HashSet<>();
				for (int k = i; k < k + 3; k++) {
					for (int m = j; m < j + 3; m++) {
						char c = board[k][m];
						if (c - '0' > 0) {
							if (set.contains(c))
								return false;
							else
								set.add(c);
						}
					}
				}

			}
		}

		return true;
	}

}
