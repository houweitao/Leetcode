package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月26日上午1:13:16
 */

public class SumOfTwoIntegers {
	public static void main(String[] args) {
		int a=1,b=5;
		System.out.println(a^b);
	}

	public int getSum(int a, int b) {
		if (b == 0)
			return a;
		int carry = (a & b) << 1;
		int sum = a ^ b;
		return getSum(sum, carry);
	}

}
