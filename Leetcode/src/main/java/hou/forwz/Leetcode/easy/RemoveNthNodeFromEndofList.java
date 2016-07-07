package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月8日上午1:01:44
 */

public class RemoveNthNodeFromEndofList {
	public static void main(String[] args) {
		RemoveNthNodeFromEndofList rn = new RemoveNthNodeFromEndofList();
		ListNode head = new ListNode(1);
		ListNode node = rn.removeNthFromEnd(head, 1);

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node = new ListNode(-1);
		node.next = head;
		ListNode first = node;

		for (int i = 0; i <= n; i++)
			first = first.next;
		ListNode second = node;

		while (first != null && first.next != null) {
			first = first.next;
			second = second.next;
		}

		if (second != null && second.next != null)
			second.next = second.next.next;
		else
			second.next = null;

		return node.next;
	}

}
