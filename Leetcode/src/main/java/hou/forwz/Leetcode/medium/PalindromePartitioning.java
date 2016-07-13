package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月13日下午11:10:05
 */

public class PalindromePartitioning {

	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		System.out.println(pp.partition("aba"));
	}

	private List<List<String>> help(String s, int pos) {
		List<List<String>> ret = new ArrayList<>();

		if (pos == s.length())
			return ret;
		
		boolean find=false;
		for (int i = pos; i < s.length(); i++) {
			if (is(s, pos, i)) {
				if (pos == s.length() - 1) {
					List<String> tmp = new ArrayList<>();
					tmp.add(s.substring(pos, i + 1));
					ret.add(tmp);
					return ret;
				} else {
					List<List<String>> next = help(s, i + 1);
					for (int k = 0; k < next.size(); k++) {
						List<String> tmp = new ArrayList<>();
						tmp.add(s.substring(pos, i + 1));
						tmp.addAll(next.get(k));
						ret.add(tmp);
					}
				}
			} 
		}
		
		if(is(s, pos,s.length()-1)){
			List<String> tmp = new ArrayList<>();
			tmp.add(s.substring(pos));
			ret.add(tmp);
		}

		return ret;
	}

	private boolean is(String s, int begin, int end) {
		if (begin == end)
			return true;
		while (begin < end) {
			if (s.charAt(begin) != s.charAt(end))
				return false;
			begin++;
			end--;
		}
		return true;

	}

	public List<List<String>> partition(String s) {
		return help(s, 0);
	}

	private int[][] buildMap(String s) {
		int len = s.length();
		int[][] map = new int[len + 1][len + 1];
		for (int i = 1; i <= len; i++)
			map[i][i] = 1;

		for (int i = 1; i < len; i++) {
			if (s.charAt(i - 1) == s.charAt(i))
				map[i][i + 1] = 1;
		}

		for (int i = 1; i < len; i++) {
			for (int j = i + 2; j <= len; j++) {
				if (s.charAt(i - 1) == s.charAt(j - 1))
					map[i][j] = 1;
			}
		}

		return map;
	}

}
