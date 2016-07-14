package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月15日上午12:30:52
 */

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;

		ListNode node = new ListNode(-1);
		node.next = head;
		ListNode before = node;
		ListNode last = node;

		while (before != null && before.next != null) {
			if (before.next.val >= x) {
				last = before.next;
				break;
			}
			before = before.next;
		}
		

		if (before == node)
			return head;

		ListNode p = before;

		while (p != null) {

			if (p.val >= x) {
				last = p;
			} else {
				last.next = p.next;
				p.next = before.next;
				before.next = p;
				before = before.next;
			}

			p = p.next;
		}

		return node.next;
	}

}
