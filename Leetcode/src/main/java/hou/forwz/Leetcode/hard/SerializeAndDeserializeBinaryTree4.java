package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年8月17日下午11:40:21
 */

public class SerializeAndDeserializeBinaryTree4 {

	public class Codec {
		private static final String spliter = ",";
		private static final String NN = "X";
		int pos = 0;

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuffer sb = new StringBuffer();
			build(root, sb);
			return sb.toString();
		}

		private void build(TreeNode root, StringBuffer sb) {
			if (root == null)
				sb.append(NN).append(spliter);
			else {
				sb.append(root.val).append(spliter);
				build(root.left,sb);
				build(root.right,sb);
//				sb.append(root.left).append(spliter);
//				sb.append(root.right).append(spliter);
			}
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			List<String> nodes = new ArrayList<>();
			nodes.addAll(Arrays.asList(data.split(spliter)));
			return buildTree(nodes);
		}

		private TreeNode buildTree(List<String> nodes) {
			String str = nodes.get(pos);
			pos++;
			if (str.equals(NN))
				return null;
			else {
				int cur = Integer.valueOf(str);
				TreeNode ret = new TreeNode(cur);
				ret.left = buildTree(nodes);
				ret.right = buildTree(nodes);
				return ret;
			}
		}

	}

}
