package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月10日上午1:57:18
 */

public class JumpGameII {
	public static void main(String[] args) {
		JumpGameII jg = new JumpGameII();
		int[] nums = { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
		System.out.println(jg.jump(nums));
	}

	public int jump(int[] A) {
		int maxReach = A[0];
		int edge = 0;
		int minstep = 0;

		for (int i = 1; i < A.length; i++) {
			if (i > edge) {
				minstep += 1;
				edge = maxReach;
				if (edge > A.length - 1)
					return minstep;
			}
			maxReach = Math.max(maxReach, A[i] + i);
			if (maxReach < i) {
				System.out.println(maxReach);
				return -1;
			}
		}

		return minstep;
	}

	public int jumpMe(int[] nums) {
		if (nums.length <= 1)
			return 0;
		int[] min = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j <= nums[i]; j++) {
				if (i + j < nums.length)
					if (min[i + j] == 0)
						min[i + j] = min[i] + 1;
					else {
						min[i + j] = Math.min(min[i] + 1, min[i + j]);
					}
			}

		}
		print(min);
		return min[nums.length - 1];
	}

	private void print(int[] nums) {
		for (int n : nums)
			System.out.print(n + ",");
		System.out.println();
	}

}
