package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月7日下午10:30:21
 */

public class GenerateParentheses {
	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(3));
	}

	public List<String> generateParenthesis(int n) {
		if (n == 0)
			return null;
		else
			return help(n, n);
	}

	private List<String> help(int left, int right) {
		List<String> ret = new ArrayList<>();

		if (left > right || left < 0)
			return ret;
		else {

			if (left == 0 && right == 1) {
				ret.add(")");
				return ret;
			}

			List<String> one = help(left - 1, right);
			List<String> two = help(left, right - 1);

			if (one.size() > 0) {
				for (String s : one)
					ret.add("(" + s);
			}
			if (two.size() > 0) {
				for (String s : two)
					ret.add(")" + s);
			}

			return ret;

		}
	}

}
