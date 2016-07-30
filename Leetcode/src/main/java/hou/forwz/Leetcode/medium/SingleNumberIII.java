package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年7月30日下午11:15:15
 */

public class SingleNumberIII {
	public static void main(String[] args) {
		System.out.println(6 ^ -6);
	}

	public int[] singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int cur : nums) {
			if (map.containsKey(cur) && map.get(cur) == 1)
				map.remove(cur);
			else
				map.put(cur, 1);
		}

		int[] ret = new int[map.size()];
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ret[i++] = entry.getKey();
		}
		return ret;
	}

	public int[] singleNumber2(int[] nums) { // Pass 1 :
		// Get the XOR of the two numbers we need to find
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		// Get its last set bit
		diff &= -diff;

		// Pass 2 :
		int[] rets = { 0, 0 }; // this array stores the two numbers we will
								// return
		for (int num : nums) {
			if ((num & diff) == 0) // the bit is not set
			{
				rets[0] ^= num;
			} else // the bit is set
			{
				rets[1] ^= num;
			}
		}
		return rets;
	}

}
