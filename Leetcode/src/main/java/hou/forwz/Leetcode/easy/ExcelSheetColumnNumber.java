package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月12日下午10:41:27
 */

public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
		if (s.length() < 1)
			return 0;
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			int cur = s.charAt(i) - 'A' + 1;
			sum = 26 * sum + cur;
		}
		return sum;
	}

}
