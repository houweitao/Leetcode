package hou.forwz.Leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author houweitao
 * @date 2016年7月24日下午10:13:36
 */

public class ImplementStackUsingQueues {
	Queue<Integer> a = new LinkedList<>();
	// Queue<Integer> b = new LinkedList<>();

	// Push element x onto stack.
	public void push(int x) {
		a.add(x);
		for (int i = 0; i < a.size() - 1; i++) {
			a.add(a.poll());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {

		a.poll();
	}

	// Get the top element.
	public int top() {
		return a.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return a.isEmpty();
	}

}
