package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月14日下午11:45:04
 */

public class RemoveDuplicatesFromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode node = new ListNode(-1);
		node.next = head;

		ListNode low = node, fast = head;

		boolean del = false;
		while (fast != null && fast.next != null) {
			if (fast.val != fast.next.val) {
				if (del) {
					fast = fast.next;
					low.next = fast;
					del = false;
				} else {
					low = low.next;
					fast = fast.next;
				}
			} else {
				del = true;
				fast.next = fast.next.next;
			}
		}

		if (del) {
			low.next = null;
		}

		return node.next;

	}

}
