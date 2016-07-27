package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年7月27日下午10:59:58
 */

public class VerifyPreorderSerializationofABinaryTree {
	public static void main(String[] args) {
		VerifyPreorderSerializationofABinaryTree vf = new VerifyPreorderSerializationofABinaryTree();
		System.out.println(vf.isValidSerialization("9,#,92,#,#"));
	}

	public boolean isValidSerialization(String preorder) {
		String[] strs = preorder.split(",");

		if (strs.length < 1)
			return true;
		if (preorder.length() == 1 && preorder.charAt(0) == '#')
			return true;

		if (preorder.charAt(0) == '#' && preorder.length() > 1)
			return false;

		Stack<Node> stack = new Stack<>();
		Map<Node, Integer> map = new HashMap<>();

		Node[] nodes = new Node[strs.length];
		for (int i = 0; i < strs.length; i++) {
			nodes[i] = new Node(strs[i]);
			map.put(nodes[i], 0);
		}

		stack.push(nodes[0]);

		// System.out.println(stack);
		for (int i = 1; i < strs.length;) {
			if (stack.isEmpty())
				return false;

			if (map.get(stack.peek()) == 2) {
				stack.pop();
				if (!stack.isEmpty()) {
					map.put(stack.peek(), map.get(stack.peek()) + 1);
				}

			} else {
				String str = strs[i];
				if (str.equals("#")) {
					map.put(stack.peek(), map.get(stack.peek()) + 1);
					// if (map.get(stack.peek()) == 2)
					// stack.pop();
				} else {
					// System.out.println("push " + nodes[i]);
					stack.push(nodes[i]);
				}
				i++;
			}

			// System.out.println(stack.size() + ": " + stack);
		}

		while (!stack.isEmpty()) {
			if (map.get(stack.peek()) == 2) {
				stack.pop();
				if (!stack.isEmpty()) {
					map.put(stack.peek(), map.get(stack.peek()) + 1);
				}
			} else
				break;
		}

		// System.out.println(stack);
		if (stack.isEmpty())
			return true;
		else
			return false;
	}

	class Node {
		String val;
		Node left;
		Node right;

		Node(String c) {
			val = c;
		}

		@Override
		public String toString() {
			return val + "";
		}
	}

}
