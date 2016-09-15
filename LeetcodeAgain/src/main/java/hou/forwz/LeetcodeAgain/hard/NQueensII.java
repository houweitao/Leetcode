package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年9月15日下午4:32:57
 */

public class NQueensII {

	public int totalNQueens(int n) {
		int[] queen = new int[n];
		int pos = 0;
		int num = 0;

		while (pos >= 0) {
			queen[pos]++;
			if (queen[pos] == n + 1) {
				queen[pos] = 0;
				pos--;
			} else {
				if (nice(queen, pos)) {
					if (pos == n - 1) {
						num++;
					} else {
						pos++;
					}
				}
			}
		}
		return num;
	}

	boolean nice(int[] queen, int pos) {
		for (int i = 0; i < pos; i++) {
			if (queen[i] == queen[pos] || (Math.abs(queen[i] - queen[pos]) == Math.abs(pos - i)))
				return false;
		}
		return true;
	}

}
