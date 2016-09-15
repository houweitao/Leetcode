package hou.forwz.LeetcodeAgain.easy;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年9月15日下午10:01:23
 */

public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(' || c == '{' || c == '[')
				stack.push(c);
			else if (c == ')') {
				if (stack.isEmpty())
					return false;
				else if (stack.peek() == '(')
					stack.pop();
				else
					return false;
			} else if (c == ']') {
				if (stack.isEmpty())
					return false;
				else if (stack.peek() == '[')
					stack.pop();
				else
					return false;
			} else if (c == '}') {
				if (stack.isEmpty())
					return false;
				else if (stack.peek() == '{')
					stack.pop();
				else
					return false;
			}
		}

		return stack.isEmpty();
	}

}
