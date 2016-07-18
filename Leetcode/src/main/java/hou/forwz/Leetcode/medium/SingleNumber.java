package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author houweitao
 * @date 2016年7月18日下午10:54:57
 */

public class SingleNumber {

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			if (map.containsKey(n))
				map.remove(n);
			else
				map.put(n, 1);
		}

		int ret = -1;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			ret = entry.getKey();
		}

		return ret;
	}

	public int singleNumber2(int[] nums) {
		int result = nums[0];
		int n = nums.length;
		for (int i = 1; i < n; i++) {
			result = result ^ nums[i]; /* Get the xor of all elements */
		}
		return result;
	}

}
