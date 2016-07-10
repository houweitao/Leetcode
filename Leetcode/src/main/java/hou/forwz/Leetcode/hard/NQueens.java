package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月11日上午12:34:27
 */

public class NQueens {

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		System.out.println(nq.solveNQueens(8));
		System.out.println(nq.solveNQueens(8).size());
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ret = new ArrayList<>();
		int[] queen = new int[n];
		for (int i = 0; i < n; i++)
			queen[i] = -1;

		int cur = 0;

		while (cur < n) {
			queen[cur]++;
			print(queen);
			if (queen[cur] == n) {
				queen[cur] = -1;
				cur--;
				if (cur == -1)
					break;
			} else {
				if (yes(queen)) {
					if (cur == n - 1) {
						System.out.println("end");
						List<String> now = generate(queen);
						ret.add(now);
					} else
						cur++;
				}
			}
		}
		return ret;
	}

	private void print(int[] queen) {
		for (int n : queen)
			System.out.print(n + ",");
		System.out.println();

	}

	private List<String> generate(int[] queen) {
		List<String> ret = new ArrayList<>();

		for (int i = 0; i < queen.length; i++) {
			StringBuffer str = new StringBuffer();
			for (int j = 0; j < queen.length; j++) {
				if (j == queen[i])
					str.append("Q");
				else
					str.append(".");
			}
			ret.add(str.toString());
		}
		return ret;
	}

	private boolean yes(int[] queen) {
		for (int i = 0; i < queen.length; i++) {
			if (queen[i] == -1)
				return true;
			else {
				for (int j = i + 1; j < queen.length; j++) {
					if (queen[j] == -1)
						break;
					else {
						if (queen[j] == queen[i] || Math.abs(j - i) == Math.abs(queen[j] - queen[i]))
							return false;
					}
				}

			}
		}

		return true;
	}

}
