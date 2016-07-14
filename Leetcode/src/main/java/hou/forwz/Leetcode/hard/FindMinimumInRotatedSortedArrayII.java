package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月14日下午10:04:23
 */

public class FindMinimumInRotatedSortedArrayII {

	public int findMin(int[] nums) {
		if (nums.length == 0)
			return -1;
		return min(nums, 0, nums.length - 1);
	}

	private int min(int[] nums, int begin, int end) {
		if (begin == end)
			return nums[begin];
		else if (begin + 1 == end)
			return Math.min(nums[begin], nums[end]);
		else if (nums[begin] < nums[end]) {
			return nums[begin];
		} else {
			int mid = (begin + end) / 2;
			if (nums[mid] < nums[end]) {
				return min(nums, begin, mid);
			} else
				return Math.min(min(nums, mid, end), min(nums, begin, mid));
		}
	}

}
