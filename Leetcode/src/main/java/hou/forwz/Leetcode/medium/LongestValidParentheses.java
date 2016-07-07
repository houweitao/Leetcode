package hou.forwz.Leetcode.medium;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年7月7日下午10:53:05
 */

public class LongestValidParentheses {
	// https://discuss.leetcode.com/topic/2426/my-dp-o-n-solution-without-using-stack/2

	public int longestValidParenthesesNoStack(String s) {
		int[] mark = new int[s.length()];
		int curMax = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					if (i >= 2)
						mark[i] = mark[i - 2] + 2;
					else
						mark[i] = 2;
					curMax = Math.max(curMax, mark[i]);
				} else {
					int range = mark[i - 1];
					if (range != 0) {
						if (i - 1 - range >= 0 && s.charAt(i - 1 - range) == '(') {
							mark[i] = mark[i - 1] + 2;
							int add = 0;
							if (i - 2 - range > 0)
								add = mark[i - range - 2];
							mark[i] = mark[i] + add;
							curMax = Math.max(curMax, mark[i]);
						}
					}
				}
			}
		}

		return curMax;
	}

	// https://discuss.leetcode.com/topic/2289/my-o-n-solution-using-a-stack
	public int longestValidParenthesesStack(String s) {
		Stack<Integer> stack = new Stack<>();
		if (s.length() < 1)
			return 0;

		int ret = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				stack.push(i);
			else {
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

		if (stack.isEmpty())
			return s.length();
		else {
			int a = s.length(), b = 0;
			while (!stack.isEmpty()) {
				b = stack.pop();
				ret = Math.max(ret, a - b - 1);
				a = b;
			}
			ret = Math.max(ret, a);
		}
		return ret;

	}

	public int longestValidParentheses(String s) {
		if (s.length() < 1)
			return 0;
		else {
			int count = 0;
			int max = 0;
			int lastEmpty = 0;
			int pos = -1;
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (c == '(')
					stack.push(c);
				else {
					if (stack.isEmpty()) {
						max = Math.max(max, count);
						count = 0;
						stack.clear();
					} else {
						stack.pop();
						count++;
						if (stack.isEmpty()) {
							lastEmpty = count;
							pos = i;
						}
						max = Math.max(max, count);
					}
				}

			}

			if (!stack.isEmpty()) {
				int next = longestValidParentheses(s.substring(pos));

			}

			return 2 * max;
		}
	}

}
