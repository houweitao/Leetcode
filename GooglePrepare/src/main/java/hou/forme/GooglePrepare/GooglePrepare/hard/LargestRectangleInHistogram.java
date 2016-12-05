package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年12月4日下午3:37:36
 */

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		System.out.println(lr.largestRectangleArea(heights));
	}

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		else if (heights.length == 1)
			return heights[0];

		int[] help = new int[heights.length + 1];
		for (int i = 0; i < heights.length; i++)
			help[i] = heights[i];
		help[help.length - 1] = 0;

		int max = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < help.length; i++) {
			if (stack.isEmpty())
				stack.push(i);
			else {
				if (help[i] >= help[stack.peek()]) {
					stack.push(i);
				} else {
					while (!stack.isEmpty() && help[stack.peek()] > help[i]) {
						int out = stack.pop();

						int left;// 想想为什么是这么做！2016年12月04日16:02:323
						if (stack.isEmpty())
							left = -1;
						else
							left = stack.peek();

						int cur = (i - 1 - left) * (help[out]);
						max = Math.max(max, cur);
					}

					stack.push(i);
				}
			}
		}
		return max;
	}
}
