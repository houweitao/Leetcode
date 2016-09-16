package hou.forwz.LeetcodeAgain.medium;

/**
 * @author houweitao
 * @date 2016年9月16日下午2:58:13
 */

public class MaximumProductSubarray {

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = nums[0], min = nums[0], result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int tmp = max;
			max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
			min = Math.min(nums[i], Math.max(tmp * nums[i], min * nums[i]));

			result = Math.max(result, max);
		}
		return result;
	}
}
