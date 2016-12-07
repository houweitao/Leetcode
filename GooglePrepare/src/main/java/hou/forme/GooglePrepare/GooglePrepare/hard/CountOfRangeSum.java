//package hou.forme.GooglePrepare.GooglePrepare.hard;
//
///**
// * @author houweitao
// * @date 2016年12月7日下午1:09:51
// */
//
//public class CountOfRangeSum {
//	int count = 0;
//
//	public int countRangeSum(int[] nums, int lower, int upper) {
//		Node root = build(nums, 0, nums.length - 1);
//
//		find(root, lower, upper);
//		return count;
//	}
//
//	private void find(Node root, int lower, int upper) {
//		if (root == null)
//			return;
//		else {
//			if (yes(root.val, lower, upper)) {
//				count++;
//			}
//
//			if (yes(root.sum, lower, upper))
//				count++;
//
//			find(root.left, lower, upper);
//			find(root.right, lower, upper);
//		}
//	}
//
//	private boolean yes(int val, int lower, int upper) {
//		if (val >= lower && val <= upper)
//			return true;
//		else
//			return false;
//	}
//
//	private Node build(int[] nums, int left, int right) {
//		if (left > right)
//			return null;
//		else if (left == right)
//			return new Node(nums[left]);
//		else {
//			int mid = (left + right) / 2;
//			Node ret = new Node(nums[mid]);
//			ret.left = build(nums, left, mid - 1);
//			ret.right = build(nums, mid + 1, right);
//			ret.sum = getSum(ret.left) + getSum(ret.right) + ret.val;
//			return ret;
//		}
//	}
//
//	private int getSum(Node right) {
//		if (right == null)
//			return 0;
//		else
//			return right.sum;
//	}
//
//	class Node {
//		int val;
//		int sum;
//		Node left;
//		Node right;
//
//		public Node(int val) {
//			this.val = val;
//			sum = val;
//		}
//	}
//}
