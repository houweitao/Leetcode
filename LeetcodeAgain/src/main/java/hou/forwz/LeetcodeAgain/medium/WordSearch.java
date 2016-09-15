package hou.forwz.LeetcodeAgain.medium;

/**
 * @author houweitao
 * @date 2016年9月15日下午6:29:39
 */

public class WordSearch {

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (help(board, i, j, word, 0))
					return true;
			}
		}
		return false;
	}

	private boolean help(char[][] board, int i, int j, String word, int pos) {
		if (pos == word.length())
			return true;
		else if (!in(board, i, j))
			return false;
		else if (board[i][j] == word.charAt(pos)) {
			// System.out.println(word+","+pos+":"+word.charAt(pos));

			board[i][j] = '$';
			boolean yes = false;

			yes = help(board, i + 1, j, word, pos + 1) || help(board, i, j + 1, word, pos + 1)
					|| help(board, i - 1, j, word, pos + 1) || help(board, i, j - 1, word, pos + 1);

			board[i][j] = word.charAt(pos);
			return yes;
		} else
			return false;
	}

	private boolean in(char[][] board, int i, int j) {
		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length)
			return true;
		else
			return false;
	}

}
