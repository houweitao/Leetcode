package hou.forme.GooglePrepare.GooglePrepare.hard;

import hou.forme.GooglePrepare.GooglePrepare.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年12月6日下午3:55:35
 * @end 2016年12月06日16:06:35
 * @ps awesome
 */

public class SerializeAndDeserializeBinaryTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Codec {
		String kong = "null";
		String split = ",";
		int pos = 0;

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuffer sb = new StringBuffer();
			dfs(root, sb);
			System.out.println(sb.toString());
			return sb.toString();
		}

		private void dfs(TreeNode root, StringBuffer sb) {
			if (root == null) {
				sb.append(kong);
				sb.append(split);
			} else {
				sb.append(root.val);
				sb.append(split);
				dfs(root.left, sb);
				dfs(root.right, sb);
			}
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] strs = data.split(split);
			pos = 0;
			TreeNode root = decode(strs);
			return root;
		}

		private TreeNode decode(String[] strs) {
			if (pos >= strs.length)
				return null;
			String cur = strs[pos];
			pos++;
			if (cur.equals(kong))
				return null;
			else {
				TreeNode ret = new TreeNode(Integer.valueOf(cur));
				ret.left = decode(strs);
				ret.right = decode(strs);
				return ret;
			}
		}
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
}
