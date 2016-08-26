package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年8月26日下午6:53:26
 * @break 去打球 2016年08月26日18:57:00
 * @back 2016年08月26日22:06:26
 */

public class SubstringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords sw = new SubstringWithConcatenationOfAllWords();

		String s = "wordgoodgoodgoodbestword";
		String[] words = { "word", "good", "best", "good" };
		System.out.println(sw.findSubstring(s, words));
	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ret = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int sum = 0;
		for (String str : words) {
			sum += str.length();
			if (!map.containsKey(str))
				map.put(str, 0);
			map.put(str, map.get(str) + 1);
		}
		if (s.length() < sum)
			return ret;

		for (int i = 0; i < words[0].length(); i++) {
			deal(s, i, map, ret, words[0].length(), sum);
		}

		return ret;

	}

	private void deal(String str, int pos, Map<String, Integer> map, List<Integer> ret, int length, int sum) {
		 if (str.length() < sum+pos+1)
		 return;

		for (int i = pos; i <= str.length() - sum; i = i + length) {
			right(str.substring(i, i + sum), ret, map, length, i);
		}
	}

	private void right(String str, List<Integer> ret, Map<String, Integer> map, int len, int pos) {
//		System.out.println(str + "," + pos);
		if (str.length() == len) {
			if (map.size() == 1 && map.containsKey(str) && map.get(str) == 1)
				ret.add(pos);

		} else {
			String maybe = str.substring(0, len);
			if (map.containsKey(maybe)) {
				int num = map.get(maybe);
				if (num > 1)
					map.put(maybe, num - 1);
				else
					map.remove(maybe);

				right(str.substring(len), ret, map, len, pos);

				map.put(maybe, num);

			}
		}
	}

}
