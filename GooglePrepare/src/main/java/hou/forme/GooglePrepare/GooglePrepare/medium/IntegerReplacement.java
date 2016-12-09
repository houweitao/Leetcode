package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年12月9日下午2:15:54
 */

public class IntegerReplacement {
	public int integerReplacement(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 0);
		map.put(2, 1);

		return helper(n, map);
	}

	private int helper(int n, Map<Integer, Integer> map) {
		if (map.containsKey(n)) {
			return map.get(n);
		}

		int steps = -1;
		if (n % 2 == 0) {
			steps = helper(n / 2, map) + 1;
		} else {
			steps = Math.min(helper((n - 1), map) + 1, helper((n + 1) / 2, map) + 2);
		}

		map.put(n, steps);

		return steps;
	}
}