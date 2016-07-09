package hou.forwz.Leetcode.hard;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年7月9日下午10:04:36
 */

public class LongestValidParentheses {
	public static void main(String[] args) {
		LongestValidParentheses lv = new LongestValidParentheses();
		System.out.println(lv.longestValidParentheses(")()())"));
	}

	public int longestValidParentheses(String s) {
		if (s.length() < 2)
			return 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty())
					stack.push(i);
				else {
					if (s.charAt(stack.peek()) == '(')
						stack.pop();
					else
						stack.push(i);
				}
			}
		}
		System.out.println(stack);

		int max = 0;
		if (stack.isEmpty())
			return s.length();
		else {
			max = s.length() - 1 - stack.peek();
			int pos = stack.pop();
			while (!stack.isEmpty()) {
				int cur = stack.pop();
				max = Math.max(max, pos - cur - 1);
				pos = cur;
			}

			max = Math.max(max, pos);
		}

		System.out.println(stack);

		return max;
	}

}
