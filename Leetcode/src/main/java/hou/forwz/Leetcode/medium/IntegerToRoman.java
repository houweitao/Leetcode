package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年8月6日下午11:13:16
 */

public class IntegerToRoman {

	public String intToRoman(int num) {
		String M[] = { "", "M", "MM", "MMM" };
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
	}

}
