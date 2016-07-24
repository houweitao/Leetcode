package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月24日下午9:46:57
 */

public class PowerOfTwo {
	public static void main(String[] args) {
		System.out.println(33 & 34);

		for (int i = 0; i < 40; i++) {
			System.out.println(i + ": " + (i & (i - 1)));
		}
	}

	boolean is(int n) {
		if (n < 0)
			return false;
		else {
			return (n & (n - 1)) == 0;
		}
	}
}
