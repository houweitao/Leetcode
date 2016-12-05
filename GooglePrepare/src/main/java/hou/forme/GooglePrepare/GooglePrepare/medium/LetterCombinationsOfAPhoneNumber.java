package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月5日下午3:35:10
 * @end 2016年12月05日15:43:28
 */

public class LetterCombinationsOfAPhoneNumber {

	public List<String> letterCombinations(String digits) {
		List<String> ret = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return ret;
		String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		dfs(digits, 0, "", map, ret);
		return ret;
	}

	private void dfs(String digits, int pos, String pre, String[] map, List<String> ret) {
		if (pos == digits.length()) {
			ret.add(pre);
		} else {
			int index = digits.charAt(pos) - '0';
			String need = map[index];
			for (int i = 0; i < need.length(); i++) {
				dfs(digits, pos + 1, pre + need.charAt(i), map, ret);
			}
		}

	}

}
