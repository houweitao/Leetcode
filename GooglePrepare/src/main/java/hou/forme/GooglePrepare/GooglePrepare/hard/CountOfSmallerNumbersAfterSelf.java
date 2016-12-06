package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月6日下午9:59:47
 * @end 2016年12月06日22:36:28
 * @ps 说和做是两回事
 */

public class CountOfSmallerNumbersAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> ret = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return ret;

		Node root = null;
		for (int i = nums.length - 1; i >= 0; i--) {
			root = insert(root, nums[i], 0, ret);
		}

		return ret;
	}

	private Node insert(Node root, int n, int pre, List<Integer> ret) {
		if (root == null) {
			root = new Node(n);
			ret.add(0, pre);
		} else if (root.val == n) {
			root.chongfu++;
			ret.add(0, root.small + pre);
			return root;
		} else if (root.val > n) {
			root.small++;
			root.left = insert(root.left, n, pre, ret);
		} else {
			root.right = insert(root.right, n, pre + root.chongfu + root.small, ret);
		}
		return root;
	}

	class Node {
		int val;
		int small;
		int chongfu;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
			chongfu = 1;
		}

	}
}
