package hou.forwz.Leetcode.hard;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年8月11日上午1:36:58
 */

public class LargestRectangleInHistogram2 {
	public static void main(String[] args) {
		LargestRectangleInHistogram2 lh = new LargestRectangleInHistogram2();
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		System.out.println(lh.largestRectangleArea(heights));
	}

	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int[] help = new int[heights.length + 1];
		for (int i = 0; i < heights.length; i++) {
			help[i] = heights[i];
		}

		int max = 0;
		for (int i = 0; i < help.length; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
			} else {
				if (help[i] >= help[stack.peek()]) {
					stack.push(i);
				} else {
					while (!stack.isEmpty()) {
						if (help[stack.peek()] <= help[i])
							break;

						int top = help[stack.pop()];
						int left = -1;
						if (!stack.isEmpty()) {
							left = stack.peek();
						}
//						System.out.println(i + "-" + left + "  *  " + top);
						max = Math.max(max, (i - 1 - left) * top);
					}

					stack.push(i);
				}
			}
//			System.out.println(stack);
		}
		return max;
	}
}
