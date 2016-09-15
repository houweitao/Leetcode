package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月15日下午12:30:15
 */

public class GenerateParentheses {
	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(3));
	}

	public List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<>();
		if (n == 0)
			return ret;
		else {
			dfs("", n, n, ret);
			return ret;
		}
	}

	private void dfs(String pre, int left, int right, List<String> ret) {
		if (left > right || left < 0)
			return;
		else if (left == right && right == 0) {
			ret.add(pre);
		} else {
			dfs(pre + "(", left - 1, right, ret);
			dfs(pre + ")", left, right - 1, ret);
		}
	}

}
