package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月11日上午1:14:10
 */

public class MaximumSubarray {

	public int maxSubArray(int[] nums) {

		int max = 0;
		int curmax = 0;
		int sum = 0;
		int maxSingle = Integer.MIN_VALUE;

		for (int n : nums) {
			sum = sum + n;
			maxSingle = Math.max(maxSingle, n);
			if (sum < 0) {
				sum = 0;
				max = Math.max(max, curmax);
			} else {
				curmax = Math.max(curmax, sum);
			}
		}
		max = Math.max(max, curmax);

		if (maxSingle < 0)
			return maxSingle;

		return max;

	}

}
