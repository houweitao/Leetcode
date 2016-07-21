package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月22日上午12:24:06
 */

public class HouseRobber {
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		int[] nums = { 3, 1, 2, 4, 6, 3 };
		System.out.println(hr.rob(nums));
	}

	int better(int[] nums) {
		int[] help = new int[nums.length];
		help[0] = nums[0];
		if (nums.length == 1)
			return nums[0];
		help[1] = Math.max(nums[0], nums[1]);
		if (nums.length == 2)
			return help[1];

		help[2] = Math.max(nums[1], nums[0] + nums[2]);
		if (nums.length == 3)
			return help[2];

		for (int i = 3; i < nums.length; i++) {
			int last = nums[i] + help[i - 2];
			int sec = nums[i - 1] + help[i - 3];
			help[i] = Math.max(last, sec);
		}

		return help[help.length - 1];
	}

	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		else if (nums.length == 1)
			return nums[0];

		int[][] map = new int[nums.length][nums.length];

		for (int i = 0; i <= nums.length - 1; i++)
			map[i][i] = nums[i];

		for (int i = 0; i < nums.length - 1; i++)
			map[i][i + 1] = Math.max(nums[i], nums[i]);
		for (int i = 0; i < nums.length - 2; i++) {
			int one = nums[i] + nums[i + 2];
			int two = nums[i + 1];

			map[i][i + 2] = Math.max(one, two);
		}

		for (int i = nums.length - 4; i >= 0; i--) {
			for (int j = 3; j + i <= nums.length - 1; j++) {
				int robFir = nums[i + j] + map[i][i + j - 2];
				int robSec = nums[i + j - 1] + map[i][i + j - 3];

				System.out.println(robFir + "," + robSec);

				map[i][j] = Math.max(robFir, robSec);
			}

		}

		print(map);

		return map[0][nums.length - 1];
	}

	private void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

}
