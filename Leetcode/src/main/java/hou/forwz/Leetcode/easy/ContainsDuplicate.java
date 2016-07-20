package hou.forwz.Leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年7月20日下午11:37:54
 */

public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int i : nums) {
			if (set.contains(i))
				return true;
			else
				set.add(i);
		}
		return false;
	}

}
