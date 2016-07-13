package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.ListNode;
import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月14日上午2:38:32
 */

public class ConvertSortedListToBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		else if (head.next == null)
			return new TreeNode(head.val);
		else if (head.next.next == null) {
			TreeNode ret = new TreeNode(head.next.val);
			ret.left = new TreeNode(head.val);
			return ret;
		} else {
			ListNode fast = head, low = head, before = null;

			while (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				before = low;
				low = low.next;
			}

			TreeNode ret = new TreeNode(low.val);
			before.next = null;
			TreeNode left = sortedListToBST(head);
			TreeNode right = sortedListToBST(low.next);

			ret.left = left;
			ret.right = right;

			return ret;
		}
	}

}
