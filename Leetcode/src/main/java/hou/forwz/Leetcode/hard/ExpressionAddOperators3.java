package hou.forwz.Leetcode.hard;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月28日下午10:37:13
 */

public class ExpressionAddOperators3 {
	public static void main(String[] args) {
		ExpressionAddOperators3 ea = new ExpressionAddOperators3();
		System.out.println(ea.addOperators("000", 0));

	}

	public List<String> addOperators(String num, int target) {
		List<String> ret = new LinkedList<>();
		if (num.length() == 0)
			return ret;

		dfs(ret, "", num, 0, target, 0, 0);

		return ret;
	}

	private void dfs(List<String> ret, String path, String str, int pos, int target, long lastResult, long cur3) {
		// System.out.println(path + "," + pos + "," + lastResult);

		if (pos == str.length()) {
			// System.out.println(lastResult + "," + target);
			if (lastResult == target)
				ret.add(path);
			return;
		}

		// System.out.println(pos+","+str);

		// int cur = str.charAt(pos) - '0';
		for (int i = pos; i < str.length(); i++) {
			if (i != pos && str.charAt(pos) == '0')// 如果是0就别继续了吧
				break;
			long cur = Long.parseLong(str.substring(pos, i + 1));
			if (pos == 0) {
				dfs(ret, path + cur, str, i + 1, target, cur, cur);
			} else {
				dfs(ret, path + "+" + cur, str, i + 1, target, lastResult + cur, cur);
				dfs(ret, path + "-" + cur, str, i + 1, target, lastResult - cur, -cur);
				dfs(ret, path + "*" + cur, str, i + 1, target, lastResult - cur3 + cur3 * cur, cur3 * cur);
			}
		}
	}

}
