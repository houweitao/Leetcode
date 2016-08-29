package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年8月30日上午12:00:43
 */

public class JumpGameII {
	public static void main(String[] args) {
		JumpGameII jg = new JumpGameII();
		int[] nums = { 2, 3, 1, 1, 4, 2, 3, 1, 0, 6, 2 };
		System.out.println(jg.jump(nums));
	}

	public int jump(int[] nums) {
		if (nums.length == 1)
			return 1;
		else {
			int edge = nums[0];
			int step = 1;
			int last = 0;
			int maybe = 0;
			while (edge < nums.length - 1) {
				System.out.println(edge);
				for (int i = last; i < nums.length; i++) {
					if (i <= edge) {
						maybe = Math.max(maybe, i + nums[i]);
					} else {
						edge = maybe;
						step++;
						last = i;
						break;
					}
				}
			}
			return step;
		}
	}

}
