package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月7日下午10:19:31
 */

public class LetterCombinationsOfPhoneNumber {
	String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> ret = new ArrayList<>();
		if (digits.length() < 1)
			return ret;
		else
		if (digits.length() == 1) {
			String str = map[Integer.valueOf(digits)];
			for (int i = 0; i < str.length(); i++)
				ret.add(str.charAt(i) + "");
			return ret;
		} else {
			List<String> next = letterCombinations(digits.substring(1));
			List<String> now = letterCombinations(digits.substring(0, 1));

			for (int i = 0; i < now.size(); i++) {
				for (int j = 0; j < next.size(); j++) {
					ret.add(now.get(i) + next.get(j));
				}
			}
			return ret;
		}

	}

}
