package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月11日上午12:00:33
 */

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if (change(s).equals(change(t)))
			return true;
		else
			return false;
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
