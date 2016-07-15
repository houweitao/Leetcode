package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月16日上午12:12:48
 */

public class RestoreIPAddresses {
	public static void main(String[] args) {
		RestoreIPAddresses ra = new RestoreIPAddresses();
		System.out.println(ra.restoreIpAddresses("1111"));
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> ret = new ArrayList<>();
		List<List<String>> help = help(s, 0, 4);

		System.out.println(help);

		for (int i = 0; i < help.size(); i++) {
			ret.add(deal(help.get(i)));
		}

		return ret;
	}

	private String deal(List<String> list) {
		String ret = "";
		for (String str : list)
			ret = ret + str + ".";

		return ret.substring(0, ret.length() - 1);
	}

	private List<List<String>> help(String s, int pos, int num) {
		List<List<String>> ret = new ArrayList<>();

		if (pos >= s.length())
			return ret;
		else if (num * 3 < (s.length() - 1 - pos))
			return ret;
		else if (num == 0 && pos < s.length())
			return ret;
		else if (s.charAt(pos) == '0') {
			if (num == 1 && pos == s.length() - 1) {
				List<String> tmp = new ArrayList<>();
				tmp.add("0");
				ret.add(tmp);
			} else {
				List<List<String>> next = help(s, pos + 1, num - 1);

				if (next.size() > 0) {
					for (int i = 0; i < next.size(); i++)
						next.get(i).add(0, "0");
				}
				return next;
			}
		} else {
			for (int i = pos; i < pos + 3 && i < s.length(); i++) {
				int cur = Integer.valueOf(s.substring(pos, i + 1));
				if (cur <= 255) {
					if (i + 1 == s.length()) {
						if (num == 1) {
							List<String> tmp = new ArrayList<>();
							tmp.add(cur + "");
							ret.add(tmp);
						}
					} else {
						List<List<String>> next = help(s, i + 1, num - 1);
						if (next.size() != 0) {
							for (int j = 0; j < next.size(); j++) {
								List<String> tmp = new ArrayList<>();
								tmp.add(cur + "");
								tmp.addAll(next.get(j));
								ret.add(tmp);
							}
						}
					}
				}
			}
		}

		return ret;
	}

}
