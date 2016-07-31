package hou.forwz.Leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月1日上午12:28:30
 * @url https://discuss.leetcode.com/topic/31405/9ms-short-java-bst-solution-get
 *      -answer-when-building-bst/2
 */

public class CountOfSmallerNumbersAfterSelf2 {
	class Node {
		Node left, right;
		int val, sum, dup = 1;

		public Node(int v, int s) {
			val = v;
			sum = s;
		}
	}

	public List<Integer> countSmallerMe(int[] nums) {
		Integer[] ans = new Integer[nums.length];

		Node root = null;
		for (int i = nums.length - 1; i >= 0; i--) {
			root = insertMe(root, nums[i], i, ans, 0);
		}

		return Arrays.asList(ans);
	}

	private Node insertMe(Node root, int num, int pos, Integer[] ans, int preSum) {

		if (root == null) {
			ans[pos] = 0;
			root = new Node(num, 0);
		} else if (root.val == num) {
			root.dup++;
			ans[pos] = preSum + root.sum;
		} else if (root.val > num) {
			root.sum++;
			root.left = insertMe(root.left, num, pos, ans, preSum);
		} else {
			root.right = insertMe(root.right, num, pos, ans, preSum + root.dup + root.sum);
		}

		return root;
	}

	public List<Integer> countSmaller(int[] nums) {
		Integer[] ans = new Integer[nums.length];
		Node root = null;
		for (int i = nums.length - 1; i >= 0; i--) {
			root = insert(nums[i], root, ans, i, 0);
		}
		return Arrays.asList(ans);
	}

	private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
		if (node == null) {
			node = new Node(num, 0);
			ans[i] = preSum;
		} else if (node.val == num) {
			node.dup++;
			ans[i] = preSum + node.sum;
		} else if (node.val > num) {
			node.sum++;
			node.left = insert(num, node.left, ans, i, preSum);
		} else {
			node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
		}
		return node;
	}
}
