package hou.forwz.Leetcode.easy;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年7月24日下午10:08:25
 */

public class ImplementQueueUsingStacks {
	Stack<Integer> a = new Stack<>();
	Stack<Integer> b = new Stack<>();

	// Push element x to the back of queue.
	public void push(int x) {
		if (b.isEmpty())
			a.push(x);
		else {
			while (!b.isEmpty()) {
				a.push(b.pop());
			}
			a.push(x);
		}
	}

	// Removes the element from in front of queue.
	public void pop() {

		if (b.isEmpty()) {

			while (!a.isEmpty()) {
				b.push(a.pop());
			}
			b.pop();
		} else
			b.pop();
	}

	// Get the front element.
	public int peek() {
		if (a.isEmpty())
			return b.peek();
		else
			return a.get(0);
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return a.isEmpty() && b.isEmpty();
	}

}
