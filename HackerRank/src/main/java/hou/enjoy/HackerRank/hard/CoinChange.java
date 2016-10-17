package hou.enjoy.HackerRank.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author houweitao
 * @date 2016年10月15日下午11:01:22
 */

public class CoinChange {
	static int changeNum = 0;

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		Scanner scanner = new Scanner(System.in);
		int money = scanner.nextInt();
		int num = scanner.nextInt();
		int[] nums = new int[num];
		for (int i = 0; i < num; i++) {
			nums[i] = scanner.nextInt();
		}
		Arrays.sort(nums);

		List<Integer> tmp = new ArrayList<>();
		dfs(nums, 0, money, tmp);
		System.out.println(changeNum);
		// dp(nums, money);
	}

	private static void dp(int[] nums, int money) {
		StringBuilder sb = new StringBuilder();
		for (int i : nums)
			sb.append(i + ",");
		System.out.println(sb);

		int[] dp = new int[money + 1];
		dp[0] = 1;
		for (int i = 1; i <= money; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] == i) {
					dp[i]++;
				} else if (nums[j] < i && dp[i - nums[j]] != 0) {
					dp[i] += dp[i - nums[j]];
				} else {
					// break;
				}
			}
		}

		for (int i : dp)
			System.out.println(i);
		System.out.println(dp[money]);
	}

	// class Help {
	// int num;
	// int last;
	//
	// public Help(int num, int last) {
	// super();
	// this.num = num;
	// this.last = last;
	// }
	//
	// }

	private static void dfs(int[] nums, int pos, int money, List<Integer> tmp) {
		if (money < 0) {
			return;
		} else if (money == 0) {
			System.out.println(++changeNum + ": " + tmp);
		} else {
			for (int i = pos; i < nums.length; i++) {
				tmp.add(nums[i]);
				dfs(nums, i, money - nums[i], tmp);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
