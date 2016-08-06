package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月7日上午1:46:45
 */

public class SelfCrossing {

	public boolean isSelfCrossing(int[] x) {
		if (x.length < 4)
			return false;
		int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
		for (int i = 0; i < x.length - 4; i++) {
			a = x[i];
			b = x[i + 1];
			c = x[i + 2];
			d = x[i + 3];

			if (c <= a && d >= b)
				return true;

			if (i + 5 < x.length) {
				e = x[i + 4];
				f = x[i + 5];
				if (c > a && d >= b && (e + a) >= c && (f + b) >= d)
					return true;
			}
		}

		return false;
	}

}
