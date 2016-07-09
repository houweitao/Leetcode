package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月10日上午12:29:49
 */

public class FirstMissingPositive {
	public static void main(String[] args) {
		FirstMissingPositive fm = new FirstMissingPositive();
		int[] nums = { -1, 4, 2, 1, 9, 10 };
		System.out.println(fm.firstMissingPositiveMe(nums));
		System.out.println(fm.firstMissingPositive(nums));

	}

	public int firstMissingPositiveMe(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {///if
				swap(nums, i, nums[i] - 1);
				i--;
			}
		}

		for (int i = 0; i < nums.length; i++)
			if (nums[i] != i + 1)
				return i + 1;

		return nums.length + 1;

	}

	public int firstMissingPositive(int[] A) {
		int n = A.length;
		for (int i = 0; i < n; i++)
			while (A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i])///while
				swap(A, i, A[i] - 1);

		for (int i = 0; i < n; i++)
			if (A[i] != i + 1)
				return i + 1;

		return n + 1;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
