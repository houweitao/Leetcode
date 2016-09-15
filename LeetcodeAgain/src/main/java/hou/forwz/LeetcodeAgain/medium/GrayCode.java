package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月15日下午6:40:12
 */

public class GrayCode {
	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(0));
	}

	public List<Integer> grayCode(int n) {
		List<Integer> ret = new ArrayList<>();
		if (n < 1) {
			ret.add(0);
			return ret;
		}
		List<String> strs = help(n);
		System.out.println(strs);

		for (String str : strs) {
			ret.add(transform(str));
		}
		return ret;
	}

	private int transform(String str) {
		if (str.length() == 0)
			return 0;
		else {
			int sum = 0;
			int pos = 0;
			for (int i = str.length() - 1; i >= 0; i--) {
				if (str.charAt(i) == '1') {
					sum = sum + (int) Math.pow(2, pos);
				}
				pos++;
			}
			return sum;
		}
	}

	private List<String> help(int n) {
		List<String> help = new ArrayList<>();
		if (n < 0)
			return help;
		if (n == 1) {
			help.add("0");
			help.add("1");
			return help;
		} else {
			List<String> next = help(n - 1);

			for (String str : next) {
				help.add(0 + str);
			}

			for (int i = next.size() - 1; i >= 0; i--) {
				help.add(1 + next.get(i));
			}

			return help;
		}
	}

}
