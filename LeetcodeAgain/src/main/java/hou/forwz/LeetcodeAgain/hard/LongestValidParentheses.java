package hou.forwz.LeetcodeAgain.hard;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年8月28日下午9:35:27
 */

public class LongestValidParentheses {
	public static void main(String[] args) {
		LongestValidParentheses lv = new LongestValidParentheses();
		String s = ")()()))()(())))";
		System.out.println(lv.longestValidParenthesesOnePass(s));
	}

	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (stack.isEmpty())
				stack.push(i);
			else if (c == '(')
				stack.push(i);
			else if (c == ')') {
				if (s.charAt(stack.peek()) == '(')
					stack.pop();
				else
					stack.push(i);
			}

		}

		if (stack.isEmpty())
			return s.length();
		if (stack.size() == s.length())
			return 0;

		int max = 0;
		int pos = s.length();
		while (!stack.isEmpty()) {
			int top = stack.pop();
			max = Math.max(max, pos - top - 1);
			pos = top;
		}

		max = Math.max(max, pos);

		return max;

	}

	public int longestValidParenthesesOnePass(String s) {
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					stack.push(i);
				} else if (s.charAt(stack.peek()) == '(') {
					stack.pop();
					if (stack.isEmpty()) {
						max = Math.max(max, i + 1);
					} else {
						max = Math.max(max, i - stack.peek());
					}
				} else {
					stack.push(i);
				}
			}

		}

		return max;

	}

}
