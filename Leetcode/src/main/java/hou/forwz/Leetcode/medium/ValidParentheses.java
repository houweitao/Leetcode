package hou.forwz.Leetcode.medium;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年7月7日下午10:42:17
 */

public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '{' || c == '(' || c == '[')
				stack.push(c);
			else {
				if (stack.isEmpty())
					return false;
				else {
					if (c == '}') {
						if (stack.pop() != '{')
							return false;
					} else if (c == ')') {
						if (stack.pop() != '(')
							return false;
					} else {
						if (stack.pop() != '[')
							return false;
					}
				}
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}

}
