package hou.forme.GooglePrepare.GooglePrepare.lock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年12月11日下午2:07:48
 */

public class GroupShiftGroup {
	List<List<String>> groutGroup(String[] strs) {
		Map<String, Set<String>> map = new HashMap<>();
		for (String str : strs) {
			String mask = getMask(str);
			if (!map.containsKey(mask)) {
				map.put(mask, new HashSet<String>());
			}

			map.get(mask).add(str);
		}

		List<List<String>> ret = new ArrayList<>();
		for (Set<String> set : map.values()) {
			ret.add(new ArrayList<>(set));
		}
		return ret;
	}

	private String getMask(String str) {
		if (str.length() == 0)
			return "$";
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			int range = str.charAt(i) - str.charAt(i - 1);
			sb.append(range + ",");
		}
		return sb.toString();
	}
}
