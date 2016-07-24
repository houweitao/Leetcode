package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月25日上午1:32:29
 */

public class ReverseLinkedListII2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;

		ListNode ret = new ListNode(-1);
		ret.next = head;
		ListNode begin = ret;

		for (int i = 1; i < m; i++) {
			begin = begin.next;
		}

		ListNode first = begin.next;
		ListNode last = first.next;

		for (int i = 0; i < n - m; i++) {
			first.next = last.next;
			last.next = begin.next;
			begin.next = last;

			last = first.next;
//			first = begin.next;
		}

		return ret.next;
	}
}
