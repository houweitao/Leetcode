package hou.forme.GooglePrepare.GooglePrepare.easy;

/**
 * @author houweitao
 * @date 2016年12月5日下午5:11:51
 * @end 2016年12月05日17:16:40
 */

public class PlusOne {

	public int[] plusOne(int[] digits) {
		int add = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + add;

			digits[i] = sum % 10;
			add = sum / 10;
		}

		if (add != 0) {
			return make(add, digits);
		} else
			return digits;
	}

	private int[] make(int add, int[] digits) {
		int[] ret = new int[digits.length + 1];
		ret[0] = add;
		for (int i = 0; i < digits.length; i++)
			ret[i + 1] = digits[i];
		return ret;
	}

}
