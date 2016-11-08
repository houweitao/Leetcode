package hou.enjoy.HackerRank.contest.ncrCodesprint;

import java.util.Scanner;

/**
 * @author houweitao
 * @date 2016年11月7日上午10:43:31
 * @url https://www.hackerrank.com/contests/ncr-codesprint/challenges/counting-mistakes
 */

public class CountingMistakes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int last = 0;
		int wrong = 0;

		for (int i = 0; i < n; i++) {
			int cur = in.nextInt();
			if (cur != last + 1) {
				wrong++;
			}
			last = cur;
		}
		System.out.println(wrong);
	}
}
