package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月8日下午9:33:13
 */

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		if (nums.length < 2)
			return nums.length;

		int count = 1;
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				j++;
				count++;
			} else {
				nums[j] = nums[i];
			}
		}
		return count;
	}

}
