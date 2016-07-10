package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月11日上午2:06:40
 */

public class JumpGame {

	public boolean canJump(int[] nums) {
		int max = 0;

		for (int i = 0; i <= max; i++) {
			max = Math.max(max, nums[i] + i);
			if (max >= nums.length - 1)
				return true;

		}
		return false;
	}

}
