package hou.forwz.LeetcodeAgain.me.yang;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年11月28日下午12:06:03
 * @end 2016年11月28日12:20:44
 */

public class PalindromeNumber {
	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		List<String> list = pn.generateAll(5);
		for (String str : list) {
			System.out.println(str);
		}
	}

	// judge
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		else if (x == 0)
			return true;
		else {
			String str = x + "";
			int left = 0, right = (str).length() - 1;
			while (left < right) {
				if (str.charAt(left++) != str.charAt(right--))
					return false;
			}
			return true;
		}
	}

	List<String> generateAll(int n) {
		List<String> tmp = new ArrayList<>();
		dfs(n / 2, "", tmp);

		List<String> ret = new ArrayList<>(tmp.size());
		if (n % 2 == 0)
			deal(tmp, ret, "");
		else {
			for (int i = 0; i < 10; i++) {
				deal(tmp, ret, i + "");
			}
		}

		return ret;
	}

	private void deal(List<String> tmp, List<String> ret, String mid) {
		for (String str : tmp) {
			StringBuilder sb = new StringBuilder(str);
			sb.append(mid);
			sb.append(new StringBuffer(str).reverse().toString());
			ret.add(sb.toString());
		}
	}

	private void dfs(int remain, String pre, List<String> tmp) {
		if (remain == 0) {
			if (nice(pre))
				tmp.add(pre);
		} else {
			for (int i = 0; i < 10; i++) {
				dfs(remain - 1, pre + i, tmp);
			}
		}
	}

	private boolean nice(String pre) {
		if (pre.length() == 0)
			return true;
		else if (pre.charAt(0) == '0')
			return false;
		else
			return true;
	}
}
