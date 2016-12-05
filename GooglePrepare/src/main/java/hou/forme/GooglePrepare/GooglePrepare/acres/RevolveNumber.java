package hou.forme.GooglePrepare.GooglePrepare.acres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年12月5日上午10:02:31
 * @end 2016年12月05日10:31:10
 * @url http://www.1point3acres.com/bbs/thread-214731-1-1.html
 */

public class RevolveNumber {

	public static void main(String[] args) {
		RevolveNumber rn = new RevolveNumber();
		String num = "16091";
		System.out.println(rn.isRevolveNumber(num));

		rn.printAll(2);
	}

	boolean isRevolveNumber(String str) {
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('2', '5');
		map.put('5', '2');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');

		if (str == null)
			return false;
		else if (str == "")
			return true;
		else {
			int left = 0, right = str.length() - 1;
			while (left <= right) {
				char l = str.charAt(left++);
				char r = str.charAt(right--);

				if (map.containsKey(l) && map.get(l) == r) {
					// nice
				} else
					return false;
			}
			return true;
		}
	}

	void printAll(int n) {
		int len = n / 2;
		List<String> left = new ArrayList<>();

		Map<Character, Character> map = new HashMap<>();
		buildMap(map);

		dfs("", len, left, map);

		List<String> all = new ArrayList<>();

		if (n % 2 == 0) {
			generate(left, "", map, all);
		} else {
			generate(left, "0", map, all);
			generate(left, "1", map, all);
			generate(left, "8", map, all);
		}

		for (String str : all) {
			System.out.println(str);
		}
	}

	private void generate(List<String> left, String mid, Map<Character, Character> map, List<String> all) {
		for (String str : left) {
			String right = getRight(str, map);
			StringBuilder sb = new StringBuilder(str);
			sb.append(mid);
			sb.append(right);
			all.add(sb.toString());
		}
	}

	private String getRight(String str, Map<Character, Character> map) {
		if (str.length() == 0)
			return str;
		else {
			StringBuilder sb = new StringBuilder();
			for (int i = str.length() - 1; i >= 0; i--) {
				sb.append(map.get(str.charAt(i)));
			}
			return sb.toString();
		}
	}

	private void buildMap(Map<Character, Character> map) {
		map.put('0', '0');
		map.put('1', '1');
		map.put('2', '5');
		map.put('5', '2');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
	}

	private void dfs(String pre, int n, List<String> left, Map<Character, Character> map) {
		if (n == 0) {
			if (pre.length() == 0 || pre.length() > 0 && pre.charAt(0) != '0')// 不然会bug的
				left.add(pre);
			return;
		}

		if (pre.length() == 0 || pre.length() > 0 && pre.charAt(0) != '0') {
			for (Map.Entry<Character, Character> entry : map.entrySet()) {
				dfs(pre + entry.getKey(), n - 1, left, map);
			}
		} else {
			System.out.println("???");
		}
	}
}
