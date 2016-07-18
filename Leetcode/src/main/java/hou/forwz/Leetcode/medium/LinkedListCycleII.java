package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月19日上午12:42:23
 */

public class LinkedListCycleII {

	public ListNode detectCycle(ListNode head) {

		ListNode low = head, fast = head;

		ListNode circle = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			low = low.next;

			if (fast == low)
				circle = low;
		}

		if (circle == null)
			return null;
		else {
			int len = 0;
			while (low != circle || len == 0) {
				len++;
				low = low.next;
			}

			fast = head;
			low = head;

			while (len > 0) {
				fast = fast.next;
				len--;
			}

			while (fast != low) {
				fast = fast.next;
				low = low.next;
			}

			return low;
		}

	}

}
