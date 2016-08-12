package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月12日上午1:35:08
 */

public class NQueensII {
	public static void main(String[] args) {
		NQueensII nq = new NQueensII();
		System.out.println(nq.totalNQueens(1));
	}

	public int totalNQueens(int n) {
		if(n==0)
			return 0;
		int[] queen = new int[n];
		for (int i = 0; i < n; i++)
			queen[i] = -1;
		int num = 0;
		int pos = 0;
		while (pos >= 0) {
			queen[pos]++;
			if (queen[pos] == n) {
				queen[pos] = -1;
				pos--;
			} else {
				if (nice(queen, pos)) {
					if (pos == n-1) {
						num++;
					} else {
						pos++;
					}
				}
			}
		}
		return num;
	}

	private boolean nice(int[] queen, int pos) {
		for (int i = 0; i < pos; i++) {
			if (queen[i] == queen[pos] || Math.abs(i - pos) == Math.abs(queen[i] - queen[pos]))
				return false;
		}

		return true;
	}

}
