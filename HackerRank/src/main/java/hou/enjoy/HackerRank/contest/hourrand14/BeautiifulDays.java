package hou.enjoy.HackerRank.contest.hourrand14;

import java.util.Scanner;

/**
 * @author houweitao
 * @date 2016年11月3日上午12:56:14
 */

public class BeautiifulDays {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		init();
	}

	private static void init() {
		Scanner scanner = new Scanner(System.in);
		int begin = scanner.nextInt();
		int end = scanner.nextInt();
		int num = scanner.nextInt();

		System.out.println(count(begin, end, num));
	}

	private static int count(int begin, int end, int num) {
		int count = 0;
		for (int i = begin; i <= end; i++) {
			int other = get(i);
			int cha = Math.abs(i - other);

			if (cha % num == 0)
				count++;
		}
		return count;
	}

	private static int get(int num) {
		StringBuilder sb = new StringBuilder(num + "");
		return Integer.valueOf(sb.reverse().toString());
	}
}
