package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月14日下午10:16:05
 */

public class FindMinimumInRotatedSortedArray {

	public int findMin(int[] nums) {
		if (nums[0] < nums[nums.length - 1])
			return nums[0];
		else
			return help(nums, 0, nums.length - 1);
	}

	private int help(int[] nums, int left, int right) {
		if (left == right)
			return nums[left];
		else {
			while (left < right) {
				if (left + 1 == right)
					return Math.min(nums[left], nums[right]);
				else{
					int mid=(left+right)/2;
					if(nums[mid]>nums[left])
						left=mid;
					else if(nums[mid]<nums[left])
						right=mid;
				}
			}
		}

		return 0;
	}

}
