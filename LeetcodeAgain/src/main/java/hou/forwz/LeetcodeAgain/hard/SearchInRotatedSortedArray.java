package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年9月18日上午12:46:26
 */

public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		SearchInRotatedSortedArray sr = new SearchInRotatedSortedArray();
		int[] nums = { 1 };
		System.out.println(sr.index(nums));
		System.out.println(sr.search(nums, 1));
	}

	public int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		int index = index(nums);
		if (index == -1) {
			return binSearch(nums, 0, nums.length - 1, target);
		} else {
			int left = binSearch(nums, 0, index - 1, target);
			int right = binSearch(nums, index, nums.length - 1, target);
			if (left >= 0)
				return left;
			if (right >= 0)
				return right;
			return -1;
		}
	}

	int binSearch(int[] nums, int begin, int end, int target) {
		if (begin > end)
			return -1;
		else {
			while (begin <= end && begin >= 0 && end < nums.length) {
				if (begin == end) {
					return nums[begin] == target ? begin : -1;
				}

				int mid = begin + (end - begin) / 2;
				if (nums[mid] > target) {
					end = mid - 1;
				} else if (nums[mid] < target) {
					begin = mid + 1;
				} else
					return mid;
			}

			return -1;
		}
	}

	int index(int[] nums) {
		if (nums.length < 2)
			return -1;
		else
			return index(nums, 0, nums.length - 1);
	}

	int index(int[] nums, int begin, int end) {
		if (nums[begin] < nums[end])
			return begin - 1;
		else {
			while (begin < end) {
				if (begin + 1 == end) {
					if (nums[begin] > nums[end]) {
						return end;
					}
				}

				int mid = begin + (end - begin) / 2;
				if (nums[mid] < nums[begin]) {
					return index(nums, begin, mid);
				} else {
					return index(nums, mid, end);
				}
			}

			return -1;
		}
	}

}
