package hou.forme.GooglePrepare.GooglePrepare.medium;

/**
 * @author houweitao
 * @date 2016年12月16日下午4:37:24
 * @url https://discuss.leetcode.com/topic/59871/two-algorithms-with-detailed-explaination
 */

public class RemoveKDigits {
	String removeKdigits(String num, int k) {
		while (k > 0) {
			int n = num.length();
			int i = 0;
			while (i + 1 < n && num.charAt(i) <= num.charAt(i + 1))
				i++;
			// num.erase(i, 1);
			k--;
		}
		// trim leading zeros
		int s = 0;
		// while (s < (int) num.size() - 1 && num[s] == '0')
		// s++;
		// num.erase(0, s);

		return num == "" ? "0" : num;
	}
}
