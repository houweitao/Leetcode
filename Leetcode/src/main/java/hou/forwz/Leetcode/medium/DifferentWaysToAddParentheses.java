package hou.forwz.Leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月29日上午12:07:58
 */

public class DifferentWaysToAddParentheses {

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> ret = new LinkedList<>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));

				for (int x : left) {
					for (int y : right) {
						if (c == '+')
							ret.add(x + y);
						else if (c == '-')
							ret.add(x - y);
						else
							ret.add(x * y);
					}
				}

			}
		}

		if (ret.size() == 0)
			ret.add(Integer.valueOf(input));

		return ret;
	}

}
