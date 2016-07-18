package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月19日上午12:40:17
 */

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		ListNode low = head, fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			low = low.next;

			if (fast == low)
				return true;
		}

		return false;

	}

}
