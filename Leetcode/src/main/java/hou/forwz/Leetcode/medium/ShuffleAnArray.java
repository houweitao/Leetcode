package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月12日下午10:41:13
 */

public class ShuffleAnArray {
	public class Solution {
		List<Integer> list;
		int[] bak;

		public Solution(int[] nums) {
			bak = nums;
			list = new ArrayList<>(nums.length);
			for (int i : nums)
				list.add(i);
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			return bak;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			int[] ret = new int[list.size()];
			List<Integer> tmp = new ArrayList<>(ret.length);
			for (int i = 0; i < ret.length; i++) {
				int pos = (int) (Math.random() * list.size());
				ret[i] = list.get(pos);
				list.remove(pos);
				tmp.add(ret[i]);
			}
			list = tmp;
			return ret;
		}
	}

	/**
	 * Your Solution object will be instantiated and called as such: Solution
	 * obj = new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
	 * obj.shuffle();
	 */
}
