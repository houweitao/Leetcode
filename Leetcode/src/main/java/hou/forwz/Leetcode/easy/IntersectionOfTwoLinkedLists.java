package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月25日上午1:23:18
 */

public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p = headA, q = headB;

		int count = 0;
		while (p != null) {
			count++;
			p = p.next;
		}

		while (q != null) {
			count--;
			q = q.next;
		}

		p = headA;
		q = headB;

		if (count > 0) {
			while (count > 0) {
				p = p.next;
				count--;
			}
		}

		if (count < 0) {
			while (count < 0) {
				q = q.next;
				count++;
			}
		}

		while (p != null && q != null) {
			if (p == q)
				return p;
			p = p.next;
			q = q.next;
		}

		return null;

	}

}
