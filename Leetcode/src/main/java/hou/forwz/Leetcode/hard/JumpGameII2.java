package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年9月13日下午12:55:15
 */

public class JumpGameII2 {
	public static void main(String[] args) {
		JumpGameII2 jg = new JumpGameII2();
		int[] nums = { 5, 9, 3, 2, 1, 0, 2, 3, 3 };
		System.out.println(jg.step(nums));
	}

	int step(int[] nums) {
		int count = 1;
		int edge = nums[0];
		int nextMax = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > edge) {
				count++;
				edge = nextMax;
			}

			nextMax = Math.max(nextMax, i + nums[i]);
			System.out.println(i+","+nextMax);
			if (nextMax >= nums.length-1) {
				return count+1;
			}
		}

		return -1;
	}
}
