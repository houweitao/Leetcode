package hou.forme.GooglePrepare.GooglePrepare.medium;

/**
 * @author houweitao
 * @date 2016年12月5日下午4:06:54
 * @end 2016年12月05日16:13:57
 */

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2)
			return;

		int changeIndex = findFirst(nums);
		if (changeIndex == -1)
			reverse(nums, 0, nums.length - 1);
		else {
			for (int i = nums.length - 1; i > changeIndex; i--) {
				if (nums[i] > nums[changeIndex]) {
					swap(nums, changeIndex, i);
					reverse(nums, changeIndex + 1, nums.length - 1);
					break;
				}
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private void reverse(int[] nums, int i, int j) {
		while (i <= j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
	}

	private int findFirst(int[] nums) {
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1])
				return i;
		}
		return -1;
	}
}
