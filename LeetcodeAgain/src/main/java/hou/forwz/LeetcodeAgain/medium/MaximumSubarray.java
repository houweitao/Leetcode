package hou.forwz.LeetcodeAgain.medium;

/**
 * @author houweitao
 * @date 2016年9月14日上午10:27:30
 */

public class MaximumSubarray {
	// https://discuss.leetcode.com/topic/5000/accepted-o-n-solution-in-java
	public int maxSubArrayNB(int[] A) {
		int maxSoFar = A[0], maxEndingHere = A[0];
		for (int i = 1; i < A.length; ++i) {
			maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

	public int maxSubArray(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int max = nums[0];
		int maxSofar = nums[0];

		for (int i = 1; i < nums.length; i++) {
			maxSofar = Math.max(0, maxSofar + nums[i]);
			max = Math.max(maxSofar, max);
		}

		int a = Integer.MIN_VALUE;
		for (int i : nums) {
			a = Math.max(a, i);
		}

		if (a < 0)
			return a;
		else
			return max;
	}

}
