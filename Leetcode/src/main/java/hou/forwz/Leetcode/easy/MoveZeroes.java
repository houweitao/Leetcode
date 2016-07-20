package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月20日下午11:32:33
 */

public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		if (nums.length < 1)
			return;

		int pos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[pos++] = nums[i];
		}

		for (int i = pos; i < nums.length; i++)
			nums[i] = 0;
	}

}
