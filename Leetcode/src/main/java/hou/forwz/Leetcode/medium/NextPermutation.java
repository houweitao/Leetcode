package hou.forwz.Leetcode.medium;

import java.util.Arrays;

/**
 * @author houweitao
 * @date 2016年7月8日下午10:24:01
 */

public class NextPermutation {
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] nums = { 1, 3, 2, 6, 5, 2, 1 };
		np.nextPermutation(nums);
		np.print(nums);
	}

	private void print(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + "->");
	}

	public void nextPermutation(int[] nums) {
		int pos = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1])
				break;
			else
				pos--;
		}

		System.out.println("pos: " + pos);

		if (pos == 0) {
			reverse(nums, 0, nums.length - 1);
		} else {
			int change = pos;
			for (int i = nums.length - 1; i > pos; i--) {
				if (nums[i] > nums[pos - 1]) {
					change = i;
					break;
				}
			}

			exchange(nums, pos - 1, change);
			reverse(nums, pos, nums.length - 1);

		}
	}

	private void exchange(int[] nums, int pos, int i) {
		System.out.println(pos + " . " + i);
		int tmp = nums[i];
		nums[i] = nums[pos];
		nums[pos] = tmp;
	}

	private void reverse(int[] nums, int left, int right) {

		while (left < right) {
			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;

			left++;
			right--;
		}
	}
}
