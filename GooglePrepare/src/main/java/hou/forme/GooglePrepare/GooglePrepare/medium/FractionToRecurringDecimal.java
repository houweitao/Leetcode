package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年12月5日下午9:18:50
 */

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {

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

			long first = (long) (Math.abs((long) numerator));
			long second = (long) (Math.abs((long) denominator));

			long zhengshu = first / second;
			sb.append(zhengshu);

			if (first % second == 0)
				return sb.toString();

			sb.append(".");

			Map<Long, Integer> record = new HashMap<>();
			long cur = first % second;
			while (!record.containsKey(cur)) {
				// System.out.println(cur+","+second);
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
}
