package hou.enjoy.HackerRank.contest.hourrand14;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author houweitao
 * @date 2016年11月3日上午1:14:01
 */

public class Homework {
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

		int[] nums = new int[num];
		int[] help = new int[num];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = scanner.nextInt();
			help[i] = nums[i];
		}

		Arrays.sort(help);

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != help[i]) {
				for (int j = i + 1; j < num; j++) {
					if (nums[j] == help[i]) {
						count++;
						swap(nums, i, j);
						break;
					}
				}
			}
		}

		System.out.println(count);
	}

	private static void print(int[] help) {
		for (int i : help) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
