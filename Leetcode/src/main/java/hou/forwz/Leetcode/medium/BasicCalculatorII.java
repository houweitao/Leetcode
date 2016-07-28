package hou.forwz.Leetcode.medium;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年7月28日下午9:28:55
 */

public class BasicCalculatorII {
	public static void main(String[] args) {
		BasicCalculatorII bc = new BasicCalculatorII();
		System.out.println(bc.calculate("1+2*5/2"));
	}

	public int calculate(String s) {
		if (s.length() == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		s = s + "+0";
		char operater = '+';
		int toAdd = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ')
				continue;
			else if (c == '+' || c == '-' || c == '*' || c == '/') {
				int one = stack.pop();

				if (operater == '+')
					stack.push(one);
				else if (operater == '-')
					stack.push(-one);
				else if (operater == '*') {
					int two = stack.pop();
					stack.push(one * two);
				} else {
					int two = stack.pop();
					stack.push(two / one);
				}

				operater = c;

			} else {
				if (i == s.length() - 1) {
					toAdd = 10 * toAdd + (c - '0');
					stack.push(toAdd);
				} else {
					if (s.charAt(i + 1) - '0' >= 0 && s.charAt(i + 1) - '9' <= 0)
						toAdd = toAdd * 10 + (c - '0');
					else {
						toAdd = toAdd * 10 + (c - '0');
						stack.push(toAdd);
						toAdd = 0;
					}
				}
			}

		}
		int sum = 0;
		for (int num : stack)
			sum = sum + num;

		return sum;
	}

}
