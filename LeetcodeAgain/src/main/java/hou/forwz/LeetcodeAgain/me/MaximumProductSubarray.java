package hou.forwz.LeetcodeAgain.me;

/**
 * @author houweitao
 * @date 2016年11月29日上午12:51:42
 */

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int max = nums[0];
		int min = nums[0];

		int ret = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int n = nums[i];
			int maybe1 = max * n;
			int maybe2 = min * n;

			max = Math.max(n, Math.max(maybe1, maybe2));
			min = Math.min(n, Math.min(maybe1, maybe2));

			ret = Math.max(ret, max);
		}

		return ret;
	}

	public int maxAdd(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int max = nums[0];
		int maxSofar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxSofar = Math.max(nums[i], maxSofar + nums[i]);
			max = Math.max(max, maxSofar);
		}

		return max;
	}
}
