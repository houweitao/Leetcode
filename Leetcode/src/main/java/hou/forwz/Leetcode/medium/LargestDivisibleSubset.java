package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月4日下午11:56:17
 */

public class LargestDivisibleSubset {
	public static void main(String[] args) {
		LargestDivisibleSubset ld = new LargestDivisibleSubset();
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(ld.largestDivisibleSubset(nums));
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		if (nums.length == 0)
			return new ArrayList<>();

		Arrays.sort(nums);
		Path[] paths = new Path[nums.length];
		for (int i = 0; i < nums.length; i++) {
			paths[i] = new Path();
			paths[i].list.add(nums[i]);

		}

		int max = 1;
		int pos = 0;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) {
					if (paths[i].list.size() < paths[j].list.size() + 1) {
						paths[i].list = new ArrayList<>(paths[j].list);
						paths[i].list.add(nums[i]);
					}
				}
			}
			if (paths[i].list.size() > max) {
				pos = i;
				max = paths[i].list.size();
			}
		}

		return paths[pos].list;

	}

	class Path {
		List<Integer> list;

		Path() {
			list = new ArrayList<>();
		}
	}
}
