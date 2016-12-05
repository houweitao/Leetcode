package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月5日下午3:50:14
 */

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<>();
		dfs(n, n, "", ret);
		return ret;
	}

	private void dfs(int left, int right, String pre, List<String> ret) {
		if (left > right || left < 0)
			return;
		else if (left == right && left == 0)
			ret.add(pre);
		else {
			dfs(left - 1, right, pre + '(', ret);
			dfs(left, right - 1, pre + ')', ret);
		}
	}

}
