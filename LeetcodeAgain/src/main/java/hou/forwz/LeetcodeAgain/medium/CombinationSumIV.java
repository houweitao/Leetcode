package hou.forwz.LeetcodeAgain.medium;

import java.util.Arrays;

/**
 * @author houweitao
 * @date 2016年10月7日下午7:30:35
 */

public class CombinationSumIV {
	public static void main(String[] args) {
		CombinationSumIV cs = new CombinationSumIV();
		int[] nums = { 1, 2, 3 };
		System.out.println(cs.combinationSum4(nums, 4));
	}

	public int combinationSum4(int[] nums, int target) {
		if (nums.length == 0 || target < 0)
			return 0;

		Arrays.sort(nums);
		int[] dp = new int[target + 1];

		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i == nums[j]) {
					dp[i]++;
				} else if (i < nums[j])
					break;
				else {
					if (dp[i - nums[j]] != 0)
						dp[i] += dp[i - nums[j]];
				}
			}
		}

		return dp[target];
	}

}
