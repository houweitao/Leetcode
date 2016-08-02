package hou.forwz.Leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年8月3日上午1:07:23
 * @bad 超时 2016年08月03日01:48:50
 * @url https://discuss.leetcode.com/topic/3107/accepted-o-n-solution
 */

public class MinimumWindowSubstring3 {

	public static void main(String[] args) {
		MinimumWindowSubstring3 mw = new MinimumWindowSubstring3();
		System.out.println(mw.minWindow("bdab", "ab"));
	}

	public String minWindow(String s, String t) {

		if (t.length() == 1) {
			if (s.contains(t))
				return t;
			else
				return "";
		}

		Map<Character, Integer> com = new HashMap<>();

		for (int i = 0; i < s.length(); i++)
			com.put(s.charAt(i), 0);

		Map<Character, Integer> need = generate(t);

		// System.out.println(need);
		// System.out.println(com);

		int begin = -1, end = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			for (int k = 0; k < s.length(); k++)
				com.put(s.charAt(k), 0);
			for (int j = i; j < s.length(); j++) {
				com.put(s.charAt(j), com.get(s.charAt(j)) + 1);

				// System.out.println(j + ": " + com);
				// System.out.println(chaju(need, com));

				if (chaju(need, com) == 0) {
					// System.out.println("..");

					while (true) {

						int cur = chaju(need, com);

						System.out.println(com);
						System.out.println(cur);

						if (cur == 0) {
							if (j - i < min) {
								begin = i;
								end = j;
								min = end - begin;
								if (min == 0)
									return t;
							}
						} else if (chaju(need, com) == 2) {
							i--;
							com.put(s.charAt(i), com.get(s.charAt(i)) + 1);

							// System.out.println("break");
							break;
						}
						com.put(s.charAt(i), com.get(s.charAt(i)) - 1);
						i++;
						if (chaju(need, com) == 2) {
							i--;
							com.put(s.charAt(i), com.get(s.charAt(i)) + 1);

							// System.out.println("break");
							break;
						}

						if (i > j)
							break;
					}
				}
			}
		}

		if (end == -1)
			return "";
		else
			return s.substring(begin, end + 1);
	}

	private int chaju(Map<Character, Integer> need, Map<Character, Integer> com) {
		int sum = 0;

		for (Map.Entry<Character, Integer> entry : need.entrySet()) {
			if (!com.containsKey(entry.getKey())) {
				sum = sum + entry.getValue();
			} else {
				int cha = entry.getValue() - com.get(entry.getKey());
				if (cha > 0)
					sum = sum + cha;
			}
		}

		return sum;
	}

	private Map<Character, Integer> generate(String t) {
		Map<Character, Integer> ret = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (ret.containsKey(c))
				ret.put(c, ret.get(c) + 1);
			else
				ret.put(c, 1);
		}
		return ret;
	}

}
