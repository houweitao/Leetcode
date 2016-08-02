package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月3日上午12:43:21
 */

public class MinimumWindowSubstring2 {
	public static void main(String[] args) {
		MinimumWindowSubstring2 mw = new MinimumWindowSubstring2();
		System.out.println(mw.minWindow("ADOBECODEBANC", "AE"));
	}

	public String minWindow(String s, String t) {
		int[] need = generate(t);
		int[] com = new int[26];
		int begin = 0, end = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				com[s.charAt(j) - 'A']++;

				if (chaju(need, com) == 0) {
					while (true) {

						int cur = chaju(need, com);

						if (cur == 0) {
							if (j - i < min) {
								begin = i;
								end = j;
							}
						} else if (chaju(need, com) == 2) {
							i--;
							com[s.charAt(i)-'A']++;
							break;
						}

						com[s.charAt(i++)-'A']--;
//						if (i >= j)
//							break;
					}
				}
			}
		}

		if (end == 0)
			return "";
		else
			return s.substring(begin, end + 1);
	}

	private int chaju(int[] need, int[] com) {
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			if (com[i] < need[i])
				sum = sum + need[i] - com[i];
		}
		return sum;
	}

	private int[] generate(String t) {
		int[] ret = new int[26];
		for (int i = 0; i < t.length(); i++)
			ret[t.charAt(i) - 'A']++;
		return ret;
	}

}
