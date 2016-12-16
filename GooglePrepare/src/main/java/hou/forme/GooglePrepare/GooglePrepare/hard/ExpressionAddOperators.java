package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月15日下午3:02:55
 * @url https://discuss.leetcode.com/topic/24523/java-standard-backtrace-ac-solutoin-short-and-clear
 */

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> rst = new ArrayList<String>();
		if (num == null || num.length() == 0)
			return rst;
		helper(rst, "", num, target, 0, 0, 0);
		return rst;
	}

	public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
		if (pos == num.length()) {
			if (target == eval)
				rst.add(path);
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0')
				break;
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) {
				helper(rst, path + cur, num, target, i + 1, cur, cur);
			} else {
				helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

				helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

				helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
			}
		}
	}
}
