package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月22日上午12:14:34
 */

public class Numberof1Bits {
	public static void main(String[] args) {
		Numberof1Bits nb = new Numberof1Bits();
		System.out.println(nb.hammingWeight(7867));
	}

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		System.out.println(n);
		int count = 1;
		while (n != 0) {
			int p = n & 1;
			if (p == 1)
				count++;
			n = n >>> 1;
		}
		return count;
	}

}
