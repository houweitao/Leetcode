package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月8日下午8:45:03
 */

public class UglyNumber {
	public static void main(String[] args) {
		UglyNumber un = new UglyNumber();
		System.out.println(un.isUgly(-2147483648));
	}

	public boolean isUgly(int n) {
		long num = n;
		if (num < 0)
			num = -num;

		boolean judge = true;
		while (judge && num > 1) {
			judge = false;

			if (num % 2 == 0) {
				judge = true;
				num = num / 2;
			}
			if (num % 3 == 0) {
				judge = true;
				num = num / 3;
			}
			if (num % 5 == 0) {
				judge = true;
				num = num / 5;
			}
			
			System.out.println(num);
		}

		if (num == 1)
			return true;
		else
			return false;
	}

}
