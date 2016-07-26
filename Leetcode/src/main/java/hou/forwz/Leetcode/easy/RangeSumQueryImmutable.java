package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月26日下午11:33:07
 */

public class RangeSumQueryImmutable {
	class NumArray {
		int nums[];

		public NumArray(int[] nums) {

			for (int i = 1; i < nums.length; i++)
				nums[i] = nums[i - 1] + nums[i];

			this.nums = nums;
		}

		public int sumRange(int i, int j) {
			if (i == 0)
				return nums[j];
			else
				return nums[j] - nums[i - 1];
		}
	}
}
