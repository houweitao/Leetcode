package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月8日下午9:41:46
 */

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int low = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val)
				nums[low++] = nums[i];
		}

		return low + 1;
	}

}
