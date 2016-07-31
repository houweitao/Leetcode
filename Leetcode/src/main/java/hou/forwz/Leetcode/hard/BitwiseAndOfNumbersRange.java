package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月1日上午1:13:59
 */

public class BitwiseAndOfNumbersRange {
	public static void main(String[] args) {
		BitwiseAndOfNumbersRange ba = new BitwiseAndOfNumbersRange();
		System.out.println("range: "+ba.rangeBitwiseAnd(4, 7));
		System.out.println(3<<2);
		int a=30;
		a<<=3;
		System.out.println(a);
	}

	public int rangeBitwiseAnd(int m, int n) {
		int count = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			count++;
		}
		System.out.println("count: "+count);
		return m <<= count;
	}

}
