package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月6日下午11:18:14
 */

public class LongestCommonPrefix {

	// better https://discuss.leetcode.com/topic/6987/java-code-with-13-lines
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		else if (strs.length == 1)
			return strs[0];
		else {
			String str = strs[0];
			if (str.length() < 1)
				return "";
			else {
				String ret = "";
				for (int i = 0; i < str.length(); i++) {
					ret = str.substring(0, i + 1);
					for (int j = 1; j < strs.length; j++) {
						if (!(strs[i].substring(0, i + 1) == ret))
							return ret.substring(0, ret.length() - 1);
					}
				}

				return ret;
			}
		}
	}

}
