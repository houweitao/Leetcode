package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月21日上午12:49:53
 */

public class FindPeakElement {

	public int findPeakElement(int[] nums) {

		if (nums.length < 2)
			return nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (nums[i] > nums[1])
					return 0;
			} else if (i == nums.length - 1) {
				if (nums[nums.length - 1] > nums[nums.length - 2])
					return nums.length - 1;
			} else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
				return i;
		}
		return -1;

	}

}
