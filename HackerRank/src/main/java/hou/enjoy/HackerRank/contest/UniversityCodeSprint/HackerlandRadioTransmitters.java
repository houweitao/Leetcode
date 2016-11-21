package hou.enjoy.HackerRank.contest.UniversityCodeSprint;

import java.util.Scanner;

/**
 * @author houweitao
 * @date 2016年11月11日下午3:47:43
 */

public class HackerlandRadioTransmitters {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] x = new int[n];
		for (int x_i = 0; x_i < n; x_i++) {
			x[x_i] = in.nextInt();
		}

		System.out.println(deal(x, k));
	}

	private static int deal(int[] nums, int k) {
		if (k == 0)
			return nums.length;
		int[] dp = new int[100000 + k];
		int[] help = new int[100000 + k];

		for (int i = 0; i < nums.length; i++) {
			help[nums[i]] = 1;
		}

		dp[0]=0;
		for (int i = 1; i < k; i++) {
			if (help[i] != 0) {
				dp[i] = 1;
			} else {
				dp[i] = dp[i - 1];
			}
		}

		for (int i = k; i < dp.length; i++) {
			if (dp[i] == 0) {
				dp[i] = dp[i - 1];
			} else {
				dp[i] = dp[i - k] + 1;
			}
		}

		return dp[nums.length - 1];
	}
}
