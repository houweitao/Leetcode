package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月9日下午11:35:01
 */

public class SearchForARange2 {
	public int[] searchRange(int[] nums, int target) {
		int[] ret = new int[2];
		ret[0] = searchInsert(nums, target);
		if (ret[0] == nums.length)
			return new int[] { -1, -1 };
		else if (nums[ret[0]] == target) {
			ret[1] = searchInsert(nums, target + 1) - 1;
			return ret;
		} else
			return new int[] { -1, -1 };
	}

	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0)
			return 0;
		else if (nums.length == 1) {
			if (nums[0] >= target)
				return 0;
			else
				return 1;
		} else
			return help(nums, target, 0, nums.length - 1);
	}

	private int help(int[] nums, int target, int begin, int end) {

		while (begin < end) {
			if (begin + 1 == end) {
				if (nums[begin] >= target)
					return begin - 1 >= 0 ? begin - 1 : 0;
				else if (nums[begin] < target) {
					if (nums[end] < target)
						return end + 1;
					else
						return end;
				}
			} else {
				int mid = (begin + end) / 2;
				if (nums[mid] >= target) {
					end = mid;
				} else {
					begin = mid;
				}
			}

		}

		return -1;
	}
}
