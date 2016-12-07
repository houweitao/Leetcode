package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年12月7日下午2:34:22
 */

public class PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> ret = new ArrayList<>();
		if (words == null || words.length < 2)
			return ret;

		Map<String, Integer> map = new HashMap<>();

		List<Integer> benshen = new ArrayList<>();
		List<Integer> kong = new ArrayList<>();

		for (int i = 0; i < words.length; i++) {
			String str = words[i];
			map.put(str, i);

			if (str.equals("")) {
				kong.add(i);
			}

			if (is(str)) {
				benshen.add(i);
			}
		}

		for (int i : kong) {
			for (int j : benshen) {
				if(i==j)
					continue;
				List<Integer> a = new ArrayList<>();
				a.add(i);
				a.add(j);
				List<Integer> b = new ArrayList<>();
				b.add(j);
				b.add(i);
				
				ret.add(a);
				ret.add(b);
			}
		}
		for (int i : kong)
			map.remove(words[i]);

		for (String str : map.keySet()) {
			for (int i = 0; i < str.length(); i++) {
				String left = str.substring(0, i);
				String right = str.substring(i);

				String leftNeed = new StringBuilder(right).reverse().toString();
				String rightNeed = new StringBuilder(left).reverse().toString();

				if (is(left) && map.containsKey(leftNeed)) {
					List<Integer> a = new ArrayList<>();
					a.add(map.get(leftNeed));
					a.add(map.get(str));

					if (map.get(leftNeed) != map.get(str))
						ret.add(a);
				}
				if (is(right) && map.containsKey(rightNeed)) {
					List<Integer> a = new ArrayList<>();
					a.add(map.get(str));
					a.add(map.get(rightNeed));

					if (map.get(rightNeed) != map.get(str))
						ret.add(a);
				}
			}
		}

		return ret;
	}

	boolean is(String str) {
		if (str == null)
			return false;
		if (str.length() == 0)
			return true;

		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left++) != str.charAt(right--))
				return false;
		}
		return true;
	}
}
