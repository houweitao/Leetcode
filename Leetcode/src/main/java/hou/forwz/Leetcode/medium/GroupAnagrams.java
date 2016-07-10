package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author houweitao
 * @date 2016年7月10日下午11:47:58
 */

public class GroupAnagrams {

	public static void main(String[] args) {
		GroupAnagrams ga = new GroupAnagrams();
		System.out.println(ga.change("eeat"));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		List<List<String>> ret = new ArrayList<>();

		for (String str : strs) {
			String tran = change(str);
			if (map.containsKey(tran)) {
				map.get(tran).add(str);
			} else {
				List<String> tmp = new ArrayList<>();
				tmp.add(str);
				map.put(tran, tmp);
				ret.add(tmp);
			}
		}

		return ret;
	}

	private String change(String str) {
		int[] map = new int[26];
		char[] alp = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i < str.length(); i++) {
			map[str.charAt(i) - 'a']++;
		}
		String ret = "";
		for (int i = 0; i < 26; i++)
			if (map[i] > 0) {
				ret = ret + map[i] + alp[i];
			}
		return ret;
	}

}
