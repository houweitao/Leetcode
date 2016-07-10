package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月11日上午2:13:11
 */

public class MinimumSizeSubarraySum {
	public static void main(String[] args) {
		MinimumSizeSubarraySum ms = new MinimumSizeSubarraySum();
		int[] nums = { 1, 4, 4 };
		System.out.println(ms.minSubArrayLen(4, nums));
	}

	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0)
			return 0;

		int begin = 0, end = 0;
		int sum = nums[0];
		int min = Integer.MAX_VALUE;

		while (begin <= end && end < nums.length) {

			if (sum < s) {
				if (end < nums.length - 1) {
					end++;
					sum = sum + nums[end];
					if (sum >= s)
						min = Math.min(end - begin + 1, min);
				} else {
					return min;
				}
			} else {
				if (begin < end) {
					sum = sum - nums[begin];
					begin++;
					if (sum >= s)
						min = Math.min(end - begin + 1, min);
				} else
					return 1;
			}
		}
		if (min == Integer.MAX_VALUE)
			return 0;
		else
			return min;

	}

}
