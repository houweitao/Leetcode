package hou.forwz.Leetcode.medium;

import java.util.Arrays;

/**
 * @author houweitao
 * @date 2016年8月5日下午8:23:41
 * @end 2016年08月05日21:27:02
 */

public class PermutationSequence3 {
	public static void main(String[] args) {
		PermutationSequence3 ps = new PermutationSequence3();
		System.out.println(ps.getPermutation(4, 5));

	}

	public String getPermutation(int n, int k) {
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1;

		return help(nums, 0, k);
	}

	private String help(int[] nums, int begin, int k) {
		// System.out.println("begin:" + begin + ", k:" + k);

		Arrays.sort(nums, begin, nums.length);
		if (k < 1)
			return "bad";
		else if (k == 1) {
			// for (int i = begin; i < nums.length; i++) {
			// System.out.print(nums[i] + ",");
			// }
			// System.out.println();

			String ret = "";
			for (int i = begin; i < nums.length; i++) {
				ret = ret + nums[i];
			}
			return ret;
		}

		// else if (k < 0) {
		// return nums[begin] + help(nums, begin + 1, 0);
		// }

		if (begin == nums.length - 1)
			return nums[begin] + "";

		int len = nums.length - begin;
		// int all = count(len);
		int single = count(len - 1);

		int pos = k / single;
		// System.out.println("k: " + k);
		// System.out.println("single: " + single);
		// System.out.println("pos: " + pos);
		// System.out.println("========");

		if (k % single == 1) {
			swap(nums, begin, begin + pos);
			return nums[begin] + help(nums, begin + 1, 1);
		}

		if (k % single == 0)
			pos--;

		swap(nums, begin, begin + pos);

		String ret = nums[begin] + help(nums, begin + 1, k - single * (pos));
		return ret;
	}

	private void swap(int[] nums, int begin, int pos) {
		int swap = nums[begin];
		nums[begin] = nums[pos];
		nums[pos] = swap;
	}

	private int count(int n) {
		int ret = 1;
		for (int i = 1; i <= n; i++) {
			ret = ret * i;
		}
		return ret;
	}

}
