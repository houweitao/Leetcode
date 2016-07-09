package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月9日下午11:15:40
 */

public class SearchInsertPosition {
	public static void main(String[] args) {
		SearchInsertPosition si = new SearchInsertPosition();
		int[] nums = { 1, 3, 5, 5, 6 };
		System.out.println(si.searchInsert(nums, 6));
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
