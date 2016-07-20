package hou.forwz.Leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年7月20日下午11:44:30
 */

public class ContainsDuplicateII {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (set.add(nums[i])) {
				if (i >= k)
					set.remove(nums[i - k]);
			} else
				return true;
		}

		return false;
	}

}
