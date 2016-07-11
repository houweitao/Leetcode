package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月12日上午1:34:58
 */

public class PlusOne {

	public int[] plusOne(int[] digits) {
		int add = 1;
		int len = digits.length - 1;
		for (int i = len; i >= 0; i--) {
			int sum = digits[i] + add;

			digits[i] = sum % 10;
			add = sum / 10;
			if (add == 0)
				return digits;
		}

		if (add == 0)
			return digits;
		else {
			int[] ret = new int[len + 2];
			ret[0] = add;

			if (ret.length > 1)
				for (int i = 1; i < ret.length; i++)
					ret[i] = digits[i - 1];
			return ret;
		}
	}

}
