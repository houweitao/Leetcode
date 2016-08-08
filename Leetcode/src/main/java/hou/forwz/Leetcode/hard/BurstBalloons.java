package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月8日下午11:10:29
 */

public class BurstBalloons {
	public static void main(String[] args) {
		BurstBalloons bb = new BurstBalloons();
		int[] nums = { 7, 9, 8, 0, 7 };
		System.out.println(bb.maxCoins2(nums));
		System.out.println(bb.maxCoins(nums));
		System.out.println(bb.maxCoins3(nums));
	}

	public int maxCoins3(int[] iNums) {
		int[] nums = new int[iNums.length + 2];
		int n = 1;
		for (int x : iNums)
			if (x > 0)
				nums[n++] = x;
		nums[0] = nums[n++] = 1;

		int[][] dp = new int[n][n];
		for (int k = 2; k < n; ++k)
			for (int left = 0; left < n - k; ++left) {
				int right = left + k;
				for (int i = left + 1; i < right; ++i)
					dp[left][right] = Math.max(dp[left][right],
							nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
			}

		return dp[0][n - 1];
	}

	public int maxCoins2(int[] nums) {
		return dp(nums);
	}

	private int dp(int[] nums) {
		int[][] dp = new int[nums.length][nums.length];

		for (int i = 0; i < dp.length; i++)
			dp[i][i] = nums[i];
		for (int i = 0; i < dp.length - 1; i++) {
			int large = Math.max(nums[i], nums[i + 1]);
			int small = Math.min(nums[i], nums[i + 1]);

			dp[i][i + 1] = large * small + large;
		}

		for (int j = 2; j < dp.length; j++) {
			for (int i = 0; i + j < dp.length; i++) {
				int right = j + i;
				for (int k = i + 1; k < right; k++) {
					int cur = nums[k] * nums[i] * nums[i + j] + dp[i][k] + dp[k][right];
					// System.out.println(cur);
					dp[i][right] = Math.max(dp[i][i + j], cur);
				}
			}
		}

		return dp[0][dp.length - 1];
	}

	private int get(int[] nums, int i) {
		if (i == -1 || i == nums.length)
			return 1;
		else
			return nums[i];
	}

	public int maxCoins(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i : nums)
			list.add(i);
		return help(list);
	}

	private int help(List<Integer> list) {
		if (list.size() == 0)
			return 0;
		else if (list.size() == 1)
			return list.get(0);
		else if (list.size() == 2) {
			int large = Math.max(list.get(0), list.get(1));
			int small = Math.min(list.get(0), list.get(1));

			return large * small + large;
		} else {
			int max = 0;
			for (int i = 0; i < list.size(); i++) {
				int cur = get(list, i) * get(list, i - 1) * get(list, i + 1);
				int tmp = list.remove(i);
				int next = help(list);
				list.add(i, tmp);

				cur = cur + next;
				max = Math.max(max, cur);
			}
			return max;
		}
	}

	private int get(List<Integer> list, int i) {
		if (i == -1 || i == list.size())
			return 1;
		else
			return list.get(i);
	}

	// private int help(int[] nums, int left, int right) {
	// if(left<right)
	// return 0;
	// else if(left==right)
	// return nums[left];
	// else if(left+1==right){
	// int large=Math.max(nums[left], nums[right]);
	// int small=Math.min(nums[left], nums[right]);
	//
	// return small*large+large;
	// }else{
	// int max=Integer.MIN_VALUE;
	// for(int i=left;i<=right;i++){
	//// int cur=help(nums,left,i)+help(nums,)
	// }
	// }
	//
	// return 0;
	// }

}
