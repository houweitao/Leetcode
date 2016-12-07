package hou.forme.GooglePrepare.GooglePrepare.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年12月7日下午2:56:05
 */

public class ReverseVowelsOfAString {

	public String reverseVowels(String s) {
		if (s == null || s.length() < 2)
			return s;
		char[] yes = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		Set<Character> set = new HashSet<>();
		for (char c : yes)
			set.add(c);

		int left = 0, right = s.length() - 1;
		char[] ch = s.toCharArray();
		while (left < right) {
			while (!set.contains(ch[left]) && left < right) {
				left++;
			}
			while (!set.contains(ch[right]) && left < right) {
				right--;
			}

			char tmp = ch[right];
			ch[right] = ch[left];
			ch[left] = tmp;
			left++;
			right--;
		}

		return new String(ch);
	}
}
