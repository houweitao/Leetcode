package hou.forwz.Leetcode.hard;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月15日上午1:23:47
 */

public class ReverseNodesInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 0 || k == 1)
			return head;
		else {
			ListNode p = head;
			for (int i = 0; i < k - 1; i++) {
				if (p == null)
					return head;
				p = p.next;
			}
			if (p != null) {
				ListNode next = p == null ? null : reverseKGroup(p.next, k);

				p.next = null;
				ListNode ret = new ListNode(-1);
				ListNode last = head;

				while (head != null) {
					ListNode cur = head;
					head = head.next;

					cur.next = ret.next;
					ret.next = cur;
				}

				last.next = next;
				return ret.next;
			} else
				return head;
		}
	}

}
