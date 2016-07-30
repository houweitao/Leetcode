package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月30日下午10:59:25
 */

public class SumOfTwoIntegers2 {
	public static void main(String[] args) {
		SumOfTwoIntegers2 st = new SumOfTwoIntegers2();
		System.out.println(st.getSum(60, 55));
	}

	public int getSum(int a, int b) {
		System.out.println(a + "," + b);
		if (b == 0) {// 没有进为的时候完成运算
			return a;
		}
		int sum, carry;
		sum = a ^ b;// 完成第一步加发的运算
		carry = (a & b) << 1;// 完成第二步进位并且左移运算
		return getSum(sum, carry);//
	}
}
