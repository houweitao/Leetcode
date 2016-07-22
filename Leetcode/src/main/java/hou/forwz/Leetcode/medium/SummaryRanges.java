package hou.forwz.Leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月22日下午11:14:29
 */

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		List<String> ret = new LinkedList<>();
		if (nums.length == 0)
			return ret;
		if (nums.length == 1) {
			add(ret, nums[0], nums[0]);
			return ret;
		}
		int begin = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0)
				begin = 0;
			else if (i == nums.length - 1) {
				if (nums[i] == nums[i - 1])
					add(ret, nums[begin], nums[i]);
				else {
					add(ret, nums[begin], nums[i - 1]);
					add(ret, nums[i], nums[i]);
				}
			} else {
				if (nums[i] == nums[i - 1] + 1) {
				} else {
					add(ret, nums[begin], nums[i - 1]);
					begin = i;
				}
			}
		}
		return ret;
	}

	private void add(List<String> ret, int begin, int end) {
		if (begin == end)
			ret.add(begin + "");
		else
			ret.add(begin + "->" + end);
	}

}
