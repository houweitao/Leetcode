package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年8月5日下午11:43:58
 * @end 2016年08月06日00:11:21
 * @url 这个很赞：
 *      https://discuss.leetcode.com/topic/3607/sharing-my-solution-o-1-space-o-
 *      n-running-time
 */

public class MaximumProductSubarray2 {
	public static void main(String[] args) {
		MaximumProductSubarray2 mp = new MaximumProductSubarray2();
		int[] nums = { 2, -5, -2, -4, 3 };
		System.out.println(mp.maxProduct(nums));
	}

	public int maxProduct(int[] nums) {
		// int max = Integer.MIN_VALUE;
		// int min = Integer.MAX_VALUE;
		// int curMax=-1,curMin=1;
		int ret = Integer.MIN_VALUE;
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];
		ret = nums[0];

		if (nums[0] > 0) {
			max[0] = nums[0];
		} else if (nums[0] < 0) {
			min[0] = nums[0];
		} else {
			ret = 0;
		}

		for (int i = 1; i < nums.length; i++) {
			int cur = nums[i];
			ret = Math.max(ret, cur);

			if (cur > 0) {
				max[i] = max[i - 1] <= 0 ? cur : max[i - 1] * cur;
				min[i] = min[i - 1] >= 0 ? cur : min[i - 1] * cur;
			} else if (cur < 0) {
				min[i] = max[i - 1] <= 0 ? cur : max[i - 1] * cur;
				max[i] = min[i - 1] >= 0 ? cur : min[i - 1] * cur;
			} else {
				max[i] = 0;
				min[i] = 0;
			}

			ret = Math.max(max[i], ret);
		}

		print(nums);
		print(max);
		print(min);

		return ret;
	}

	private void print(int[] max) {
		for (int i : max)
			System.out.print(i + ",");
		System.out.println();
	}

}
