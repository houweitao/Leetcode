// package hou.forwz.Leetcode.hard;
//
// import java.util.Arrays;
// import java.util.Deque;
// import java.util.LinkedList;
//
// import hou.forwz.Leetcode.structure.TreeNode;
//
/// **
// * @author houweitao
// * @date 2016年8月13日上午12:54:29
// */
//
// public class SerializeAndDeserializeBinaryTree {
// public static void main(String[] args) {
// SerializeAndDeserializeBinaryTree sa = new
// SerializeAndDeserializeBinaryTree();
// sa.init();
// }
//
// private void init() {
// Codec test = new Codec();
// TreeNode root = new TreeNode(1);
// TreeNode n1 = new TreeNode(2);
// TreeNode n2 = new TreeNode(3);
// TreeNode n3 = new TreeNode(4);
// TreeNode n4 = new TreeNode(5);
// root.left = n1;
// root.right = n2;
// n2.right = n4;
// n1.left = n3;
// System.out.println(test.serialize(root));
// }
//
// /**
// * Definition for a binary tree node. public class TreeNode { int val;
// * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
// */
// public class Codec {
// private static final String spliter = ",";
// private static final String NN = "X";
//
// // Encodes a tree to a single string.
// public String serialize(TreeNode root) {
// StringBuilder sb = new StringBuilder();
// buildString(root, sb);
// return sb.toString();
// }
//
// private void buildString(TreeNode node, StringBuilder sb) {
// if (node == null) {
// sb.append(NN).append(spliter);
// } else {
// sb.append(node.val).append(spliter);
// buildString(node.left, sb);
// buildString(node.right, sb);
// }
// }
//
// // Decodes your encoded data to tree.
// public TreeNode deserialize(String data) {
// Deque<String> nodes = new LinkedList<>();
// nodes.addAll(Arrays.asList(data.split(spliter)));
// return buildTree(nodes);
// }
//
// private TreeNode buildTree(Deque<String> nodes) {
// String val = nodes.remove();
// if (val.equals(NN))
// return null;
// else {
// TreeNode node = new TreeNode(Integer.valueOf(val));
// node.left = buildTree(nodes);
// node.right = buildTree(nodes);
// return node;
// }
// }
// }
//
// // Your Codec object will be instantiated and called as such:
// // Codec codec = new Codec();
// // codec.deserialize(codec.serialize(root));
// }
