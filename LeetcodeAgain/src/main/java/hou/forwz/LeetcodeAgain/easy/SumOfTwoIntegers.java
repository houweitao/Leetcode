package hou.forwz.LeetcodeAgain.easy;

/**
 * @author houweitao
 * @date 2016年9月30日下午6:48:35
 */

public class SumOfTwoIntegers {
	public static void main(String[] args) {
		SumOfTwoIntegers st = new SumOfTwoIntegers();
		System.out.println(st.getSum(129, 13));
	}

	public int getSum(int a, int b) {
		if (a == 0)
			return b;
		else if (b == 0)
			return a;
		else {
			return help(a, b, 0);
		}
	}

	private int help(int a, int b, int add) {
		if (a == 0 && b == 0)
			return add;
		else if (a == 0) {
			return help(b, a, add);
		} else if (b == 0) {
			if (add == 0)
				return a;
			else
				return help(a, add, 0);
		} else {
			int m = a % 10, n = b % 10;
			int cur = (m + n + add) % 10;
			add = (m + n + add) / 10;

			a = a / 10;
			b = b / 10;

			return cur + 10 * help(a, b, add);
		}
	}

}
