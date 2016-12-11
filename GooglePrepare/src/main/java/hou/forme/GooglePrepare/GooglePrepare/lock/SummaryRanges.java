package hou.forme.GooglePrepare.GooglePrepare.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月11日上午11:06:59
 */

public class SummaryRanges {
	List<String> summaryRanges(int[] nums) {
		List<String> ret = new ArrayList<>();
		int last = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] + 1) {
				continue;
			} else {
				if (nums[i - 1] == last) {
					ret.add(last + "");
				} else {
					ret.add(last + "->" + nums[i - 1]);
				}
				last = nums[i];
			}
		}
		if (nums[nums.length - 1] == last)
			ret.add(last + "");
		else {
			ret.add(last + "->" + nums[nums.length - 1]);
		}

		return ret;
	}
}
