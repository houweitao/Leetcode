package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年12月5日下午6:50:55
 * @end 2016年12月05日19:05:59
 * @tips 要细心
 */

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.println(lcs.longestConsecutive(nums));
	}

	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> num = new HashMap<>();
		int max = 1;
		for (int n : nums) {
			int sum = 1;
			if (num.containsKey(n))
				continue;

			int left = 0, right = 0;
			if (num.containsKey(n - 1)) {
				left = num.get(n - 1);
			}

			if (num.containsKey(n + 1)) {
				right = num.get(n + 1);
			}

			sum += left + right;
			num.put(n - left, sum);
			num.put(n + right, sum);
			num.put(n, sum);

			max = Math.max(max, sum);
		}
		return max;
	}

}
