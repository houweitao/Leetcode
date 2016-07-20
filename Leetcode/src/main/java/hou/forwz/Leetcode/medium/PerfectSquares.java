package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月21日上午2:56:29
 */

public class PerfectSquares {
	public static void main(String[] args) {
		PerfectSquares ps = new PerfectSquares();
		System.out.println(ps.numSquares(5812));
	}

	public int numSquares(int n) {
		int[] many = new int[n + 1];
		Arrays.fill(many, n+2);
		many[0]=0;
		many[1] = 1;

		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, many[i - j * j] + 1);
			}
			many[i] = min;
		}

		for (int q : many)
			System.out.print(q + " ");
		System.out.println();
		return many[n];
	}

}
