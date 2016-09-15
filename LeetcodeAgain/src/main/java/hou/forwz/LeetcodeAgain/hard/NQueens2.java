package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年9月16日上午2:21:17
 */

public class NQueens2 {
	public static void main(String[] args) {
		NQueens2 nq = new NQueens2();
		System.out.println(nq.queen(8));
	}

	int queen(int n) {
		int[] queen = new int[n];
		int count = 0;
		int pos = 0;
		while (pos >= 0) {
			// System.out.println(pos);
			queen[pos]++;
			if (queen[pos] == n + 1) {
				queen[pos] = 0;
				pos--;
			} else if (nice(queen, pos)) {
				// System.out.println("find " + pos);
				if (pos == n - 1) {
					// System.out.println("find");
					count++;
				} else {
					pos++;
				}
			}
		}

		return count;
	}

	private boolean nice(int[] queen, int pos) {
		for (int i = 0; i < pos; i++) {
			if (queen[pos] == queen[i] || (pos - i) == Math.abs(queen[pos] - queen[i]))
				return false;
		}
		return true;
	}
}
