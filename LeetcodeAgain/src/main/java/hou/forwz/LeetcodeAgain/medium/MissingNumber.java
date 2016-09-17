package hou.forwz.LeetcodeAgain.medium;

/**
 * @author houweitao
 * @date 2016年9月17日下午4:53:34
 */

public class MissingNumber {

	public int missingNumber(int[] nums) {
		for (int i = 0; i < nums.length;) {
			int cur = nums[i];

			if (cur >= 0 && cur < nums.length && nums[cur + 1] != cur) {
				swap(nums, i, cur + 1);
			} else {
				i++;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i)
				return i;
		}
		return nums.length;
	}

	private void swap(int[] nums, int l, int r) {
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}

}
