package hou.forwz.Leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年8月17日下午10:42:26
 * @timeout
 */

public class SerializeAndDeserializeBinaryTree2 {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class MyNode {
		boolean isNull;
		TreeNode node;
		String val;

		public MyNode(TreeNode node) {
			if (node != null) {
				this.node = node;
				val = node.val + "";
			} else {
				isNull = true;
				val = "$";
			}
		}

		public MyNode() {
			isNull = true;
			val = "$";
		}

	}

	public class Codec {
		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null)
				return "$";
			Queue<MyNode> queue = new LinkedList<>();
			queue.offer(new MyNode(root));
			StringBuffer sb = new StringBuffer();
			sb.append(queue.peek().val + ",");
			System.out.println(sb);
			while (!queue.isEmpty()) {
				Queue<MyNode> tmp = new LinkedList<>();
				boolean end = true;
				while (!queue.isEmpty()) {
					MyNode cur = queue.poll();
					if (cur.isNull) {
						tmp.offer(new MyNode());
						tmp.offer(new MyNode());
						sb.append("$,");
						sb.append("$,");
					} else {
						if (cur.node.left != null || cur.node.right != null)
							end = false;
						MyNode left = new MyNode(cur.node.left);
						tmp.offer(left);
						MyNode right = new MyNode(cur.node.right);
						tmp.offer(right);

						sb.append(left.val + ",");
						sb.append(right.val + ",");
					}
				}
				if (end)
					break;

				queue = tmp;

			}
			System.out.println(sb.toString());
			return sb.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] strs = data.split(",");

			if (strs.length == 1) {
				if (strs[0].charAt(0) == '$')
					return null;
				else
					return new TreeNode(Integer.valueOf(strs[0]));
			} else {
				return build(strs, 0);
			}
		}

		private TreeNode build(String[] strs, int start) {
			if (start >= strs.length)
				return null;
			else {
				String c = strs[start];
				if (c.equals("$"))
					return null;
				else {
					TreeNode ret = new TreeNode(Integer.valueOf(c));
					ret.left = build(strs, (start + 1) * 2 - 1);
					ret.right = build(strs, (start + 1) * 2);
					return ret;
				}
			}
		}
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
}
