package hou.forwz.Leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年7月14日下午10:34:35
 */

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] nums = { -7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7 };
		LongestConsecutiveSequence lc = new LongestConsecutiveSequence();
		System.out.println(lc.longestConsecutive(nums));
	}

	public int longestConsecutive(int[] nums) {
		if (nums.length == 1)
			return 1;

		Map<Integer, Integer> map = new HashMap<>();

		int max = 1;
		for (int n : nums) {
			if (!map.containsKey(n)) {
				int sum = 1;
				if (map.containsKey(n - 1))
					sum = sum + map.get(n - 1);
				if (map.containsKey(n + 1))
					sum = sum + map.get(n + 1);

				map.put(n, sum);
				max = Math.max(max, sum);

				if (map.containsKey(n - 1))
					map.put(n - map.get(n - 1), sum);
				if (map.containsKey(n + 1))
					map.put(n + map.get(n + 1), sum);
			}

			System.out.println(map.size());
		}

		Arrays.sort(nums);
		for (int n : nums)
			System.out.print(n + ",");
		System.out.println();

		return max;

	}

}
