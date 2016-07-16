package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月17日上午12:45:19
 */

public class ValidPalindrome {
	public static void main(String[] args) {
		ValidPalindrome va = new ValidPalindrome();
		System.out.println(va.isPalindrome("a."));
	}

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();

		int left = 0, right = s.length() - 1;
		while (left < right) {
			char l = s.charAt(left), r = s.charAt(right);
			if (nice(l) && nice(r)) {
				if (l != r)
					return false;
				System.out.println("..");
				left++;
				right--;
			} else {
				if (!nice(l))
					left++;
				if (!nice(r))
					right--;
			}
		}
		return true;
	}

	private boolean nice(char c) {
		if (c - 'a' >= 0 && c - 'z' <= 0 || c - '0' >= 0 && c - '9' <= 0)
			return true;
		else
			return false;
	}

}
