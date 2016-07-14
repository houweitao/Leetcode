package hou.forwz.Leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年7月14日下午11:08:34
 */

public class IntersectionOfTwoArraysII {

	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> ret = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int n : nums1) {
			if (map.containsKey(n))
				map.put(n, map.get(n) + 1);
			else
				map.put(n, 1);
		}

		for (int num : nums2) {
			if (map.containsKey(num)) {
				ret.add(num);
				int cur = map.get(num);
				if (cur > 1)
					map.put(num, cur - 1);
				else
					map.remove(num);
			}
		}

		int[] nums = new int[ret.size()];
		for (int i = 0; i < nums.length; i++)
			nums[i] = ret.get(i);

		return nums;
	}

}
