package hou.forwz.Leetcode.hard;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年8月11日上午1:58:28
 */

public class MaximalRectangle {
	

	public int maximalRectangle(char[][] matrix) {
		int max = 0;

		for (int i = 0; i < matrix.length; i++) {
			int[] tmp = new int[matrix[0].length];
			tmp = get(matrix, i);
			print(tmp);

			max = Math.max(max, largestRectangleArea(tmp));
		}

		return max;
	}

	private void print(int[] tmp) {
		for (int i : tmp)
			System.out.print(i);
		System.out.println();
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
						// System.out.println(i + "-" + left + " * " + top);
						max = Math.max(max, (i - 1 - left) * top);
					}

					stack.push(i);
				}
			}
			// System.out.println(stack);
		}
		return max;
	}

	private int[] get(char[][] matrix, int begin) {
		int[] ret = new int[matrix[0].length];
		for (int j = 0; j < matrix[0].length; j++) {
			int count = 0;
			for (int i = begin; i < matrix.length; i++) {
				if (matrix[i][j] == '1')
					count++;
				else
					break;
			}
			ret[j] = count;
		}
		return ret;
	}

}
