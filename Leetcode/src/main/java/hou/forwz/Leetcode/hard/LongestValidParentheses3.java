package hou.forwz.Leetcode.hard;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年8月10日下午10:51:07
 */

public class LongestValidParentheses3 {
	public static void main(String[] args) {
		String s = ")()())))()())()";
		LongestValidParentheses3 lv = new LongestValidParentheses3();
		System.out.println(lv.longestValidParenthesesBetterMe(s));
	}

	// https://discuss.leetcode.com/topic/13138/share-my-java-solution-with-stack-and-dp
	public int longestValidParenthesesBetterMe(String s) {
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
//			System.out.println(s.charAt(i));
			if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
				stack.pop();
				int left = -1;
				if (!stack.isEmpty()) {
					left = stack.peek();
				}
//				System.out.println(i+","+left);
				max = Math.max(max, i - left);
			} else
				stack.push(i);
		}
		return max;
	}

	public int longestValidParenthesesBetter(String s) {
		Stack<Integer> st = new Stack<>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')' && !st.isEmpty() && s.charAt(st.peek()) == '(') {
				st.pop();
				max = Math.max(max, i - ((st.isEmpty()) ? -1 : st.peek()));
			} else
				st.push(i);

//			System.out.println(st);
		}
		return max;
	}

	public int longestValidParentheses(String s) {
		if (s.length() < 2)
			return 0;

		int rightNum = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty())
				stack.push(i);
			else if (c == ')') {
				rightNum++;
				if (s.charAt(stack.peek()) == '(')
					stack.pop();
				else
					stack.push(i);
			} else
				stack.push(i);
		}
		if (stack.isEmpty())
			return s.length();
		int curMax = s.length() - 1 - stack.peek();
		while (!stack.isEmpty()) {
			if (curMax * 2 >= rightNum)
				break;
			int up = stack.pop();
			int down;
			if (stack.isEmpty())
				down = 0;
			else
				down = stack.peek();

			int cur = up - down - 1;
			curMax = Math.max(curMax, cur);
		}
		return curMax;
	}

}
