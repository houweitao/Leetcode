package hou.forwz.LeetcodeAgain.me;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年11月29日下午7:32:37
 * @end 2016年11月29日19:41:52
 * @url http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=213828&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */

public class LongestPalindromicSubsequence {
	Map<String, Integer> map = new HashMap<>();
	int mapNum = 0;
	int allNum = 0;

	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String str = "AABCDEBAZAA";
		System.out.println(lps.longest(str));
	}

	int longest(String str) {
		char[] ch = str.toCharArray();

		int ret = help(ch, 0, ch.length - 1);

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry);
		}
		System.out.println("map:"+mapNum);
		System.out.println("all:"+allNum);
		return ret;
	}

	private int help(char[] ch, int left, int right) {
		if (left > right)
			return 0;
		else if (left == right) {
			allNum++;
			return 1;
		} else {
			String str = get(ch, left, right);
			if (map.containsKey(str)) {
				mapNum++;
				return map.get(str);
			} else {
				int ret = 0;
				if (ch[left] == ch[right]) {
					ret = 2 + help(ch, left + 1, right - 1);
				} else {
					int one = help(ch, left + 1, right);
					int two = help(ch, left, right - 1);
					ret = Math.max(one, two);
				}
				map.put(str, ret);
				allNum++;
				return ret;
			}
		}
	}

	private String get(char[] ch, int left, int right) {
		return new String(ch, left, right - left);
	}
}
