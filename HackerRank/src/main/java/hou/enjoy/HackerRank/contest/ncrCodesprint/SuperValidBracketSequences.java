package hou.enjoy.HackerRank.contest.ncrCodesprint;

import java.util.Scanner;

/**
 * @author houweitao
 * @date 2016年11月7日上午11:48:25
 */

public class SuperValidBracketSequences {
	static int out = 0;

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		init();
	}

	private static void init() {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		for (int i = 0; i < num; i++) {
			int n = in.nextInt();
			int k = in.nextInt();

			if (n % 2 == 1)
				System.out.println(0);
			else {
				deal(n, k);
				System.out.println(out);
				out = 0;
			}
		}
	}

	private static void deal(int n, int k) {
		dfs(n / 2, n / 2, 0, k, '$');
	}

	private static void dfs(int i, int j, int now, int k, char last) {
		if (i == 0 && j == 0 && now >= k)
			out++;
		if (now + i + j < k)
			return;
		if (i < 0 || j < 0 || i > j)
			return;

		// +(
		int nextNow = now;
		if (last == ')')
			nextNow++;
		dfs(i - 1, j, nextNow, k, '(');

		nextNow = now;
		if (last == '(')
			nextNow++;
		dfs(i, j - 1, nextNow, k, ')');

	}

	boolean isSuperValid(String s, int k) {
		int count = 0;
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != ch[i + 1])
				count++;
		}
		if (count >= k)
			return true;
		else
			return false;
	}
}
