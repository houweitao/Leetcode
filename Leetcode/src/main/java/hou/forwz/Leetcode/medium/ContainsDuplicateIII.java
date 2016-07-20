package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author houweitao
 * @date 2016年7月20日下午11:49:23
 */

public class ContainsDuplicateIII {

	public static void main(String[] args) {
		ContainsDuplicateIII cd = new ContainsDuplicateIII();
		int[] nums = { -1, -1, -1, -1 };
		System.out.println(cd.containsNearbyAlmostDuplicateMe(nums, 1, 0));
	}

	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = remappedNum / ((long) t + 1);
			if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
				return true;
			if (map.entrySet().size() >= k) {
				long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(lastBucket);
			}
			map.put(bucket, remappedNum);
		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}

		final TreeSet<Integer> values = new TreeSet<>();
		for (int ind = 0; ind < nums.length; ind++) {

			final Integer floor = values.floor(nums[ind] + t);
			final Integer ceil = values.ceiling(nums[ind] - t);
			if ((floor != null && floor >= nums[ind]) || (ceil != null && ceil <= nums[ind])) {
				return true;
			}

			values.add(nums[ind]);
			if (ind >= k) {
				values.remove(nums[ind - k - 1]);
			}
		}

		return false;
	}

	public boolean containsNearbyAlmostDuplicateMe(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}

		final TreeMap<Integer, Integer> values = new TreeMap<>();
		for (int ind = 0; ind < nums.length; ind++) {

			Map.Entry<Integer, Integer> last = values.lastEntry();
			Map.Entry<Integer, Integer> first = values.firstEntry();

			if (!values.isEmpty()) {
				System.out.println(first.getValue() + "," + last.getValue());

				if (first.getValue() > nums[ind] + Math.abs(t) || last.getValue() - Math.abs(t) < nums[ind]) {
					return true;
				}
			}
			if (values.containsKey(nums[ind]))
				return true;
			values.put(nums[ind], ind);
			if (ind >= k) {
				values.remove(nums[ind - k]);
			}
		}

		return false;
	}

}
