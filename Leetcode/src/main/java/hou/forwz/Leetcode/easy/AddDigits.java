package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月22日上午2:31:10
 */

public class AddDigits {

	public int addDigits(int num) {
		if (num < 10)
			return num;
		else
			return addDigits(deal(num));

	}

	private int deal(int num) {
		int sum = 0;
		while (num > 0) {
			int ge = num % 10;
			sum = sum + ge;
			num = num / 10;
		}

		return sum;
	}

}
