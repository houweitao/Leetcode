package hou.forwz.LeetcodeAgain.hard;

import java.util.LinkedList;
import java.util.Queue;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日下午7:19:14
 */

public class SerializeAndDeserializeBinaryTree {
	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree sd = new SerializeAndDeserializeBinaryTree();
		sd.build();
	}

	private void build() {
		Codec co = new Codec();
		TreeNode root = new TreeNode(1);
		TreeNode a1 = new TreeNode(2);
		TreeNode a2 = new TreeNode(3);
		TreeNode a3 = new TreeNode(4);
		TreeNode a4 = new TreeNode(5);

		root.left = a1;
		root.right = a2;
		a1.left = a3;
		a2.right = a4;

		System.out.println(co.serialize(root));
	}

	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public class Codec {
		class Node {
			TreeNode root;
			boolean isTreeNode;

			Node() {

			}

			Node(TreeNode node) {
				root = node;
				isTreeNode = true;
			}
		}

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuffer sb = new StringBuffer();
			if (root == null)
				return sb.toString();
			else {
				Queue<Node> queue = new LinkedList<>();
				queue.offer(new Node(root));
				while (!queue.isEmpty()) {
					Node cur = queue.poll();
					if (cur.isTreeNode) {
						if (cur.root.left != null)
							queue.offer(new Node(cur.root.left));
						else
							queue.offer(new Node());

						if (cur.root.right != null)
							queue.offer(new Node(cur.root.right));
						else
							queue.offer(new Node());

						sb.append(cur.root.val + " ");

					} else
						sb.append("$ ");
				}
				return sb.toString();
			}
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.length() == 0)
				return null;
			else {
				String[] strs = data.split(" ");
				TreeNode ret = new TreeNode(Integer.valueOf(strs[0]));
				Queue<TreeNode> queue = new LinkedList<>();
				queue.offer(ret);

				int i = 1;
				while (!queue.isEmpty()) {
					TreeNode node = queue.poll();
					String cur = strs[i++];
					if (cur.equals("$")) {
						node.left = null;
					} else {
						node.left = new TreeNode(Integer.valueOf(cur));
						queue.offer(node.left);
					}

					cur = strs[i++];
					if (cur.equals("$")) {
						node.right = null;
					} else {
						node.right = new TreeNode(Integer.valueOf(cur));
						queue.offer(node.right);
					}
				}
				return ret;
			}
		}
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
}
