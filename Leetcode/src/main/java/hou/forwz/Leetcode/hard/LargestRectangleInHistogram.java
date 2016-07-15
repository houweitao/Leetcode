package hou.forwz.Leetcode.hard;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年7月15日下午10:11:28
 */

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
		int[] heights = {2,1,5,6,2,3,6,5,4};
		System.out.println(lr.largestRectangleArea(heights));
	}

	public int largestRectangleArea(int[] tmp) {

		if (tmp.length < 1)
			return 0;
		else if (tmp.length == 1)
			return tmp[0];

		int[] heights = new int[tmp.length + 1];
		for (int i = 1; i <= tmp.length; i++)
			heights[i] = tmp[i - 1];

		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int max = 0;
		for (int i = 1; i < heights.length; i++) {
			if (heights[i] > heights[stack.peek()]) {
				stack.push(i);
				max = Math.max((i - stack.get(0) + 1) * heights[stack.get(0)], max);
				while (!stack.isEmpty()) {
					if (heights[stack.peek()] > heights[i]) {
						max = Math.max(max, (i - stack.get(stack.size() - 2) - 1) * heights[stack.peek()]);
						stack.pop();
					} else
						break;
				}
				stack.push(i);
			}
		}

		for (int i = 0; i < stack.size() - 1; i++) {
			max = Math.max(max, (stack.get(stack.size() - 1) - stack.get(i)) * heights[stack.get(i + 1)]);
		}

		max = Math.max(heights.length * heights[stack.get(0)], max);
		max = Math.max(heights[stack.get(stack.size() - 1)], max);

		return max;
	}

}
