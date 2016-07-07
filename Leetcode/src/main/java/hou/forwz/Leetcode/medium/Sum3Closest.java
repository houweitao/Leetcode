package hou.forwz.Leetcode.medium;

import java.util.Arrays;

/**
 * @author houweitao
 * @date 2016年7月7日下午9:59:12
 */

public class Sum3Closest {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		if (nums.length < 3)
			return -1;

		int maybe = nums[0] + nums[1] + nums[2];

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1, right = nums.length - 1;

			while (left < right) {
				int cur = nums[i] + nums[left] + nums[right];
				if (cur == target)
					return cur;
				if (Math.abs(cur - target) < Math.abs(maybe - target))
					maybe = cur;

				else if (cur > target)
					--right;
				else
					++left;
			}
		}
		return maybe;

	}

}
