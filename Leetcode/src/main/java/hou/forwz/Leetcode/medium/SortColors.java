package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月14日上午12:14:27
 */

public class SortColors {

	public void sortColors(int[] nums) {
		int begin = 0, end = nums.length - 1;

		for (int i = 0; i < nums.length; i++) {
			if (begin < end) {
				if (nums[i] == 0 && i > begin)
					swap(nums, begin++, i--);
				if (nums[i] == 2 && i < end)
					swap(nums, end--, i--);
			}
		}

	}

	private void swap(int[] nums, int begin, int end) {
		int tmp = nums[begin];
		nums[begin] = nums[end];
		nums[end] = tmp;
	}

}
