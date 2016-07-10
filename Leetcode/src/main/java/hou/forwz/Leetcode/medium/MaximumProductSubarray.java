package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月11日上午1:43:03
 */

public class MaximumProductSubarray {
	// https://discuss.leetcode.com/topic/4417/possibly-simplest-solution-with-o-n-time-complexity
	public int maxProduct(int[] nums) {
		return Math.max(help(nums, 0), max(nums));
	}

	private int max(int[] nums) {
		int ret = Integer.MIN_VALUE;
		for (int n : nums)
			ret = Math.max(ret, n);

		return ret;
	}

	private int help(int[] nums, int pos) {
		if (pos == nums.length)
			return Integer.MIN_VALUE;
		else if (pos == nums.length - 1)
			return nums[pos];
		else {
			int maxSofar = Integer.MAX_VALUE;
			int maxEndHere = Integer.MIN_VALUE;
			int product = 1;

			for (int i = pos; i < nums.length; i++) {
				product = product * nums[i];

				if (product == 0) {
					return Math.max(maxEndHere, nums[pos + 1]);
				} else if (product < 0) {
					maxEndHere = Math.max(maxEndHere, product / nums[i]);

					int next = help(nums, pos + 1);
					for (int j = i + 1; j < nums.length; j++) {
						product = product * nums[j];
						maxEndHere = Math.max(maxEndHere, product);
					}

					maxSofar = Math.max(next, maxEndHere);
					return maxSofar;
				} else {
					maxSofar = Math.max(maxEndHere, product);
				}

			}
			return maxSofar;
		}

	}

}
