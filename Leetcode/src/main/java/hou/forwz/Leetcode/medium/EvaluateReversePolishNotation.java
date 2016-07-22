package hou.forwz.Leetcode.medium;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年7月23日上午1:09:48
 */

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		if (tokens.length == 0)
			return 0;

		for (String s : tokens) {
			if (s.equals("+")) {
				int two = stack.pop();
				int one = stack.pop();
				stack.push(one + two);
			} else if (s.equals("-")) {
				int two = stack.pop();
				int one = stack.pop();
				stack.push(one - two);
			} else if (s.equals("*")) {
				int two = stack.pop();
				int one = stack.pop();
				stack.push(one * two);
			} else if (s.equals("/")) {
				int two = stack.pop();
				int one = stack.pop();
				stack.push(one / two);
			} else {
				stack.push(Integer.valueOf(s));
			}
		}

		int sum = 0;
		while (!stack.isEmpty()) {
			sum = sum + stack.pop();
		}
		return sum;
	}

}
