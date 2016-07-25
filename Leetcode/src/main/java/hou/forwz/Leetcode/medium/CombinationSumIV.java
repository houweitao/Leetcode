package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月26日上午1:02:24
 */

public class CombinationSumIV {
	// 如果是含负数，只需要整体加最小的负数的绝对值即可？貌似 make sense

	public int combinationSum4(int[] nums, int target) {
		int[] many = new int[target + 1];

		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i == nums[j])
					many[i]++;

				else if (i > nums[j] && many[i - nums[j]] != 0) {
					many[i] = many[i] + many[i - nums[j]];
				}

			}

		}

		return many[target];
	}

}
