package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月15日下午3:56:05
 */

public class NQueens {
	public static void main(String[] args) {
		NQueens q = new NQueens();
		System.out.println(q.solveNQueens(8));
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ret = new ArrayList<>();
		int[] queen = new int[n];
		for (int i = 0; i < n; i++) {
			queen[i] = -1;
		}

		int pos = 0;
		while (pos >= 0) {
			// System.out.println(pos + "," + queen[pos]);

			boolean find = false;
			while (queen[pos] < n - 1) {
				queen[pos]++;
				if (nice(queen, pos)) {
					find = true;
					pos++;
					if (pos == n) {
//						System.out.println("find");
						pos--;
						find = false;
						build(ret, queen);
						break;
					}
				}
			}

			if (!find) {
				queen[pos] = -1;
				pos--;
			}

		}
		return ret;
	}

	private void build(List<List<String>> ret, int[] queen) {
		List<String> tmp = new ArrayList<>();
		for (int i = 0; i < queen.length; i++) {
			int pos = queen[i];
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < queen.length; j++) {
				if (j == pos)
					sb.append("Q");
				else
					sb.append(".");
			}
			tmp.add(sb.toString());
		}
		ret.add(tmp);
	}

	private boolean nice(int[] queen, int pos) {
		for (int i = 0; i < pos; i++) {
			if (queen[i] == queen[pos] || (Math.abs(pos - i) == Math.abs(queen[pos] - queen[i])))
				return false;
		}
		return true;
	}

}
