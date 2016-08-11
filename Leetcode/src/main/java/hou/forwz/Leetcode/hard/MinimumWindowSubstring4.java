package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月11日下午10:38:59
 */

public class MinimumWindowSubstring4 {
	public static void main(String[] args) {
		MinimumWindowSubstring4 mw = new MinimumWindowSubstring4();
		System.out.println(mw.minWindow("cabwefgewcwaefgcf", "cae"));
		System.out.println(mw.minWindowMe("cabwefgewcwaefgcf", "cae"));
	}

	public String minWindowMe(String s, String t) {
		if (s == null || s.isEmpty() || t == null || t.isEmpty())
			return "";
		int[] Tmap = new int[256];
		int[] Smap = new int[256];
		for (int k = 0; k < t.length(); k++) {
			Tmap[t.charAt(k)]++;
		}
		int found = 0;
		int length = Integer.MAX_VALUE;
		String res = "";
		int left = 0, right = 0;
		while (right < s.length()) {
			if (found < t.length()) {
				char c = s.charAt(right);
				if (Tmap[c] > 0) {
					Smap[c]++;
					if (Smap[c] <= Tmap[c])
						found++;
				}

				right++;// right一定是大于当前最佳值
			}

			while (found == t.length()) {
				char c = s.charAt(left);
				if (Tmap[c] > 0) {
					Smap[c]--;
					if (Smap[c] < Tmap[c]) {
						found--;
						String cur = s.substring(left, right);
						if (cur.length() < length) {
							res = cur;
							length = cur.length();
						}
					}
				}
				left++;
			}
		}
		return res;
	}

	public String minWindow(String s, String t) {
		if (s == null || s.isEmpty() || t == null || t.isEmpty())
			return "";
		int i = 0, j = 0;
		int[] Tmap = new int[256];
		int[] Smap = new int[256];
		for (int k = 0; k < t.length(); k++) {
			Tmap[t.charAt(k)]++;
		}
		int found = 0;
		int length = Integer.MAX_VALUE;
		String res = "";
		while (j < s.length()) {
			if (found < t.length()) {
				if (Tmap[s.charAt(j)] > 0) {
					Smap[s.charAt(j)]++;
					if (Smap[s.charAt(j)] <= Tmap[s.charAt(j)]) {
						found++;
					}
				}
				j++;
			}
			while (found == t.length()) {
				if (j - i < length) {
					length = j - i;
					res = s.substring(i, j);
				}
				if (Tmap[s.charAt(i)] > 0) {
					Smap[s.charAt(i)]--;
					if (Smap[s.charAt(i)] < Tmap[s.charAt(i)]) {
						found--;
					}
				}
				i++;
			}
		}
		return res;
	}

}
