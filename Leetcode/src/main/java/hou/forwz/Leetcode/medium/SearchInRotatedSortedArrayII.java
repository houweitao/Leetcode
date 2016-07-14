package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月14日下午11:18:00
 */

public class SearchInRotatedSortedArrayII {

	public static void main(String[] args) {
		SearchInRotatedSortedArrayII si = new SearchInRotatedSortedArrayII();
		int[] nums = { 1, 1, 3 };
		System.out.println(si.search(nums, 3));
	}

	public boolean search(int[] nums, int target) {
		return help(nums, 0, nums.length - 1, target);
	}

	private boolean help(int[] nums, int begin, int end, int tar) {
		System.out.println(begin + "," + end);
		if (begin > end)
			return false;
		else if (begin == end)
			return nums[begin] == tar;
		else if (begin + 1 == end) {
			if (nums[begin] == tar)
				return true;
			if (nums[end] == tar)
				return true;
			return false;
			// return nums[begin] == tar || nums[end] == tar;
		} else {
			int mid = (begin + end) / 2;
			int cur = nums[mid];
			if (cur > tar) {
				return help(nums, mid + 1, end, tar) || help(nums, begin, mid - 1, tar);
			} else if (cur < tar) {
				if (cur < nums[begin]) {
					return help(nums, begin, mid - 1, tar);
				} else
					return help(nums, mid + 1, end, tar) || help(nums, begin, mid - 1, tar);
			} else
				return true;
		}
	}

}
