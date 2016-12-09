package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年12月9日下午1:46:03
 * @end 2016年12月09日14:08:11
 */

public class DecodeString {
	public String decodeString(String s) {
		if (s == null || s.length() == 0)
			return "";
		Stack<Character> stack = new Stack<>();
		char[] ch = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : ch) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				if (c == ']') {
					StringBuilder cur = new StringBuilder();
					while (true) {
						char out = stack.pop();
						if (out == '[') {
							String before = "";
							while (stack.size() > 0 && Character.isDigit(stack.peek())) {
								char cu = stack.pop();
								before = cu + before;
							}

							char[] expend = expend(Integer.valueOf(before), cur.toString());
							for (char in : expend)
								stack.push(in);
							break;
						} else {
							cur.insert(0, out);
						}
					}
				} else {
					stack.push(c);
				}
			}
		}
		sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}
		return sb.toString();
	}

	private char[] expend(int num, String str) {
		char[] ret = new char[num * str.length()];

		for (int i = 0; i < ret.length; i++) {
			ret[i] = str.charAt(i % str.length());
		}
		return ret;
	}
}
