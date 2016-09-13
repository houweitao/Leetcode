package hou.forwz.Leetcode.medium;


/**
 * @author houweitao
 * @date 2016年7月22日上午1:04:33
 */

public class HouseRobberII {
	public static void main(String[] args) {
		HouseRobberII hr = new HouseRobberII();
		int[] nums = {1,2,4,2};
		System.out.println(hr.better(nums));
	}

	int another(int[] nums){
		return help(nums,0,nums.length-2);
//				help(nums,1,nums.length-1);
	}

	int help(int[] nums, int begin, int end) {
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

	int better(int[] nums) {
		if (nums.length == 0)
			return 0;
		else if (nums.length == 1)
			return nums[0];
		else if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		else if (nums.length == 3)
			return Math.max(nums[1], Math.max(nums[0], nums[2]));

		int[] first = new int[nums.length];
		first[0] = nums[0];
		first[1] = Math.max(nums[0], nums[1]);
		first[2] = Math.max(nums[1], nums[0] + nums[2]);
		for (int i = 3; i < nums.length; i++) {
			int last = nums[i] + first[i - 2];
			int sec = nums[i - 1] + first[i - 3];
			first[i] = Math.max(last, sec);
		}

		int[] second = new int[nums.length];

		second[0] = 0;
		second[1] = nums[1];
		second[2] = Math.max(nums[2], nums[1]);
		second[3] = Math.max(nums[2], nums[1] + nums[3]);
		for (int i = 4; i < nums.length; i++) {
			int last = nums[i] + second[i - 2];
			int sec = nums[i - 1] + second[i - 3];
			second[i] = Math.max(last, sec);
		}

		return Math.max(first[first.length - 2], second[nums.length - 1]);

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

		int last = map[1][nums.length - 3] + nums[nums.length - 1];
		int se = map[0][nums.length - 4] + nums[nums.length - 2];

		return Math.max(last, se);
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
