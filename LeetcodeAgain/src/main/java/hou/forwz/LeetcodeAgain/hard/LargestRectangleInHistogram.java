package hou.forwz.LeetcodeAgain.hard;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年9月15日下午10:07:08
 * @我是辣鸡 2016年09月15日22:32:36
 */

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
		// int[] heights = { 2, 1, 5, 6, 2, 3 };
		int[] heights = { 1, 3, 2, 4, 6, 5, 4, 5, 6, 5 };
		System.out.println(lr.largestRectangleArea(heights));
	}

	public int largestRectangleArea(int[] height) {
		int max = 0;

		int[] help = new int[height.length + 1];
		for (int i = 0; i < height.length; i++) {
			help[i] = height[i];
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < help.length; i++) {
			// System.out.println(stack);
			if (stack.isEmpty()) {
				stack.push(i);
			} else if (help[i] >= help[stack.peek()]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty()) {
					if (help[stack.peek()] > help[i]) {
						int index = stack.pop();
						int left = stack.isEmpty() ? -1 : stack.peek();
						System.out.println(left + "," + i + ": " + index + ".. " + help[index]);
						max = Math.max(max, (i - left - 1) * help[index]);
					} else {
						break;
					}
				}
				stack.push(i);
			}
		}

		return max;
	}

}
