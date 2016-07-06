package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月6日下午9:02:39
 */

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;

		String str = x + "";

		int left = 0, right = str.length() - 1;

		while (left <= right) {
			if (str.charAt(left) != str.charAt(right))
				return false;
			left++;
			right--;
		}

		return true;
	}

}
