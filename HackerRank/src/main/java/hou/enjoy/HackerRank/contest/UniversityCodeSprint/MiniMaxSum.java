package hou.enjoy.HackerRank.contest.UniversityCodeSprint;

import java.util.Scanner;

/**
 * @author houweitao
 * @date 2016年11月11日下午3:24:20
 */

public class MiniMaxSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		long c = in.nextLong();
		long d = in.nextLong();
		long e = in.nextLong();

		String aa = addStrings(addStrings(b + "", c + ""), addStrings(d + "", e + ""));
		String bb = addStrings(addStrings(c + "", a + ""), addStrings(d + "", e + ""));
		String cc = addStrings(addStrings(b + "", a + ""), addStrings(d + "", e + ""));
		String dd = addStrings(addStrings(b + "", a + ""), addStrings(c + "", e + ""));
		String ee = addStrings(addStrings(b + "", a + ""), addStrings(d + "", c + ""));

		String max = "1";
		String min = "90000000000";

		if (bigger(aa, max))
			max = aa;
		if (bigger(bb, max))
			max = bb;
		if (bigger(cc, max))
			max = cc;
		if (bigger(dd, max))
			max = dd;
		if (bigger(ee, max))
			max = ee;

		if (bigger(min, aa))
			min = aa;
		if (bigger(min, bb))
			min = bb;
		if (bigger(min, cc))
			min = cc;
		if (bigger(min, dd))
			min = dd;
		if (bigger(min, ee))
			min = ee;
		System.out.println(min + " " + max);
	}

	static String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
			int x = i < 0 ? 0 : num1.charAt(i) - '0';
			int y = j < 0 ? 0 : num2.charAt(j) - '0';
			sb.append((x + y + carry) % 10);
			carry = (x + y + carry) / 10;
		}
		return sb.reverse().toString();
	}

	static boolean bigger(String a, String b) {
		if (a.equals(b))
			return false;
		else if (a.length() > b.length())
			return true;
		else if (a.length() < b.length())
			return false;
		else {
			for (int i = 0; i < a.length(); i++) {
				int l = a.charAt(i) - '0';
				int r = b.charAt(i) - '0';

				if (l > r)
					return true;
				else if (l < r)
					return false;
			}
			return false;
		}
	}
}
