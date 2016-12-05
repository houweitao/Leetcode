package hou.forme.GooglePrepare.GooglePrepare.easy;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年12月5日下午3:45:38
 */

public class ValidParentheses {

	public boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return true;
		char[] ch = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char c : ch) {
			if (stack.isEmpty())
				stack.push(c);
			else {
				if (c == '(' || c == '[' || c == '{')
					stack.push(c);
				else if (c == ')') {
					if (stack.peek() == '(')
						stack.pop();
					else
						return false;
				} else if (c == ']') {
					if (stack.peek() == '[')
						stack.pop();
					else
						return false;
				} else if (c == '}') {
					if (stack.peek() == '{')
						stack.pop();
					else
						return false;
				}
			}
		}

		return stack.isEmpty();
	}

}
