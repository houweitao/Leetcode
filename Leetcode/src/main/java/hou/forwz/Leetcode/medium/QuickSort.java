package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月28日上午1:00:23
 */

public class QuickSort {
	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6 };
		QuickSort qs = new QuickSort();
		qs.quickSort(nums);
		for (int i : nums)
			System.out.println(i);
	}

	void quickSort(int[] nums) {
		int pos = help(nums, 0, nums.length - 1);
		System.out.println("pos: "+pos);

	}

	private int help(int[] nums, int begin, int end) {
		if (begin == end)
			return begin;
		else if (begin < end) {
			int stand = nums[begin];
			int left = begin, right = end;
			while (left < right) {
				while (left < right && nums[right] >= stand)
					right--;
				nums[left] = nums[right];

				while (left < right && nums[left] < stand)
					left++;
				nums[right] = nums[left];
			}
			nums[left] = stand;

			help(nums, begin, left - 1);
			help(nums, left + 1, end);
			return left;
		}
		return -1;
	}
}
