package hou.forme.GooglePrepare.GooglePrepare.hard;

/**
 * @author houweitao
 * @date 2016年12月16日下午8:29:28
 * @url https://discuss.leetcode.com/topic/35494/solution-explanation
 */

public class PatchingArray {
	int minPatches(int[] nums, int n) {
		long miss = 1;
		int added = 0;
		int i = 0;
		while (miss <= n) {
			if (i < nums.length && nums[i] <= miss) {
				miss += nums[i++];
			} else {
				miss += miss;
				added++;
			}
		}
		return added;
	}
}
