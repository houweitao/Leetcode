package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年7月14日上午2:00:45
 */

public class WordSearchII {

	public List<String> findWords(char[][] board, String[] words) {
		List<String> ret = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for (String str : words) {
			if (!set.contains(str) && exist(board, str)) {
				set.add(str);
				ret.add(str);
			}
		}
		return ret;
	}

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (help(board, i, j, word, 0))
					return true;
			}
		}
		return false;
	}

	private boolean help(char[][] board, int m, int n, String word, int pos) {
		if (pos == word.length())
			return true;

		if (in(board, m, n) && board[m][n] == word.charAt(pos)) {
			board[m][n] = '#';

			if (help(board, m, n + 1, word, pos + 1) || help(board, m + 1, n, word, pos + 1)
					|| help(board, m - 1, n, word, pos + 1) || help(board, m, n - 1, word, pos + 1)) {
				board[m][n] = word.charAt(pos);
				return true;
			} else
				board[m][n] = word.charAt(pos);

		}

		return false;
	}

	private boolean in(char[][] board, int m, int n) {
		if (m >= 0 && m < board.length && n >= 0 && n < board[0].length)
			return true;
		else
			return false;
	}

}
