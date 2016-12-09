package hou.forme.GooglePrepare.GooglePrepare.easy;

/**
 * @author houweitao
 * @date 2016年12月9日下午1:35:04
 */

public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		int[] num = new int[26];
		char[] a = s.toCharArray();
		char[] b = t.toCharArray();

		for (char i : a) {
			num[i - 'a']++;
		}

		for (char i : b) {
			num[i - 'a']--;
		}

		int pos = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] != 0) {
				pos = i;
				break;
			}
		}

		for (char i = 'a'; i <= 'z'; i++) {

			if (pos-- == 0)
				return i;
		}

		return 'a';
	}
}
