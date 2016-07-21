package hou.forwz.Leetcode.easy;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年7月21日下午10:56:05
 */

public class MinStack {
	boolean first = true;
	long min;
	Stack<Integer> mins;
	Stack<Integer> pack;

	/** initialize your data structure here. */
	public MinStack() {
		mins = new Stack<>();
		pack = new Stack<>();
	}

	public void push(int x) {
		pack.push(x);
		if (first) {
			min = x;
			first = false;
		} else
			min = Math.min(min, x);
		mins.push((int) min);
	}

	public void pop() {
		pack.pop();
		mins.pop();
	}

	public int top() {
		return pack.peek();
	}

	public int getMin() {
		if (mins.size() > 0)
			return mins.peek();
		else
			return -1;
	}

}
