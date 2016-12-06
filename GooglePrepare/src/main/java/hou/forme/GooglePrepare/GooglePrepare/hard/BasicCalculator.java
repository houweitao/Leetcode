package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年12月6日下午1:01:59
 */

public class BasicCalculator {
	public int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int len = s.length();
		int sign = 1;
		int result = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int sum = 0;
				while (i < len && Character.isDigit(s.charAt(i))) {
					sum = 10 * sum + (s.charAt(i) - '0');
					i++;
				}
				i--;
				result += sum * sign;
			} else if (ch == '+') {
				sign = 1;
			} else if (ch == '-') {
				sign = -1;
			} else if (ch == '(') {
				stack.push(result);
				stack.push(sign);
				sign = 1;
				result = 0;
			} else if (ch == ')') {
				result = result * stack.pop() + stack.pop();
			}
		}

		return result;
	}
}
