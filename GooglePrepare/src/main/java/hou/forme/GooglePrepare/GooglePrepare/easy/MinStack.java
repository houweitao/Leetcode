package hou.forme.GooglePrepare.GooglePrepare.easy;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年12月5日下午9:05:11
 * @end 2016年12月05日21:09:22
 */

public class MinStack {
	Stack<Integer> cache;
	Stack<Integer> min;

	/** initialize your data structure here. */
	public MinStack() {
		cache = new Stack<>();
		min = new Stack<>();
	}

	public void push(int x) {
		cache.push(x);
		if (min.isEmpty())
			min.push(x);
		else {
			if (x <= min.peek())
				min.push(x);
		}

	}

	public void pop() {
		int out = cache.pop();
		if (out == min.peek())
			min.pop();
	}

	public int top() {
		return cache.peek();
	}

	public int getMin() {
		return min.peek();
	}
}
