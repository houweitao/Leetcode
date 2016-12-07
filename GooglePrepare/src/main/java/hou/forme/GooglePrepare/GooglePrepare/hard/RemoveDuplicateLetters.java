package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年12月7日上午12:46:16
 * @url https://discuss.leetcode.com/topic/31404/a-short-o-n-recursive-greedy-solution
 * @other https://discuss.leetcode.com/topic/31663/java-2ms-two-pointers-solution-or-stack-simulation-beats-99-72
 * @ps 二者是一个思想。上面的更简练更 clean 2016年12月07日12:23:07
 */

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		RemoveDuplicateLetters rd = new RemoveDuplicateLetters();
		String s = "abacb";
		System.out.println(rd.removeDuplicateLetters2(s));
	}

	public String removeDuplicateLetters(String s) {
		if (s.length() < 2)
			return s;
		int[] exist = new int[128];
		int pos = 0;
		for (int i = 0; i < s.length(); i++) {
			exist[s.charAt(i)]++;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c < s.charAt(pos))
				pos = i;
			exist[c]--;
			if (exist[c] == 0)
				break;
		}

		return s.length() == 0 ? ""
				: s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
	}

	public String removeDuplicateLetters2(String s) {
		StringBuilder sb = new StringBuilder();
		while (s.length() > 0) {
			char[] ch = s.toCharArray();
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < ch.length; i++) {
				map.put(ch[i], i);
			}

			int firstShowOfLastChar = findMin(map);

			char c = ch[firstShowOfLastChar];
			int index = firstShowOfLastChar;
			for (int i = 0; i <= firstShowOfLastChar; i++) {
				if (ch[i] < c) {
					c = ch[i];
					index = i;
				}
			}
			if (index == firstShowOfLastChar) {
				for (int i = 0; i <= firstShowOfLastChar; i++) {
					if (ch[i] == c) {
						c = ch[i];
						index = i;
						break;
					}
				}
			}

			sb.append(c);
			s = next(s, c, index);
		}
		return sb.toString();
	}

	private String next(String s, char c, int index) {
		StringBuilder sb = new StringBuilder();
		for (int i = index; i < s.length(); i++) {
			if (s.charAt(i) != c)
				sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	private int findMin(Map<Character, Integer> map) {
		int min = Integer.MAX_VALUE;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			min = Math.min(min, entry.getValue());
		}
		return min;
	}

}
