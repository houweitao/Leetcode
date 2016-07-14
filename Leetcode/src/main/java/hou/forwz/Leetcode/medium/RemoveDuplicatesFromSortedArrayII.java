package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月14日下午9:51:42
 */

public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] nums) {

		if(nums.length<3)
			return nums.length;
		
		int mark = 2;
		int low = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				mark--;
				if (mark == 1)
					nums[low++] = nums[i];
				// else

			} else {
				mark = 2;
				nums[low++] = nums[i];
			}

		}
		return low;
	}

}
