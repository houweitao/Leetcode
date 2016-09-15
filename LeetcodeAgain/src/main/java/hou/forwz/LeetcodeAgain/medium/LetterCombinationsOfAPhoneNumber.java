package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

/**
 * @author houweitao
 * @date 2016年9月15日下午12:23:21
 */

public class LetterCombinationsOfAPhoneNumber {
	String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };;

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();
		System.out.println(lc.letterCombinations("23"));
	}

	public List<String> letterCombinations(String digits) {
		List<String> ret = new ArrayList<>();
		if (digits.length() == 0)
			return ret;
		dfs(digits, 0, "", ret);
		return ret;
	}

	private void dfs(String digits, int pos, String pre, List<String> ret) {
		if (pos == digits.length()) {
			ret.add(pre);
		} else {
			int index = digits.charAt(pos) - '0';
			for (char c : map[index].toCharArray()) {
				dfs(digits, pos + 1, pre + c, ret);
			}
		}
	}

}
