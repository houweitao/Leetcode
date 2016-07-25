package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月25日下午10:29:52
 */

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		if (nums.length < 2)
			return nums.length;

		int[] dp = new int[nums.length];
		for (int i = 0; i < dp.length; i++)
			dp[i] = 1;

		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				max = Math.max(max, dp[i]);
			}
		}

		return max;
	}

}
