package hou.forme.GooglePrepare.GooglePrepare.hard;

/**
 * @author houweitao
 * @date 2016年12月16日下午9:07:14
 * @url http://lib.csdn.net/article/datastructure/18407
 */

public class CountOfRangeSum2 {
	Node root;

	public int countRangeSum(int[] nums, int lower, int upper) {
		if (nums == null || nums.length == 0)
			return 0;
		long[] sums = new long[nums.length];
		sums[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
			sums[i] = sums[i - 1] + nums[i];
		root = new Node(nums[0]);
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			// System.out.printf("i=%d, sums[i]=%d\n", i, sums[i]);
			if (lower <= sums[i] && sums[i] <= upper) {
				count++;
				// System.out.printf("1. count=%d\n", count);
			}
			count += sub(root, sums[i] - upper, sums[i] - lower);
			// System.out.printf("2. count=%d\n", count);
			insert(root, sums[i]);
		}
		return count;
	}
	
	private int sub(Node node, long lower, long upper) {
		// System.out.printf("sub=%s, lower=%d, upper=%d\n",
		// node==null?"null":Long.toString(node.val), lower, upper);
		if (node == null)
			return 0;
		if (node.val < lower)
			return sub(node.right, lower, upper);
		if (upper < node.val)
			return sub(node.left, lower, upper);
		return node.count + sub(node.left, lower, node.val - 1) + sub(node.right, node.val + 1, upper);
	}

	private void insert(Node node, long val) {
		if (node.val < val) {
			if (node.right == null)
				node.right = new Node(val);
			insert(node.right, val);
		} else if (val < node.val) {
			if (node.left == null)
				node.left = new Node(val);
			insert(node.left, val);
		} else {
			node.count++;
		}
	}

	class Node {
		long val;
		int count;
		Node left, right;

		Node(long val) {
			this.val = val;
		}
	}

}
