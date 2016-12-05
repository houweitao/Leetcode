package hou.forme.GooglePrepare.GooglePrepare.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月4日下午3:18:13
 * @end 2016年12月04日15:23:14
 * @url https://segmentfault.com/a/1190000004905350
 */

public class MajorityElement {

	// 4
	public List<Integer> majorityElement(int[] nums) {
		int a = 0, b = 1, c = 2;// candidate
		int ca = 0, cb = 0, cc = 0;// count

		for (int i : nums) {
			if (i == a)
				ca++;
			else if (i == b)
				cb++;
			else if (i == c)
				cc++;
			else if (ca == 0) {
				a = i;
				ca++;
			} else if (cb == 0) {
				b = i;
				cb++;
			} else if (cc == 0) {
				c = i;
				cc++;
			} else {
				ca--;
				cb--;
				cc--;
			}
		}
		ca = 0;
		cb = 0;
		cc = 0;
		for (int i : nums) {
			if (i == a)
				ca++;
			else if (i == b)
				cb++;
			else if (i == c)
				cc++;
		}

		List<Integer> ret = new ArrayList<>();
		if (ca * 4 > nums.length)
			ret.add(a);
		if (cb * 4 > nums.length)
			ret.add(b);
		if (cc * 4 > nums.length)
			ret.add(c);
		return ret;
	}
}
