package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月1日上午12:02:28
 */

public class CountOfSmallerNumbersAfterSelf {
	public static void main(String[] args) {
		CountOfSmallerNumbersAfterSelf cs = new CountOfSmallerNumbersAfterSelf();
		int[] nums = { 5, 2, 6, 1 };
		System.out.println(cs.countSmaller(nums));
	}

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> ret = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int index = findIndex(list, nums[i]);
			ret.add(0, index);
			list.add(index, nums[i]);
//			System.out.println(index);
//			System.out.println(list);
		}

		return ret;
	}

	private Integer findIndex(List<Integer> list, int num) {
		int pos = 0;

		if (list.size() == 0)
			return 0;

		int left = 0, right = list.size() - 1;
		if (num <= list.get(left))
			return 0;
		if (num > list.get(right))
			return list.size();

		while (left < right) {
			if (left == right - 1) {
				if (num <= list.get(left))
					return left;
				else if (num > list.get(left) && num <= list.get(right))
					return left+1;
				else
					return right+1;
			}

			int mid = left + (right - left) / 2;
			if (list.get(mid) >= num)
				right = mid;
			else
				left = mid;
		}

		return pos;
	}

}
