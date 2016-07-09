//package hou.forwz.Leetcode.medium;
//
///**
// * @author houweitao
// * @date 2016年7月10日上午12:57:23
// */
//
//public class MultiplyStrings {
//	public static void main(String[] args) {
//		MultiplyStrings ms = new MultiplyStrings();
//		String p = "123", q = "456";
//		System.out.println(ms.multiply(p, q));
//		System.out.println(123*456);
//	}
//
//	public String multiply(String num1, String num2) {
//		if (num1 == "0" || num2 == "0")
//			return "0";
//
//		String ret = "";
//		int len = Math.min(num1.length(), num2.length());
//
//		int add = 0;
//		for (int i = 1; i <= len; i++) {
//			int cur1 = Integer.valueOf(num1.charAt(num1.length() - i)+"");
//			int cur2 = Integer.valueOf(num2.charAt(num2.length() - i)+"");
//
//			int sum = cur1 * cur2 + add;
//
//			ret = sum % 10 + ret;
//			add = sum / 10;
//			
//			System.out.println(ret+","+sum);
//		}
//
//		if (num1.length() > num2.length()) {
//			ret = add(num1.substring(0, num1.length() - len), add) + ret;
//			return ret;
//		} else if (num1.length() < num2.length()) {
//			ret = add(num2.substring(0, num2.length() - len), add) + ret;
//			return ret;
//		} else {
//			if (add > 0)
//				return add + ret;
//			else
//				return ret;
//		}
//
//	}
//
//	private String add(String str, int add) {
//		if (add == 0)
//			return str;
//		else if (str.length() == 0)
//			return add + "";
//		else {
//			String ret = "";
//			int n = Integer.valueOf(str.charAt(str.length() - 1)+"");
//			int sum = n + add;
//
//			if (sum >= 10) {
//				int cur = sum % 10;
//				add = sum % 10;
//
//				ret = add(str.substring(0, str.length() - 1), add) + cur;
//				return ret;
//
//			} else {
//				return str.substring(0, str.length() - 1) + sum;
//			}
//
//		}
//
//	}
//
//}
