package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月15日下午11:19:30
 */

public class GrayCode {
	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(3));

	}

	public List<Integer> grayCode(int n) {
		List<Integer> ret = new ArrayList<>();
		if (n < 0)
			return ret;
		else if (n == 0) {
			ret.add(0);
			return ret;
		}

		List<String> helo = help(n);

		for (String str : helo) {
			ret.add(Integer.valueOf(str, 2));
		}
		return ret;
	}

	public List<String> help(int n) {
		List<String> ret = new ArrayList<>();
		if (n == 0)
			return ret;
		else if (n == 1) {
			ret.add("0");
			ret.add("1");
			return ret;
		} else {
			List<String> next = help(n - 1);

			for (String str : next) {
				ret.add("0" + str);
			}

			for (int i = next.size() - 1; i >= 0; i--)
				ret.add("1" + next.get(i));

			return ret;
		}
	}

}
