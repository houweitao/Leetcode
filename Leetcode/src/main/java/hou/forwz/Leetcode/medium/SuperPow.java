//package hou.forwz.Leetcode.medium;
//
///**
// * @author houweitao
// * @date 2016年7月11日上午12:15:03
// */
//
//public class SuperPow {
//
//	public int superPow(int a, int[] b) {
//		int c = deal(b);
//		return help(a, c);
//	}
//
//	private int help(int a, int n) {
//		if (n == 0)
//			return 1;
//		else if (n == 1)
//			return a % 1337;
//		else {
//			return (int) (((int) (Math.pow(help(a, n / a) % 1337, n / a) % 1337)) * (Math.pow(a, n % a) % 1337));
//
//		}
//	}
//
//	private int deal(int[] b) {
//		if (b.length == 0)
//			return 0;
//		int ret = 0;
//		for (int i = 0; i < b.length; i++) {
//			ret = ret + 10 * b[i];
//		}
//		return ret;
//	}
//
//}
