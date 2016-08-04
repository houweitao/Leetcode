package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年8月4日下午11:03:52
 */

public class FractionToRecurringDecimal {

	public static void main(String[] args) {
		FractionToRecurringDecimal ft = new FractionToRecurringDecimal();
		System.out.println(ft.fractionToDecimalMe(-1, Integer.MIN_VALUE));
	}

	public String fractionToDecimalMe(int numerator, int denominator) {

		StringBuffer sb = new StringBuffer();
		if (denominator == 0)
			return "bad";
		else if (numerator == 0)
			return 0 + "";
		else {
			String sign = "";
			if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
				sign = "-";
				sb.append(sign);
			}

			long first=(long)(Math.abs((long)numerator));
			long second=(long)(Math.abs((long)denominator));
			
			long zhengshu = first / second;
			sb.append(zhengshu);

			if (first % second == 0)
				return sb.toString();

			sb.append(".");

			Map<Long, Integer> record = new HashMap<>();
			long cur = first % second;
			while (!record.containsKey(cur)) {
//				System.out.println(cur+","+second);
				record.put(cur, sb.length());
				long next = 10 * cur / second;
				sb.append(next);
				cur = 10 * cur % second;
				// if (cur == 0)
				// return sb.toString();
			}

			int index = record.get(cur);
			sb.insert(index, "(");
			sb.append(")");
			return sb.toString().replace("(0)", "");
		}

	}

	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder result = new StringBuilder();
		String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		result.append(sign);
		result.append(num / den);
		long remainder = num % den;
		if (remainder == 0)
			return result.toString();
		result.append(".");
		HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
		while (!hashMap.containsKey(remainder)) {
			hashMap.put(remainder, result.length());
			result.append(10 * remainder / den);
			remainder = 10 * remainder % den;
		}
		int index = hashMap.get(remainder);
		result.insert(index, "(");
		result.append(")");
		return result.toString().replace("(0)", "");
	}

}
