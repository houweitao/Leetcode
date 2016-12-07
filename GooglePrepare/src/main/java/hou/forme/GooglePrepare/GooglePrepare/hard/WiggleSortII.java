package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.Arrays;

/**
 * @author houweitao
 * @date 2016年12月7日下午12:24:32
 */

public class WiggleSortII {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);

		int[] help = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			help[i] = nums[i];

		int ou = 0, ji = (nums.length - 1) % 2 == 0 ? nums.length - 2 : nums.length - 1;
		for (int i = (help.length + 1) / 2 - 1; i >= 0; i--) {
			nums[ou] = help[i];
			ou += 2;
		}

		for (int i = (help.length + 1) / 2; i < help.length; i++) {
			nums[ji] = help[i];
			ji -= 2;
		}
	}
}
