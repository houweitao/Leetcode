package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月6日下午1:14:51
 * @end 2016年12月06日13:20:42
 */

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> ret = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return ret;

		int begin = nums[0];
		int cur = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == cur + 1) {
				cur = nums[i];
			} else {
				if (cur == begin) {
					ret.add(begin + "");
				} else {
					ret.add(begin + "->" + cur);
				}
				begin = nums[i];
				cur = nums[i];
			}
		}
		
		if (cur == begin) {
			ret.add(begin + "");
		} else {
			ret.add(begin + "->" + cur);
		}

		return ret;
	}
}
