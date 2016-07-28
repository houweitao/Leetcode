package hou.forwz.Leetcode.medium;

import java.util.Arrays;

/**
 * @author houweitao
 * @date 2016年7月28日上午1:09:22
 */

public class WiggleSortII2 {

	public void wiggleSort(int[] nums) {
		if (nums.length < 1)
			return;
		Arrays.sort(nums);
		int mid = nums[nums.length / 2];

		int n = nums.length;
		int i = 0, j = 0, k = n - 1;
		while (j <= k) {
			if (nums[j] > mid)
				swap(nums, i++, j++);
			else if (nums[j] < mid)
				swap(nums, j, k--);
			else
				j++;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;

	}

}
