package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author houweitao
 * @date 2016年7月18日下午11:30:26
 */

public class SingleNumberII {

	public int singleNumber(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			if (map.containsKey(n)) {
				if (map.get(n) == 2)
					map.remove(n);
				else
					map.put(n, 2);
			} else
				map.put(n, 1);
		}

		int ret = -1;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			ret = entry.getKey();
		}

		return ret;

	}

}
