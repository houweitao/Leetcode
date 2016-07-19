package hou.forwz.Leetcode.medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author houweitao
 * @date 2016年7月19日下午10:50:44
 */

public class KthLargestElementInAnArray {
	public static void main(String[] args) {
		KthLargestElementInAnArray kl = new KthLargestElementInAnArray();
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		System.out.println(kl.findKthLargest(nums, 2));
	}

	public int findKthLargest(int[] nums, int k) {
		Map<Integer, Integer> map = new TreeMap<>();

		for (int n : nums) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else
				map.put(n, 1);
		}

		int all = nums.length;
		// k = all - k + 1;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "," + entry.getValue());
			all = all - entry.getValue();
			if (all < k)
				return entry.getKey();
		}

		return 1;
	}

	public int findKthLargest2(int[] nums, int k) {
		return help(nums, 0, nums.length - 1, nums.length - k);
	}

	private int help(int[] nums, int begin, int end, int k) {
		int pos = getPos(nums, begin, end);

		if (pos == k - 1)
			return nums[pos];
		else if (pos > k - 1)
			return help(nums, begin, pos, k);
		else
			return help(nums, pos + 1, end, k - pos - 1);

	}

	private int getPos(int[] nums, int begin, int end) {
		int stand = nums[begin];
		while (begin < end) {
			while (begin < end && nums[end] >= stand) {
				end--;
			}
			nums[begin] = nums[end];

			while (begin < end && nums[begin] < stand) {
				begin++;
			}
			nums[end] = nums[begin];
		}
		nums[begin] = stand;

		return begin;
	}

}
