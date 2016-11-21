package hou.enjoy.HackerRank.easy;

import java.util.Scanner;

/**
 * @author houweitao
 * @date 2016年11月10日下午2:32:39
 * @end 2016年11月10日14:43:45
 * @url https://www.hackerrank.com/challenges/sherlock-and-array
 */

public class SherlockAndArray {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		init();
	}

	private static void init() {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();

		for (int i = 0; i < num; i++) {
			int n = scanner.nextInt();
			int[] nums = new int[n];
			for (int j = 0; j < n; j++) {
				nums[j] = scanner.nextInt();
			}

			System.out.println(deal(nums, n));
		}
	}

	private static String deal(int[] nums, int n) {
		String yes = "YES", no = "NO";
		if (n == 0)
			return no;
		else if (n == 1)
			return yes;
		else {
			int[] left = new int[n];
			int[] right = new int[n];

			for (int i = 1; i < n; i++) {
				if (i == 1)
					left[1] = nums[0];
				else
					left[i] = left[i - 1] + nums[i - 1];
			}

			for (int i = n - 2; i >= 0; i--) {
				if (i == n - 2)
					right[i] = nums[n - 1];
				else
					right[i] = right[i + 1] + nums[i + 1];
			}

			for (int i = 0; i < n; i++) {
				if (get(left, i) == get(right, i))
					return yes;
			}
			return no;
		}
	}

	private static int get(int[] left, int i) {
		if (i < 0 || i >= left.length)
			return 0;
		else
			return left[i];
	}
}
