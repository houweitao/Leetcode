package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月12日上午1:40:28
 */

public class AddBinary {
	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary("1", "1"));
	}

	public String addBinary(String a, String b) {
		int m = a.length(), n = b.length();
		String ret = "";
		int add = 0;
		for (int i = 0; i < Math.min(n, m); i++) {
			int sum = (a.charAt(m - i - 1) - '0') + (b.charAt(n - i - 1) - '0') + add;
			ret = sum % 2 + ret;
			add = sum / 2;
		}

		if (m == n) {
			if (add == 0)
				return ret;
			else
				return add + ret;
		} else if (m > n) {
			return addBinary(a.substring(0, m - n), add + "") + ret;
		} else
			return addBinary(b.substring(0, n - m), add + "") + ret;

	}

}
