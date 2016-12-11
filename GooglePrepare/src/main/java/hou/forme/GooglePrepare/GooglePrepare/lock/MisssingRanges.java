package hou.forme.GooglePrepare.GooglePrepare.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月11日上午11:16:51
 */

public class MisssingRanges {
	List<String> findMissingRanges(int[] nums, int low, int high) {
		List<String> ret = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			ret.add(low + "->" + high);
			return ret;
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1] + 1) {
				ret.add(get(nums[i - 1], nums[i]));
			}
		}

		if (nums[nums.length - 1] != high) {
			ret.add(get(nums[nums.length - 1], high));
		}
		return ret;
	}

	private String get(int i, int j) {
		if (i + 2 == j)
			return (i + 1) + "";
		else
			return (i + 1) + "->" + (j - 1);
	}
}
