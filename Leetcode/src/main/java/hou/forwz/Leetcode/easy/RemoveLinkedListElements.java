package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月23日上午1:25:19
 */

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;

		ListNode ret = new ListNode(-1);
		ret.next = head;

		ListNode p = ret;
		while (p.next != null) {
			if (p.next.val == val) {
				p.next = p.next.next;
			} else
				p = p.next;
		}

		return ret.next;

	}

}
