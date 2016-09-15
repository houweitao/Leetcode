package hou.forwz.LeetcodeAgain.medium;

import java.util.Arrays;

/**
 * @author houweitao
 * @date 2016年9月15日下午5:52:28
 */

public class PermutationSequence {
	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();

		for (int i = 1; i <= 6; i++)
			System.out.println(ps.getPermutation(3, i));

		// System.out.println(ps.getNum(3));
	}

	public String getPermutation(int n, int k) {
		if(k<1||k>getNum(n+1))
			return null;
		
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}

		return help(nums, k - 1);
	}

	private String help(int[] nums, int k) {
		if (nums.length == 1)
			return nums[0] + "";

		Arrays.sort(nums);
		if (k == 0) {
			StringBuffer sb = new StringBuffer();
			for (int i : nums) {
				sb.append(i);
			}
			return sb.toString();
		}

		int fenge = getNum(nums.length);

		int pos = (k) / fenge;
		int next = (k) % fenge;

		swap(nums, 0, pos);

		int[] nextNums = new int[nums.length - 1];
		for (int i = 1; i < nums.length; i++) {
			nextNums[i - 1] = nums[i];
		}

		return nums[0] + help(nextNums, next);
	}

	private void swap(int[] nums, int i, int pos) {
		int tmp = nums[i];
		nums[i] = nums[pos];
		nums[pos] = tmp;
	}

	int getNum(int n) {
		int ret = 1;
		for (int i = 1; i < n; i++) {
			ret *= i;
		}
		return ret;
	}

}
