package hou.forwz.Leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author houweitao
 * @date 2016年7月13日上午12:55:18
 */

public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() != s2.length() + s3.length())
			return false;

		Map<Character, Integer> c1 = produceContainer(s1);
		Map<Character, Integer> c2 = produceContainer(s2);
		Map<Character, Integer> c3 = produceContainer(s3);

		for (Entry<Character, Integer> entry : c1.entrySet()) {
			char c = entry.getKey();
			int sum = entry.getValue();

			int sum2 = c2.containsKey(c) ? c2.get(c) : 0;
			int sum3 = c3.containsKey(c) ? c3.get(c) : 0;
			
			if(sum!=sum2+sum3)
				return false;
		}
		
		return true;
	}

	Map<Character, Integer> produceContainer(String str) {
		Map<Character, Integer> ret = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (ret.containsKey(c)) {
				ret.put(c, ret.get(c) + 1);
			} else
				ret.put(c, 1);
		}
		return ret;
	}
}
