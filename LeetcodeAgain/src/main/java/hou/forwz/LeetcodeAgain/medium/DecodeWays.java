package hou.forwz.LeetcodeAgain.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年9月16日下午3:09:16
 */

public class DecodeWays {
	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		System.out.println(dw.numDecodings("123"));
	}

	Map<String, Integer> map = new HashMap<>();

	public int numDecodings(String s) {
		if (map.containsKey(s))
			return map.get(s);
		else if (s.length() == 0)
			return 0;
		else if (s.charAt(0) == '0')
			return 0;
		else if (s.length() == 1)
			return 1;
		else {
			int ret = numDecodings(s.substring(1));
			if (Integer.valueOf(s.substring(0, 2)) <= 26) {
				if (s.substring(2).length() == 0)
					ret++;
				else
					ret += numDecodings(s.substring(2));
			}

			map.put(s, ret);
			return ret;
		}
	}

}
