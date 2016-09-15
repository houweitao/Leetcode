package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月15日下午8:29:35
 */

public class PalindromePartitioning {
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		System.out.println(pp.partition("aaab"));
	}

	public List<List<String>> partition(String s) {
		return help(s, 0);
	}

	private List<List<String>> help(String s, int pos) {
		// System.out.println(s + "," + pos);
		List<List<String>> ret = new ArrayList<>();
		if (pos == s.length())
			return ret;
		else {
			for (int i = pos; i < s.length(); i++) {
				if (yes(s, pos, i)) {
					if (i == s.length() - 1) {
						List<String> tmp = new ArrayList<>();
						tmp.add(s.substring(pos));
						ret.add(tmp);
						return ret;
					} else {
						List<List<String>> next = help(s, i + 1);
						for (int j = 0; j < next.size(); j++) {
							List<String> tmp = new ArrayList<>();
							tmp.add(s.substring(pos, i + 1));
							tmp.addAll(next.get(j));
							ret.add(tmp);
						}
					}
				}
			}

			if (yes(s, pos, s.length() - 1)) {
				List<String> tmp = new ArrayList<>();
				tmp.add(s.substring(pos));
				ret.add(tmp);
			}

			return ret;
		}
	}

	private boolean yes(String s, int left, int right) {
		if (left == right)
			return true;
		else {
			while (left < right) {
				if (s.charAt(left) != s.charAt(right)) {
					return false;
				}
				left++;
				right--;
			}
			return true;
		}
	}

}
