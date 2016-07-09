package hou.forwz.Leetcode.hard;


/**
 * @author houweitao
 * @date 2016年7月9日下午10:22:23
 */

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		SearchInRotatedSortedArray sr = new SearchInRotatedSortedArray();
		int[] nums = { 1, 3, 5 };
		System.out.println(sr.findPoint(nums, 0, 2));
		System.out.println(sr.search(nums, 1));
	}

	public int search(int[] nums, int target) {
		if (nums.length < 1)
			return -1;
		else if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		} else if (nums.length == 2) {
			if (nums[0] == target)
				return 0;
			else if (nums[1] == target)
				return 1;
			else
				return -1;
		} else {
			int index = findPoint(nums, 0, nums.length - 1);

			if (index == -1)
				return exist(nums, target, 0, nums.length - 1);
			else {
				return Math.max(exist(nums, target, 0, index), exist(nums, target, index + 1, nums.length - 1));
			}
		}
	}

	private int exist(int[] nums, int target, int begin, int end) {
		if (begin == end)
			return nums[begin] == target ? begin : -1;
		else {
			while (begin <= end) {
				if (begin == end)
					return nums[begin] == target ? begin : -1;
				else if (begin + 1 == end) {
					if (nums[begin] == target)
						return begin;
					else if (nums[end] == target)
						return end;
					else
						return -1;
				} else {
					int mid = (begin + end) / 2;
					if (nums[mid] == target)
						return mid;
					else if (nums[mid] > target) {
						end = mid - 1;
					} else
						begin = mid + 1;
				}
			}
			return -1;
		}
	}

	private int findPoint(int[] nums, int begin, int end) {
		int len = nums.length;
		if (begin == end)
			return -1;
		else if (begin + 1 == end) {
			if (nums[begin] > nums[end])
				return begin;
			else
				return -1;
		} else if (nums[0] <= nums[len - 1])
			return -1;
		else {
			int left = begin, right = end;
			while (left < right) {
				int mid = (left + right) / 2;
				if (left + 1 == right) {
					if (nums[left] > nums[right])
						return left;
					else
						return -1;
				} else {
					if (nums[mid] < nums[mid - 1])
						return mid - 1;
					else if (nums[mid] > nums[mid + 1])
						return mid;
					else {
					}
					int one = findPoint(nums, begin, mid - 1);
					int two = findPoint(nums, mid + 1, end);

					return Math.max(one, two);
				}

			}
		}

		return 0;
	}

}
