package hou.forme.GooglePrepare.GooglePrepare.medium;

/**
 * @author houweitao
 * @date 2016年12月16日下午8:00:28
 * @url https://discuss.leetcode.com/topic/48332/java-o-1-with-explanation/2
 */

public class CountNumbersWithUniqueDigits {
	public static int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		int ans = 10, base = 9;
		for (int i = 2; i <= n && i <= 10; i++) {
			base = base * (9 - i + 2);
			ans += base;
		}
		return ans;
	}
}
